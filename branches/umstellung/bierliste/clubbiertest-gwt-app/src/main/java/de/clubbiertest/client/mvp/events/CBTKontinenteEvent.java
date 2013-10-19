package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CBTKontinenteEvent extends GwtEvent<CBTKontinenteEvent.IKontinenteHandler> {

    public interface IKontinenteHandler extends EventHandler {
        void onKontinente();
    }

    public static final Type<IKontinenteHandler> TYPE = new Type<IKontinenteHandler>();

    public CBTKontinenteEvent() {
    }

    @Override
    public Type<IKontinenteHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final IKontinenteHandler handler) {
        handler.onKontinente();
    }

}
