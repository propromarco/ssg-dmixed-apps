package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import de.clubbiertest.liste.shared.ListItem;

public class CBTLandEvent extends GwtEvent<CBTLandEvent.ILandHandler> {

    public interface ILandHandler extends EventHandler {
        void onLandChanged(CBTLandEvent event);
    }

    public static final Type<ILandHandler> TYPE = new Type<CBTLandEvent.ILandHandler>();
    private final ListItem item;

    public CBTLandEvent(final ListItem item) {
        this.item = item;
    }

    public ListItem getItem() {
        return item;
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
