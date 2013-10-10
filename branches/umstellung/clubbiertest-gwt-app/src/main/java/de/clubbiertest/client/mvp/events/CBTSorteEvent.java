package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import de.clubbiertest.liste.shared.ListItem;

public class CBTSorteEvent extends GwtEvent<CBTSorteEvent.ISorteHandler> {

    public interface ISorteHandler extends EventHandler {
        void onSorteChanged(CBTSorteEvent event);
    }

    public static final Type<ISorteHandler> TYPE = new Type<CBTSorteEvent.ISorteHandler>();
    private final ListItem item;

    public CBTSorteEvent(final ListItem item) {
        this.item = item;
    }

    public ListItem getItem() {
        return item;
    }

    @Override
    public Type<ISorteHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ISorteHandler handler) {
        handler.onSorteChanged(this);
    }

}
