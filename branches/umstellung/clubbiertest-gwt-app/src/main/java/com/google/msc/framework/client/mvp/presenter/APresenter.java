package com.google.msc.framework.client.mvp.presenter;

import java.util.ArrayList;
import java.util.Collection;

public abstract class APresenter<V extends AView, I extends IContext> {

    private final V view;
    private boolean bound = false;
    final Collection<APresenter<?, ?>> childs = new ArrayList<APresenter<?, ?>>();
    private final I _context;

    public APresenter(final V view, final I context) {
        this.view = view;
        _context = context;
        this.view.setPresenter(this);
    }

    protected V getView() {
        return view;
    }

    protected I getContext() {
        return _context;
    }

    protected boolean isBound() {
        return bound;
    }

    void bind() {
        if (!isBound()) {
            bound = true;
            onBind();
        }
    }

    protected void onBind() {
    }

    void unbind() {
        if (isBound()) {
            bound = false;
            onUnbind();
        }
    }

    protected void onUnbind() {
    }

    void update() {
        if (isBound()) {
            onUpdate();
        }
    }

    protected void onUpdate() {
    }

    protected void setInSlot(final Slot slot, final APresenter<?, ?> presenter) {
        // Lösen
        final APresenter<?, ?> p = slot.getPresenter();
        childs.remove(p);
        // Hinzufügen
        slot.setPresenter(presenter);
        childs.add(presenter);
    }

}
