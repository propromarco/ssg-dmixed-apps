package de.clubbiertest.client;

import com.google.msc.framework.client.mvp.IContext;

import de.clubbiertest.client.mvp.presenter.CBTKontinentPresenter;
import de.clubbiertest.client.mvp.presenter.CBTLandPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSidebarPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSortePresenter;
import de.clubbiertest.client.mvp.presenter.CBTWelcomePresenter;

public interface ClubbiertestContext extends IContext {

    CBTSidebarPresenter createSidebarPresenter();

    CBTWelcomePresenter createWelcomePresenter();

    CBTKontinentPresenter createKontinentPresenter();

    CBTLandPresenter createLandPresenter();

    CBTSortePresenter createSortePresenter();

}
