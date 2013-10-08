package com.google.msc.framework.client.mvp.presenter;

public class AMainPresenter<V extends AView, I extends IContext> extends APresenter<V, I> {

    public AMainPresenter(final V view, final I context) {
        super(view, context);
    }

}
