package de.clubbiertest.client.mvp.presenter;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.view.CBTHeaderView;

public class CBTHeaderPresenter extends APresenter<CBTHeaderView, CBTContext> {

    public CBTHeaderPresenter(final CBTHeaderView view, final CBTContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        addHandler(getView().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent event) {
                final String searchText = getView().getSearchText();
                System.out.println(searchText);
            }
        }));
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        final CBTModel model = getContext().getModel();
        final StringBuffer buffer = new StringBuffer();
        final String activeKontinent = model.getActiveKontinent();
        if (activeKontinent != null) {
            buffer.append(activeKontinent);
        }
        final String activeLand = model.getActiveLand();
        if (activeLand != null) {
            buffer.append("&nbsp;&ndash;&nbsp;");
            buffer.append(activeLand);
        }
        final String activeSorte = model.getActiveSorte();
        if (activeSorte != null) {
            buffer.append("&nbsp;&ndash;&nbsp;");
            buffer.append(activeSorte);
        }
        final String info = buffer.toString();
        getView().setNavigationText(info);
    }

}
