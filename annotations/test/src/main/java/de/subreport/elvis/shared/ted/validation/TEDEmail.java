package de.subreport.elvis.shared.ted.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Pattern(TEDEmail.PATTERN)
public @interface TEDEmail {

	String PATTERN = "([\\w\\-_]+)(\\.[\\w\\-_]+)*@([\\w\\-_]+\\.){1,5}([A-Za-z]){2,}";

}
