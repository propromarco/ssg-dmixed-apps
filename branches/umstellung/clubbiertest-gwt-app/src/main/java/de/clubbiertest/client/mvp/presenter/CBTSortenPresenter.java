package de.clubbiertest.client.mvp.presenter;

import java.util.List;

import com.google.msc.framework.client.mvp.APresenter;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.events.CBTSorteEvent;
import de.clubbiertest.client.mvp.view.AListView.IClick;
import de.clubbiertest.client.mvp.view.CBTSortenView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTSortenPresenter extends APresenter<CBTSortenView, ClubbiertestContext> {

    private String lastLand=null;

    public CBTSortenPresenter(final CBTSortenView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        final CBTModel model = getContext().getModel();
        final EventBus eventBus = getContext().getEventBus();
        final String activeLand = model.getActiveLand();
        if (activeLand != null) {
            final ICallback<ListeItems> cb = new ICallback<ListeItems>() {

                @Override
                public void onSuccess(final ListeItems data) {
                    lastLand = data.getId();
                    final List<ListItem> childs = data.getChilds();
                    for (final ListItem listItem : childs) {
                        getView().addItem(listItem, new IClick() {

                            @Override
                            public void onClick(final int absoluteTop, final int absoluteLeft) {
                                eventBus.fireEvent(new CBTSorteEvent(listItem.getName()));
                            }
                        });
                    }
                }
            };
            if (lastLand == null) {
                model.loadLand(activeLand, cb);
            }
            else if (!lastLand.equals(activeLand)) {
                model.loadLand(activeLand, cb);
            }
        }
    }

}
