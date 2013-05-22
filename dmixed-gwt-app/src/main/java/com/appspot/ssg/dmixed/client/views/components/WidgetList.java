package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.user.client.ui.FlowPanel;

public class WidgetList extends FlowPanel {

    public WidgetList(final IDMixedCss css) {
	setStyleName(css.widgetlist());
    }

}
