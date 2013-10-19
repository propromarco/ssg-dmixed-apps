package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CBTBestenlisteEvent extends GwtEvent<CBTBestenlisteEvent.IBestenlisteHandler> {

    public interface IBestenlisteHandler extends EventHandler {
        void onBestenliste();
    }

    public static final Type<IBestenlisteHandler> TYPE = new Type<IBestenlisteHandler>();

    public CBTBestenlisteEvent() {
    }

    @Override
    public Type<IBestenlisteHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final IBestenlisteHandler handler) {
        handler.onBestenliste();
    }

}
