package de.subreport.elvis.shared.ted.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Pattern(TEDUrl.PATTERN)
public @interface TEDUrl {

	String PATTERN = "((([hH][tT]{2}[pP][sS]?)://)?[wW]{3}(\\d{1})?\\.[\\w\\?\\./:;\\-_=+#%@&$]+)|(([hH][tT]{2}[pP][sS]?://)[\\w\\?\\./:;\\-_=#+%@&$]+)|([fF][tT][pP][sS]?://[\\w\\?\\./:;\\-_=#+%@&$]+)|([sS][fF][tT][pP]://[\\w\\?\\./:;\\-_=#+%@&$]+)";
}
