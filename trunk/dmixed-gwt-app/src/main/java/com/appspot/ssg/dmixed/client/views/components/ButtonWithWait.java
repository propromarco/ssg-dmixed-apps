package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.appspot.ssg.dmixed.client.activities.LoginActivity.WithTapHandlers;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

public class ButtonWithWait extends Composite implements WithTapHandlers {

    private final Button button;

    private final HTML progressBar;

    public ButtonWithWait(final IDMixedCss css, final String text) {
	final FlowPanel panel = new FlowPanel();
	panel.setStyleName(css.button());
	button = new Button(text);
	panel.add(button);
	progressBar = new HTML("Bitte warten...");
	progressBar.setVisible(false);
	panel.add(progressBar);
	initWidget(panel);
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
	return button.addClickHandler(handler);
    }

    @Override
    public void setProgress(final boolean progress) {
	if (progress) {
	    progressBar.setVisible(true);
	    button.setVisible(false);
	} else {
	    progressBar.setVisible(false);
	    button.setVisible(true);
	}
    }

}
