package de.clubbiertest.client;

import com.google.msc.framework.client.mvp.presenter.IContext;

import de.clubbiertest.client.mvp.presenter.CBTSidebarPresenter;
import de.clubbiertest.client.mvp.presenter.CBTWelcomePresenter;

public interface ClubbiertestContext extends IContext {

    CBTSidebarPresenter createSidebarPresenter();

    CBTWelcomePresenter createWelcomePresenter();

}
