package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CBTLandEvent extends GwtEvent<CBTLandEvent.ILandHandler> {

    public interface ILandHandler extends EventHandler {
        void onLandChanged(CBTLandEvent event);
    }

    public static final Type<ILandHandler> TYPE = new Type<CBTLandEvent.ILandHandler>();
    private final String _landId;

    public CBTLandEvent(final String landId) {
        _landId = landId;
    }

    public String getLandId() {
        return _landId;
    }

    @Override
    public Type<ILandHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ILandHandler handler) {
        handler.onLandChanged(this);
    }

}
