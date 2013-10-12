package com.google.msc.framework.client.mvp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.web.bindery.event.shared.HandlerRegistration;

public abstract class APresenter<V extends AView, I extends IContext> {

    private final V view;
    private boolean bound = false;
    final Collection<APresenter<?, ?>> childs = new ArrayList<APresenter<?, ?>>();
    private final I _context;
    private final List<HandlerRegistration> registrations = new ArrayList<HandlerRegistration>();

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
        for (final HandlerRegistration registration : registrations) {
            registration.removeHandler();
        }
    }

    void update() {
        if (isBound()) {
            onUpdate();
        }
    }

    protected void onUpdate() {
        for (final APresenter<?, ?> child : childs) {
            child.update();
        }
    }

    protected void setInSlot(final Slot slot, final APresenter<?, ?> presenter) {
        // Lösen
        final APresenter<?, ?> p = slot.getPresenter();
        childs.remove(p);
        // Hinzufügen
        slot.setPresenter(presenter);
        childs.add(presenter);
    }

    protected void addHandler(final HandlerRegistration registration) {
        registrations.add(registration);
    }

}
