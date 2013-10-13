package de.clubbiertest.client.mvp.presenter;

import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.events.CBTLandEvent;
import de.clubbiertest.client.mvp.view.CBTMainListView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTMainListPresenter extends AListPresenter<CBTMainListView, CBTContext> {

    private enum MODE {
        Laender, Sorten, Biere, Bestenliste, Suchergebnisse
    }

    private MODE mode;

    public CBTMainListPresenter(final CBTMainListView view, final CBTContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        checkListen();
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        checkListen();
    }

    private void checkListen() {
        final CBTContext context = getContext();
        final CBTModel model = context.getModel();
        final String activeKontinent = model.getActiveKontinent();
        final String activeLand = model.getActiveLand();
        final String activeSorte = model.getActiveSorte();
        final ICallback<ListeItems> cb = createCallback();
        if (activeSorte != null) {
            // Sorten laden
            model.loadSorte(activeSorte, cb);
            this.mode = MODE.Biere;
        }
        else if (activeLand != null) {
            // Land laden
            model.loadLand(activeLand, cb);
            this.mode = MODE.Biere; // oder Sorten
        }
        else if (activeKontinent != null) {
            // kontinent landen
            model.loadKontinent(activeKontinent, cb);
            this.mode = MODE.Laender;
        }
    }

    @Override
    protected void onLoad(final ListeItems data) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void fireEvent(final ListItem listItem) {
        final CBTContext context = getContext();
        final EventBus eventBus = context.getEventBus();
        switch (mode) {
        case Laender:
            eventBus.fireEvent(new CBTLandEvent(listItem.getName()));
            break;
        case Sorten:
            break;
        case Biere:
            break;
        case Bestenliste:
            break;
        case Suchergebnisse:
            break;
        }
    }

}
