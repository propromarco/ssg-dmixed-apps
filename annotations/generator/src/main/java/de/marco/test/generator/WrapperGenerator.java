package de.marco.test.generator;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.Generated;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import de.marco.test.Wrapper;
import de.marco.test.annotations.Mapping;
import de.marco.test.annotations.MappingMain;

/**
 * Define
 */
public class WrapperGenerator extends AbstractProcessor {

	private final Logger log = Logger.getLogger(getClass().getName());

	private static class WriterWithIndent {

		private final PrintWriter pw;
		private int indent = 0;
		private boolean newLineStarted = true;

		public WriterWithIndent(OutputStream out) {
			pw = new PrintWriter(out);
		}

		private void printIndent() {
			if (newLineStarted) {
				for (int i = 0; i < indent; i++) {
					pw.print("\t");
				}
			}
		}

		public void println() {
			println("");
		}

		public void println(String line) {
			printIndent();
			pw.println(line);
			newLineStarted = true;
		}

		public void print(String part) {
			printIndent();
			pw.print(part);
			newLineStarted = false;
		}

		public void indent() {
			indent++;
		}

		public void outdent() {
			indent--;
		}

		public void close() {
			pw.close();
		}

	}

	/**
	 * could also be done using the annotation {@link SupportedAnnotationTypes} but
	 * this takes stings.
	 */
	private static final Class<?>[] supportedAnnotationClasses = new Class<?>[] { MappingMain.class };

