package de.clubbiertest.client;

import com.google.msc.framework.client.mvp.IContext;

import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.presenter.CBTKontinentePresenter;
import de.clubbiertest.client.mvp.presenter.CBTLaenderPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSidebarPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSortenPresenter;
import de.clubbiertest.client.mvp.presenter.CBTWelcomePresenter;

public interface ClubbiertestContext extends IContext {

    CBTSidebarPresenter createSidebarPresenter();

    CBTWelcomePresenter createWelcomePresenter();

    CBTKontinentePresenter createKontinentPresenter();

    CBTLaenderPresenter createLandPresenter();

    CBTSortenPresenter createSortePresenter();

    CBTModel getModel();

}
