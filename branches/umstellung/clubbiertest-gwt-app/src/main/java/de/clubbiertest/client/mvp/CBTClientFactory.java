package de.clubbiertest.client.mvp;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.msc.framework.client.mvp.AMainPresenter;
import com.google.msc.framework.client.mvp.IClientFactory;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.ClubbiertestResources;
import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.client.WelcomeCss;
import de.clubbiertest.client.mvp.presenter.CBTKontinentePresenter;
import de.clubbiertest.client.mvp.presenter.CBTLaenderPresenter;
import de.clubbiertest.client.mvp.presenter.CBTMainPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSidebarPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSortenPresenter;
import de.clubbiertest.client.mvp.presenter.CBTWelcomePresenter;
import de.clubbiertest.client.mvp.view.CBTKontinenteView;
import de.clubbiertest.client.mvp.view.CBTLaenderView;
import de.clubbiertest.client.mvp.view.CBTMainView;
import de.clubbiertest.client.mvp.view.CBTSidebarView;
import de.clubbiertest.client.mvp.view.CBTSortenView;
import de.clubbiertest.client.mvp.view.CBTWelcomeView;

public class CBTClientFactory implements IClientFactory<ClubbiertestContext>, ClubbiertestContext {

    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final PlaceHistoryMapper placeHistoryMapper;
    private final ClubbiertestCss clubbiertestCss;
    private final ClubbiertestTexte texte;
    private final WelcomeCss welcomeCss;
    private final CBTModel model;

    public CBTClientFactory(final PlaceHistoryMapper placeHistoryMapper) {
        this.placeHistoryMapper = placeHistoryMapper;
        this.texte = ClubbiertestTexte.TEXTE;
        this.clubbiertestCss = ClubbiertestResources.RESOURCES.getClubbiertestCss();
        this.clubbiertestCss.ensureInjected();
        this.welcomeCss = ClubbiertestResources.RESOURCES.getWelcomeCss();
        this.welcomeCss.ensureInjected();
        final StServerCommunicationUtil util = new StServerCommunicationUtil();
        this.model = new CBTModel(util);
    }

    @Override
    public CBTModel getModel() {
        return model;
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public PlaceHistoryMapper getPlaceHistoryMapper() {
        return placeHistoryMapper;
    }

    @Override
    public AMainPresenter<?, ClubbiertestContext> createMainPresenter() {
        final CBTMainView mainView = new CBTMainView(clubbiertestCss);
        final CBTMainPresenter mainPresenter = new CBTMainPresenter(mainView, this);
        return mainPresenter;
    }

    @Override
    public CBTSidebarPresenter createSidebarPresenter() {
        final CBTSidebarView view = new CBTSidebarView(clubbiertestCss, texte);
        final CBTSidebarPresenter sidebarPresenter = new CBTSidebarPresenter(view, this);
        return sidebarPresenter;
    }

    @Override
    public CBTWelcomePresenter createWelcomePresenter() {
        final CBTWelcomeView view = new CBTWelcomeView(clubbiertestCss, welcomeCss);
        final CBTWelcomePresenter welcomePresenter = new CBTWelcomePresenter(view, this);
        return welcomePresenter;
    }

    @Override
    public CBTKontinentePresenter createKontinentPresenter() {
        final CBTKontinenteView view = new CBTKontinenteView(clubbiertestCss);
        final CBTKontinentePresenter kontinentPresenter = new CBTKontinentePresenter(view, this);
        return kontinentPresenter;
    }

    @Override
    public CBTLaenderPresenter createLandPresenter() {
        final CBTLaenderView view = new CBTLaenderView(clubbiertestCss);
        final CBTLaenderPresenter landPresenter = new CBTLaenderPresenter(view, this);
        return landPresenter;
    }

    @Override
    public CBTSortenPresenter createSortePresenter() {
        final CBTSortenView view = new CBTSortenView(clubbiertestCss);
        final CBTSortenPresenter sortePresenter = new CBTSortenPresenter(view, this);
        return sortePresenter;
    }

}
