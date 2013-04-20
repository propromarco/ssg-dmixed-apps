package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.IDMixedView;
import com.google.gwt.user.client.ui.Composite;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ProgressBar;

public abstract class AbstractDmixedView extends Composite implements IDMixedView {

    protected final IDMixedMessages _messages;
    protected final LayoutPanel _layoutPanel;
    private final HeaderPanel _headerPanel;
    private final ProgressBar _progressBar;

    public AbstractDmixedView(final IDMixedMessages messages) {
        _messages = messages;
        _layoutPanel = new LayoutPanel();
        initWidget(_layoutPanel);
        _headerPanel = new HeaderPanel();
        _layoutPanel.add(_headerPanel);
        _progressBar = new ProgressBar();
        _progressBar.setVisible(false);
        _headerPanel.setRightWidget(_progressBar);
    }

    @Override
    public void setHeaderText(final String headerText) {
        _headerPanel.setCenter(headerText);
    }

    @Override
    public void setProgress(final boolean visible) {
        _progressBar.setVisible(visible);
    }

}