	/**
	 * Adds the defined supported annotation classes in <code>supportedAnnotationClasses</code> to
	 * the set of supported annotation types.
	 */
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		final Set<String> supportedAnnotationTypes = new LinkedHashSet<>();
		for (Class<?> clazz : supportedAnnotationClasses) {
			supportedAnnotationTypes.add(clazz.getCanonicalName());
		}
		return supportedAnnotationTypes;
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		if (roundEnv.processingOver()) {
			return false;
		}
		try {
			final Set<? extends Element> elementsWithAnnotation = roundEnv.getElementsAnnotatedWith(MappingMain.class);
			for (Element element : elementsWithAnnotation) {
				createWrapper(element);
			}
		} catch (Throwable ex) {
			ex.printStackTrace();
			processingEnv.getMessager().printMessage(Kind.ERROR, ex.getMessage());
			return false;
		}
		return true;
	}

	private void createWrapper(Element element) throws Exception {
		final MappingMain mappingMainAnnotation = element.getAnnotation(MappingMain.class);
		final String mappingJaxbClass = mappingMainAnnotation.value();
		final TypeElement jaxbTypeElement = processingEnv.getElementUtils().getTypeElement(mappingJaxbClass);
		final String wrapperClassSuffix = "Wrapper";
		final String wrapperClassNameWithPackage = element.asType().toString() + wrapperClassSuffix;
		final String classNameAnnotatedWithMappingMain = element.getSimpleName().toString();
		final String wrapperClassName = classNameAnnotatedWithMappingMain + wrapperClassSuffix;
		final JavaFileObject wrapperSourceFile = processingEnv.getFiler().createSourceFile(wrapperClassNameWithPackage);
		WriterWithIndent wrapperWriter = new WriterWithIndent(wrapperSourceFile.openOutputStream());
		wrapperWriter.println(processingEnv.getElementUtils().getPackageOf(element).toString() + ";");
		wrapperWriter.println();
		// TODO global imports...
		wrapperWriter.println("import " + Generated.class.getCanonicalName() + ";");
		wrapperWriter.println("import " + Wrapper.class.getCanonicalName() + ";");
		wrapperWriter.println();
		// generation of class
		wrapperWriter.println("@Generated(\"" + WrapperGenerator.class.getCanonicalName() + ".class\")");
		wrapperWriter.println("public class " + wrapperClassName + " implements " + Wrapper.class.getSimpleName() + "<" + mappingJaxbClass + ", " + classNameAnnotatedWithMappingMain + ">");
		wrapperWriter.println("{");
		wrapperWriter.indent();
		wrapperWriter.println("public " + mappingJaxbClass + " wrap(" + classNameAnnotatedWithMappingMain + " element)");
		wrapperWriter.println("{");
		wrapperWriter.indent();
		wrapperWriter.println("final " + mappingJaxbClass + " result = new " + mappingJaxbClass + "();");
		final List<? extends Element> allMembers = processingEnv.getElementUtils().getAllMembers((TypeElement) element);
		final List<ExecutableElement> methods = ElementFilter.methodsIn(allMembers);
		for (ExecutableElement method : methods) {
			final Mapping mappingAnnotation = method.getAnnotation(Mapping.class);
			if (mappingAnnotation == null) {
				continue;
			}
			final String mapping = mappingAnnotation.value();
			final String[] subObjects = mapping.split("\\.");
			final String getObject = "element." + method.getSimpleName().toString();
			final TypeMirror returnType = method.getReturnType();
			boolean simple = isSimple(returnType);
			log.info(returnType + " " + simple);
			if (simple) {// simple
				wrapperWriter.println("if(" + getObject + "() != null) ");
				wrapperWriter.println("{");
				wrapperWriter.indent();
				wrapperWriter.println("result." + getSetMethod(subObjects[0]) + "(" + getObject + "());");
				wrapperWriter.outdent();
				wrapperWriter.println("}");
			} else {// complex
				final TypeMirror nonGenericReturnType = processingEnv.getTypeUtils().erasure(returnType);
				// Think about Iterable instead of Collection
				final TypeElement collectionElement = processingEnv.getElementUtils().getTypeElement(Collection.class.getCanonicalName());
				final boolean collection = processingEnv.getTypeUtils().isAssignable(nonGenericReturnType, collectionElement.asType());
				wrapperWriter.println("if(" + getObject + "() != null)");
				wrapperWriter.println("{");
				wrapperWriter.indent();
				// FIXME recursive create objects...
				wrapperWriter.println("if(result." + getGetMethod(subObjects[0]) + "() == null)");
				wrapperWriter.println("{");
				wrapperWriter.indent();
				TypeMirror subObject = getJaxbObject(jaxbTypeElement, getGetMethod(subObjects[0]));
				if (subObject == null) {
					continue;
				}
				final TypeMirror erasure = processingEnv.getTypeUtils().erasure(subObject);
				if (erasure == null) {
					continue;
				}
				wrapperWriter.println(erasure.toString() + " var = new " + subObject + "();");
				wrapperWriter.println("result." + getSetMethod(subObjects[0]) + "(var);");
				wrapperWriter.outdent();
				wrapperWriter.println("}");
				if (collection) {
					for (int i = 1; i < subObjects.length; i++) {
						subObject = getJaxbObject((TypeElement) processingEnv.getTypeUtils().asElement(subObject), getGetMethod(subObjects[i]));
					}
					wrapperWriter.println(returnType + " dtoList = element." + method.getSimpleName() + "();");
					final TypeMirror innerElement = ((DeclaredType) returnType).getTypeArguments().get(0);
					wrapperWriter.println("for(" + innerElement + " dtoListEntry : dtoList)");
					wrapperWriter.println("{");
					wrapperWriter.indent();
					wrapperWriter.print("result");
					for (String subObject2 : subObjects) {// generate getters
						wrapperWriter.print("." + getGetMethod(subObject2) + "()");
					}
					wrapperWriter.println(".add(new " + innerElement + "Wrapper().wrap(dtoListEntry));");
					wrapperWriter.outdent();
					wrapperWriter.println("}");
				} else {
					wrapperWriter.print("result");
					for (int i = 0; i < subObjects.length - 1; i++) {// generate getters
						wrapperWriter.print("." + getGetMethod(subObjects[i]) + "()");
					}
					wrapperWriter.println("." + getSetMethod(subObjects[subObjects.length - 1] + "(new " + nonGenericReturnType.toString() + "Wrapper().wrap(element." + method.getSimpleName().toString() + "()));"));
				}
				wrapperWriter.outdent();
				wrapperWriter.println("}");
			}
		}
		wrapperWriter.println("return result;");
		wrapperWriter.outdent();
		wrapperWriter.println("}");
		wrapperWriter.outdent();
		wrapperWriter.println("}");
		wrapperWriter.close();
	}

	private boolean isSimple(TypeMirror type) {
		if (type == null) {
			return false;
		}
		boolean isBoolean = isClass(type, Boolean.class);
		boolean isInteger = isClass(type, Integer.class);
		boolean isLong = isClass(type, Long.class);
		boolean isDouble = isClass(type, Double.class);
		boolean isFloat = isClass(type, Float.class);
		boolean isDate = isClass(type, Date.class);
		boolean isString = isClass(type, String.class);
		return isBoolean || isInteger || isLong || isDouble || isFloat || isDate || isString;
	}

	private boolean isClass(TypeMirror type, Class<?> clazz) {
		final Elements elementUtils = processingEnv.getElementUtils();
		final Types typeUtils = processingEnv.getTypeUtils();
		final TypeMirror nonGenericReturnType = typeUtils.erasure(type);
		final TypeElement collectionElement = elementUtils.getTypeElement(clazz.getCanonicalName());
		return typeUtils.isAssignable(nonGenericReturnType, collectionElement.asType());
	}

	private TypeMirror getJaxbObject(TypeElement jaxbTypeElement, String getMethod) {
		final List<? extends Element> allMembers = processingEnv.getElementUtils().getAllMembers(jaxbTypeElement);
		final List<ExecutableElement> methods = ElementFilter.methodsIn(allMembers);
		for (ExecutableElement method : methods) {
			if (method.getSimpleName().toString().equals(getMethod)) {
				return method.getReturnType();
			}
		}
		return null;
	}

	private String getSetMethod(String orig) {
		final String methodPrefix = "set";
		return createMethodName(orig, methodPrefix);
	}

	private String getGetMethod(String orig) {
		final String methodPrefix = "get";
		return createMethodName(orig, methodPrefix);
	}

	protected String createMethodName(String orig, final String methodPrefix) {
		if (orig.isEmpty()) {// To see, that string is missing
			return methodPrefix;
		}
		final char[] charArray = orig.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		String result = methodPrefix + new String(charArray);
		return result;
	}

}
