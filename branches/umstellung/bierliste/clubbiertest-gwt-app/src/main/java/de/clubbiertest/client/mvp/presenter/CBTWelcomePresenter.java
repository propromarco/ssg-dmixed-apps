package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.view.CBTWelcomeView;

public class CBTWelcomePresenter extends APresenter<CBTWelcomeView, CBTContext> {

    public CBTWelcomePresenter(final CBTWelcomeView view, final CBTContext context) {
        super(view, context);
    }

}
