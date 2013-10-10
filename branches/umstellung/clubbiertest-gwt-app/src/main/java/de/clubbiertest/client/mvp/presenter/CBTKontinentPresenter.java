package de.clubbiertest.client.mvp.presenter;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.view.CBTKontinentView;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTKontinentPresenter extends APresenter<CBTKontinentView, ClubbiertestContext> {

    private boolean loaded = false;

    public CBTKontinentPresenter(final CBTKontinentView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        if (!loaded) {
            final CBTModel model = getContext().getModel();
            getView().clearItems();
            final ICallback<ListeItems> cb = new ICallback<ListeItems>() {

                @Override
                public void onSuccess(final ListeItems data) {
                    final List<ListItem> childs = data.getChilds();
                    for (final ListItem listItem : childs) {
                        getView().addItem(listItem, new ClickHandler() {

                            @Override
                            public void onClick(final ClickEvent event) {
                                model.selectKontinent(listItem.getId());
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
