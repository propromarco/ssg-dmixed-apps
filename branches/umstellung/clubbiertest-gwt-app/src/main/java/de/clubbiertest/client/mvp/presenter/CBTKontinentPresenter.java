package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.presenter.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.CBTKontinentView;

public class CBTKontinentPresenter extends APresenter<CBTKontinentView, ClubbiertestContext> {

    public CBTKontinentPresenter(final CBTKontinentView view, final ClubbiertestContext context) {
        super(view, context);
    }

}
