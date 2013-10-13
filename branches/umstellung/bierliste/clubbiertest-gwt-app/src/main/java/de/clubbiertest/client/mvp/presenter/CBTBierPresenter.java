package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.view.CBTBierView;

public class CBTBierPresenter extends APresenter<CBTBierView, CBTContext> {

    public CBTBierPresenter(final CBTBierView view, final CBTContext context) {
        super(view, context);
    }

}
