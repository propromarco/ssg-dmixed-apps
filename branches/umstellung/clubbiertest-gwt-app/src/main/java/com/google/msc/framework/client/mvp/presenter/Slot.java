package com.google.msc.framework.client.mvp.presenter;

import com.google.gwt.user.client.ui.FlowPanel;

public class Slot extends FlowPanel {

	private APresenter<?> presenter;

	Slot(final String id) {
		getElement().setId(id);
	}

	void setPresenter(final APresenter<?> presenter) {
		this.presenter = presenter;
	}

	APresenter<?> getPresenter() {
		return presenter;
	}

}
