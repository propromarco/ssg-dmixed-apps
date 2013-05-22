package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.user.client.ui.CheckBox;

public class CssCheckBox extends CheckBox {

    public CssCheckBox(final IDMixedCss css) {
	setStyleName(css.checkbox());
    }

}
