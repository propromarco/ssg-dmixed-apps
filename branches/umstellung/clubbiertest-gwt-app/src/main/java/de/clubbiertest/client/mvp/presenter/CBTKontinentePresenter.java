package de.clubbiertest.client.mvp.presenter;

import java.util.List;

import com.google.msc.framework.client.mvp.APresenter;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.events.CBTKontinentEvent;
import de.clubbiertest.client.mvp.view.AListView.IClick;
import de.clubbiertest.client.mvp.view.CBTKontinenteView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTKontinentePresenter extends APresenter<CBTKontinenteView, ClubbiertestContext> {

    private boolean loaded = false;

    public CBTKontinentePresenter(final CBTKontinenteView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        if (!loaded) {
            final CBTModel model = getContext().getModel();
            final EventBus eventBus = getContext().getEventBus();
            getView().clearItems();
            final ICallback<ListeItems> cb = new ICallback<ListeItems>() {

                @Override
                public void onSuccess(final ListeItems data) {
                    final List<ListItem> childs = data.getChilds();
                    for (final ListItem listItem : childs) {
                        getView().addItem(listItem, new IClick() {
                            @Override
                            public void onClick(final int absoluteTop, final int absoluteLeft) {
                                eventBus.fireEvent(new CBTKontinentEvent(listItem.getId()));
                            }
                        });
                    }
                    loaded = true;
                }
            };
            model.loadKontinente(cb);
        }
    }

}
