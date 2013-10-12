package de.clubbiertest.client.mvp.presenter;

import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.events.CBTLandEvent;
import de.clubbiertest.client.mvp.view.CBTLaenderView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTLaenderPresenter extends AListPresenter<CBTLaenderView, ClubbiertestContext> {

    private String lastKontinent = null;

    public CBTLaenderPresenter(final CBTLaenderView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        final CBTModel model = getContext().getModel();
        final String activeKontinent = model.getActiveKontinent();
        final String activeLand = model.getActiveLand();
        if (activeKontinent != null) {
            final ICallback<ListeItems> cb = createCallback();
            if (lastKontinent == null) {
                model.loadKontinent(activeKontinent, cb);
            }
            else if (!lastKontinent.equals(activeKontinent)) {
                model.loadKontinent(activeKontinent, cb);
            }
        }
        if (activeLand != null) {
            getView().select(activeLand);
        }
    }

    @Override
    protected void onLoad(final ListeItems data) {
        lastKontinent = data.getId();
    }

    @Override
    protected void fireEvent(final ListItem listItem) {
        final ClubbiertestContext context = getContext();
        final EventBus eventBus = context.getEventBus();
        eventBus.fireEvent(new CBTLandEvent(listItem.getName()));
    }

}
