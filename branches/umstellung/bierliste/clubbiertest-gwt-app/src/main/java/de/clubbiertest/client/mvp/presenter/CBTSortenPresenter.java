package de.clubbiertest.client.mvp.presenter;

import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.events.CBTSorteEvent;
import de.clubbiertest.client.mvp.view.CBTSortenView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTSortenPresenter extends AListPresenter<CBTSortenView, ClubbiertestContext> {

    private String lastLand = null;

    public CBTSortenPresenter(final CBTSortenView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        final CBTModel model = getContext().getModel();
        final String activeLand = model.getActiveLand();
        final String activeSorte = model.getActiveSorte();
        if (activeLand != null) {
            final ICallback<ListeItems> cb = createCallback();
            if (lastLand == null) {
                model.loadLand(activeLand, cb);
            }
            else if (!lastLand.equals(activeLand)) {
                model.loadLand(activeLand, cb);
            }
        }
        if (activeSorte != null) {
            getView().select(activeSorte);
        }
    }

    @Override
    protected void onLoad(final ListeItems data) {
        lastLand = data.getId();
    }

    @Override
    protected void fireEvent(final ListItem listItem) {
        final ClubbiertestContext context = getContext();
        final EventBus eventBus = context.getEventBus();
        eventBus.fireEvent(new CBTSorteEvent(listItem.getName()));
    }

}
