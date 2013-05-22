package com.appspot.ssg.dmixed.client.views.components;

import java.util.Date;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.DateBox;

public class CssDateBox extends DateBox {

    public CssDateBox(final IDMixedCss css) {
	setStyleName(css.datebox());
	setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd.MM.yyyy")));
	setValue(new Date());
    }

}
