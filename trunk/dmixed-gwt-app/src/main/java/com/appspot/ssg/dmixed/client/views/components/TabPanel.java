package com.appspot.ssg.dmixed.client.views.components;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class TabPanel extends FlowPanel {

    private final FlowPanel header;
    private final FlowPanel body;
    private boolean isStart = true;

    public TabPanel() {
	setStyleName("tabpanel");
	this.header = new FlowPanel();
	header.setStyleName("tabpanelheader");
	add(header);
	this.body = new FlowPanel();
	body.setStyleName("tabpanelbody");
	add(body);
    }

    public void add(final Anchor menu, final Widget container) {
	header.add(menu);
	menu.addClickHandler(new ClickHandler() {
	    @Override
	    public void onClick(final ClickEvent event) {
		body.clear();
		body.add(container);
		clearSelectStyles();
		select(menu);
	    }

	});
	if (isStart) {
	    isStart = false;
	    body.add(container);
	    select(menu);
	}
    }

    private void select(final Anchor menu) {
	menu.addStyleName("selected");
    }

    private void clearSelectStyles() {
	final int widgetCount = header.getWidgetCount();
	for (int i = 0; i < widgetCount; i++) {
	    final Widget widget = header.getWidget(i);
	    widget.removeStyleName("selected");
	}
    }

}
