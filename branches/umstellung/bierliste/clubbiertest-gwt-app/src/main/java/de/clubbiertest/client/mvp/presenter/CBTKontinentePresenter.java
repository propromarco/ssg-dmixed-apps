package de.clubbiertest.client.mvp.presenter;

import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.events.CBTKontinentEvent;
import de.clubbiertest.client.mvp.view.CBTKontinenteView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTKontinentePresenter extends AListPresenter<CBTKontinenteView, CBTContext> {

    private boolean loaded = false;

    public CBTKontinentePresenter(final CBTKontinenteView view, final CBTContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        checkKontinente();
    }

    private void checkKontinente() {
        final CBTModel model = getContext().getModel();
        if (!loaded) {
            final ICallback<ListeItems> cb = createCallback();
            model.loadKontinente(cb);
        }
        else {
            final String activeKontinent = model.getActiveKontinent();
            getView().select(activeKontinent);
        }
    }

    @Override
    protected void onLoad(final ListeItems data) {
        loaded = true;
    }

    @Override
    protected void fireEvent(final ListItem listItem) {
        final CBTContext context = getContext();
        final EventBus eventBus = context.getEventBus();
        eventBus.fireEvent(new CBTKontinentEvent(listItem.getName()));
    }

}
