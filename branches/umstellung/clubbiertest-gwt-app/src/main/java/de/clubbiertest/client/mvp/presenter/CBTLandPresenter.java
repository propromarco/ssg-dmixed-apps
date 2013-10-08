package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.CBTLandView;

public class CBTLandPresenter extends APresenter<CBTLandView, ClubbiertestContext> {

    public CBTLandPresenter(final CBTLandView view, final ClubbiertestContext context) {
        super(view, context);
    }

}
