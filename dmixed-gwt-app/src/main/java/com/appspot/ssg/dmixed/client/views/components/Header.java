package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.user.client.ui.HTML;

public class Header extends HTML {

    public Header(final IDMixedCss css) {
	setStyleName(css.header());
    }

}
