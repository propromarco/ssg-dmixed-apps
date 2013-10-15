package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CBTBierEvent extends GwtEvent<CBTBierEvent.IBierHandler> {

    public interface IBierHandler extends EventHandler {
        void onBierChanged(CBTBierEvent event);
    }

    public static final Type<IBierHandler> TYPE = new Type<IBierHandler>();
    private final String _bierId;

    public CBTBierEvent(final String bierId) {
        _bierId = bierId;
    }

    public String getBierId() {
        return _bierId;
    }

    @Override
    public Type<IBierHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final IBierHandler handler) {
        handler.onBierChanged(this);
    }

}
