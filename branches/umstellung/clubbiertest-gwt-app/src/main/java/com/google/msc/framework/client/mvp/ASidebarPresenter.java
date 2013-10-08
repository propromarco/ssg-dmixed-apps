package com.google.msc.framework.client.mvp;

public class ASidebarPresenter<V extends AView, I extends IContext> extends APresenter<V, I> {

    public ASidebarPresenter(final V view, final I context) {
        super(view, context);
    }

}
