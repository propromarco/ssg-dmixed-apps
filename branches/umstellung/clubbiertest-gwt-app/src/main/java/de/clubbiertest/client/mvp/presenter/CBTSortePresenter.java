package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.CBTSorteView;

public class CBTSortePresenter extends APresenter<CBTSorteView, ClubbiertestContext> {

    public CBTSortePresenter(final CBTSorteView view, final ClubbiertestContext context) {
        super(view, context);
    }

}
