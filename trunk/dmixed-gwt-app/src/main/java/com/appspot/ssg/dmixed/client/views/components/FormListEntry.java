package com.appspot.ssg.dmixed.client.views.components;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class FormListEntry extends FlowPanel {

    public FormListEntry(final String description, final Widget foemElement) {
	setStyleName("formlistentry");
	final HTML desc = new HTML(description);
	desc.setStyleName("formlistentrydesc");
	add(desc);
	add(foemElement);
    }

}
