package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.CBTSortenView;

public class CBTSortenPresenter extends APresenter<CBTSortenView, ClubbiertestContext> {

    public CBTSortenPresenter(final CBTSortenView view, final ClubbiertestContext context) {
        super(view, context);
    }

}
