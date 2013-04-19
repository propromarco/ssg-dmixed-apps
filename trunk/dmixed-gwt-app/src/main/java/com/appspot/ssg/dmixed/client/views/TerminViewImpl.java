package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView;
import com.google.gwt.user.client.ui.Composite;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

public class TerminViewImpl extends Composite implements TerminView {

    private final LayoutPanel _layoutPanel;
    private final ClientFactory _clientFactory;

    public TerminViewImpl(final ClientFactory clientFactory) {
        _clientFactory = clientFactory;
        _layoutPanel = new LayoutPanel();
        initWidget(_layoutPanel);
    }

}
