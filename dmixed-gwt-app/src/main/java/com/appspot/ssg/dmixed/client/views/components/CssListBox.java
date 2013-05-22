package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.user.client.ui.ListBox;

public class CssListBox extends ListBox {

    public CssListBox(final IDMixedCss css) {
	setStyleName(css.listbox());
    }

}
