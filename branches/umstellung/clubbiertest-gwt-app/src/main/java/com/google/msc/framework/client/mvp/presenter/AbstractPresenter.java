package com.google.msc.framework.client.mvp.presenter;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractPresenter<V extends IView, C extends IPresenterContext> {

	private final V view;
	private C context;
	private boolean bound = false, activated = false;
	final Collection<AbstractPresenter<?, ?>> childs = new ArrayList<AbstractPresenter<?, ?>>();

	public AbstractPresenter(final V view) {
		this.view = view;
	}

	protected V getView() {
		return view;
	}

	protected boolean isBound() {
		return bound;
	}

	void setContext(final C context) {
		this.context = context;
	}

	void bind() {
		if (!isBound()) {
			bound = true;
			onBind(context);
		}
	}

	protected void onBind(final C context) {
	}

	void unbind() {
		if (isBound()) {
			bound = false;
			onUnbind();
		}
	}

	protected void onUnbind() {
	}

	void activate() {
		if (isBound() && !activated) {
			activated = true;
			onActivate();
		}
	}

	protected void onActivate() {
	}

	void deactivate() {
		if (isBound() && activated) {
			activated = false;
			onDeactivate();
		}
	}

	protected void onDeactivate() {
	}

	void update() {
		if (isBound()) {
			onUpdate();
		}
	}

	protected void onUpdate() {
	}

	protected void setInSlot(final Slot slot,
			final AbstractPresenter<?, ?> presenter) {
		final AbstractPresenter<?, ?> oldPresenter = slot.getPresenter();
		if (oldPresenter != null) {
			oldPresenter.deactivate();
			oldPresenter.unbind();
		}
		slot.setPresenter(presenter);
		childs.add(presenter);
		presenter.bind();
		presenter.activate();
	}

}
