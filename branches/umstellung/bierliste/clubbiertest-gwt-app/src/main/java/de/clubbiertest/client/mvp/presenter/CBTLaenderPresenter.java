package de.clubbiertest.client.mvp.presenter;

import java.util.List;

import com.google.msc.framework.client.mvp.APresenter;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.events.CBTLandEvent;
import de.clubbiertest.client.mvp.view.AListView.IClick;
import de.clubbiertest.client.mvp.view.CBTLaenderView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTLaenderPresenter extends APresenter<CBTLaenderView, ClubbiertestContext> {

    private String lastKontinent = null;

    public CBTLaenderPresenter(final CBTLaenderView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        final CBTModel model = getContext().getModel();
        final EventBus eventBus = getContext().getEventBus();
        final String activeKontinent = model.getActiveKontinent();
        if (activeKontinent != null) {
            final ICallback<ListeItems> cb = new ICallback<ListeItems>() {
                @Override
                public void onSuccess(final ListeItems data) {
                    getView().clearItems();
                    lastKontinent = data.getId();
                    final List<ListItem> childs = data.getChilds();
                    for (final ListItem listItem : childs) {
                        getView().addItem(listItem, new IClick() {

                            @Override
                            public void onClick(final int absoluteTop, final int absoluteLeft) {
                                eventBus.fireEvent(new CBTLandEvent(listItem.getName()));
                            }
                        });
                    }
                }
            };
            if (lastKontinent == null) {
                model.loadKontinent(activeKontinent, cb);
            }
            else if (!lastKontinent.equals(activeKontinent)) {
                model.loadKontinent(activeKontinent, cb);
            }
        }
    }

}
