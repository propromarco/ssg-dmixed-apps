package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.CBTWelcomeView;

public class CBTWelcomePresenter extends APresenter<CBTWelcomeView, ClubbiertestContext> {

    public CBTWelcomePresenter(final CBTWelcomeView view, final ClubbiertestContext context) {
        super(view, context);
    }

}
