package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CBTKontinentEvent extends GwtEvent<CBTKontinentEvent.IKontinentHandler> {

    public interface IKontinentHandler extends EventHandler {
        void onKontinentChanged(CBTKontinentEvent event);
    }

    public static final Type<IKontinentHandler> TYPE = new Type<CBTKontinentEvent.IKontinentHandler>();
    private final String kontinentId;

    public CBTKontinentEvent(final String kontinentId) {
        this.kontinentId = kontinentId;
    }

    public String getKontinentId() {
        return kontinentId;
    }

    @Override
    public Type<IKontinentHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final IKontinentHandler handler) {
        handler.onKontinentChanged(this);
    }

}
