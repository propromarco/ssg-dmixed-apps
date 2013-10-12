package de.clubbiertest.client.mvp.presenter;

import java.util.List;

import com.google.msc.framework.client.mvp.APresenter;
import com.google.msc.framework.client.mvp.IContext;

import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.view.AListView;
import de.clubbiertest.client.mvp.view.AListView.IClick;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public abstract class AListPresenter<V extends AListView, I extends IContext> extends APresenter<V, I> {

    public AListPresenter(final V view, final I context) {
        super(view, context);
    }

    protected ICallback<ListeItems> createCallback() {
        getView().clearItems();
        final ICallback<ListeItems> cb = new ICallback<ListeItems>() {

            @Override
            public void onSuccess(final ListeItems data) {
                final List<ListItem> childs = data.getChilds();
                for (final ListItem listItem : childs) {
                    getView().addItem(listItem, new IClick() {
                        @Override
                        public void onClick(final int absoluteTop, final int absoluteLeft) {
                            fireEvent(listItem);
                        }

                    });
                }
                onLoad(data);
            }
        };
        return cb;
    }

    protected abstract void onLoad(ListeItems data);

    protected abstract void fireEvent(ListItem listItem);
}
