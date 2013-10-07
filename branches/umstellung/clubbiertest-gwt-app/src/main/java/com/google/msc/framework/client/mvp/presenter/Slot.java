package com.google.msc.framework.client.mvp.presenter;

import com.google.gwt.user.client.ui.FlowPanel;

public class Slot extends FlowPanel {

	private AbstractPresenter<?, ?> presenter;

	Slot(final String id) {
		getElement().setId(id);
	}

	void setPresenter(final AbstractPresenter<?, ?> presenter) {
		this.presenter = presenter;
	}

	AbstractPresenter<?, ?> getPresenter() {
		return presenter;
	}

}
