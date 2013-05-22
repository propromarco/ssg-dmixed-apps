package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.user.client.ui.TextArea;

public class CssTextArea extends TextArea {

    public CssTextArea(final IDMixedCss css) {
	setStyleName(css.textarea());
    }

}
