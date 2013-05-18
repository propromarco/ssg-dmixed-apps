package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.activities.LoginActivity.WithTapHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.ProgressBar;

public class ButtonWithWait extends Composite implements WithTapHandlers {

    private final Button button;
    private final ProgressBar progressBar;

    public ButtonWithWait(final String text) {
	final FlowPanel panel = new FlowPanel();
	button = new Button(text);
	panel.add(button);
	progressBar = new ProgressBar();
	progressBar.setVisible(false);
	panel.add(progressBar);
	initWidget(panel);
    }

    @Override
    public HandlerRegistration addTapHandler(final TapHandler handler) {
	return button.addTapHandler(handler);
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
