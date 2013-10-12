package de.clubbiertest.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CBTSorteEvent extends GwtEvent<CBTSorteEvent.ISorteHandler> {

    public interface ISorteHandler extends EventHandler {
        void onSorteChanged(CBTSorteEvent event);
    }

    public static final Type<ISorteHandler> TYPE = new Type<CBTSorteEvent.ISorteHandler>();
    private final String _sorteId;

    public CBTSorteEvent(final String sorteId) {
        _sorteId = sorteId;
    }

    public String getSorteId() {
        return _sorteId;
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
