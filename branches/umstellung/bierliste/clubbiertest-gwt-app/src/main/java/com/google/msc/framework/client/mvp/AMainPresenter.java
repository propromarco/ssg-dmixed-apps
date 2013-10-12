package com.google.msc.framework.client.mvp;

import com.google.gwt.place.shared.PlaceChangeEvent;

public abstract class AMainPresenter<V extends AView, I extends IContext> extends APresenter<V, I> implements PlaceChangeEvent.Handler {

    public AMainPresenter(final V view, final I context) {
        super(view, context);
        context.getEventBus().addHandler(PlaceChangeEvent.TYPE, this);
    }

}
