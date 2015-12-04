package de.subreport.elvis.shared.ted.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Pattern(TEDNumberOj.PATTERN)
public @interface TEDNumberOj {

	String PATTERN = "20\\d{2}/S \\d{3}-\\d{6}";
}
