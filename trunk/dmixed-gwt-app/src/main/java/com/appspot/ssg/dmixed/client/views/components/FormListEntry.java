package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class FormListEntry extends FlowPanel {

    public FormListEntry(final IDMixedCss css, final String description, final Widget foemElement) {
	setStyleName(css.formlistentry());
	final HTML desc = new HTML(description);
	desc.setStyleName(css.formlistentrydesc());
	add(desc);
	add(foemElement);
    }

}
