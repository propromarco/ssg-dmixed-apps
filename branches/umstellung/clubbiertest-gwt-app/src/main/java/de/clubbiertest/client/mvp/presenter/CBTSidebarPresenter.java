package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.presenter.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.SidebarView;

public class CBTSidebarPresenter extends APresenter<SidebarView, ClubbiertestContext> {

    public CBTSidebarPresenter(final SidebarView view, final ClubbiertestContext context) {
        super(view, context);
    }

}
