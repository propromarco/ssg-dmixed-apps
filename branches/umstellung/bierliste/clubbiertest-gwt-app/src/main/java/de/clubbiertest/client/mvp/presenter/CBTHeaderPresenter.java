package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.view.CBTHeaderView;

public class CBTHeaderPresenter extends APresenter<CBTHeaderView, CBTContext> {

    public CBTHeaderPresenter(final CBTHeaderView view, final CBTContext context) {
        super(view, context);
    }

}
