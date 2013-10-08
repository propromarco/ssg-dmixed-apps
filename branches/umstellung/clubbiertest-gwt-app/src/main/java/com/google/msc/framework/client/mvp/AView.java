package com.google.msc.framework.client.mvp;

import com.google.gwt.user.client.ui.FlowPanel;

public abstract class AView extends FlowPanel {

    private APresenter<?, ?> _presenter;

    protected Slot createSlot(final String id) {
        return new Slot(id);
    }

    void setPresenter(final APresenter<?, ?> presenter) {
        _presenter = presenter;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        _presenter.bind();
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        _presenter.unbind();
    }

}
