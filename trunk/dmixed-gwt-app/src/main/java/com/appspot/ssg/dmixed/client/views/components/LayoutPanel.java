package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.user.client.ui.FlowPanel;

public class LayoutPanel extends FlowPanel {

    public LayoutPanel(final IDMixedCss css) {
	setStyleName(css.layoutpanel());
    }

}
