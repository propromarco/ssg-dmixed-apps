/* Copyright, (c) 2013 Suretec GmbH  */

package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.IDMixedView;
import com.appspot.ssg.dmixed.client.views.components.Header;
import com.appspot.ssg.dmixed.client.views.components.LayoutPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

public abstract class AbstractDmixedView extends Composite implements IDMixedView
{
    protected final IDMixedMessages _messages;
    protected final FlowPanel _layoutPanel;
    private final HTML _headerPanel;

    // private final ProgressBar _progressBar;

    public AbstractDmixedView( final IDMixedMessages messages )
    {
        _messages = messages;
        _layoutPanel = new LayoutPanel();
        initWidget(_layoutPanel);
        _headerPanel = new Header();
        _layoutPanel.add(_headerPanel);
        // _progressBar = new ProgressBar();
        // _progressBar.setVisible(false);
        // _headerPanel.setRightWidget(_progressBar);
    }

    @Override public void setHeaderText( final String headerText )
    {
        _headerPanel.setHTML(headerText);
        _headerPanel.setStyleName("form_header_label");
    }

    @Override public void setProgress( final boolean visible )
    {
        // _progressBar.setVisible(visible);
    }

    @Override public void showMessage( final String message )
    {
        final DialogBox dialogBox = new DialogBox(true, true);
        dialogBox.add(new HTML(message));
        dialogBox.center();
    }

    @Override public void showError( final Throwable exception )
    {
        final DialogBox dialogBox = new DialogBox(true, true);
        dialogBox.add(new HTML(exception.getMessage()));
        dialogBox.center();
    }
}
