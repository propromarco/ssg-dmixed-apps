package de.subreport.elvis.shared.ted.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Pattern(TEDPhone.PATTERN)
public @interface TEDPhone {

	String PATTERN = "(\\+\\d{1,3}\\s\\d+(\\-\\d+)*((\\s)?/(\\s)?(\\+\\d{1,3}\\s)?\\d+(\\-\\d+)*)*)";
}
