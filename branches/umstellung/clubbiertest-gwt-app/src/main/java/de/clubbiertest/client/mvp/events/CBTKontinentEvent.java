package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import de.clubbiertest.liste.shared.ListItem;

public class CBTKontinentEvent extends GwtEvent<CBTKontinentEvent.IKontinentHandler> {

    public interface IKontinentHandler extends EventHandler {
        void onKontinentChanged(CBTKontinentEvent event);
    }

    public static final Type<IKontinentHandler> TYPE = new Type<CBTKontinentEvent.IKontinentHandler>();
    private final ListItem item;

    public CBTKontinentEvent(final ListItem item) {
        this.item = item;
    }

    public ListItem getItem() {
        return item;
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
