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
import de.clubbiertest.client.mvp.presenter.CBTKontinentPresenter;
import de.clubbiertest.client.mvp.presenter.CBTLandPresenter;
import de.clubbiertest.client.mvp.presenter.CBTMainPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSidebarPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSortePresenter;
import de.clubbiertest.client.mvp.presenter.CBTWelcomePresenter;
import de.clubbiertest.client.mvp.view.CBTKontinentView;
import de.clubbiertest.client.mvp.view.CBTLandView;
import de.clubbiertest.client.mvp.view.CBTMainView;
import de.clubbiertest.client.mvp.view.CBTSidebarView;
import de.clubbiertest.client.mvp.view.CBTSorteView;
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
    public CBTKontinentPresenter createKontinentPresenter() {
        final CBTKontinentView view = new CBTKontinentView(clubbiertestCss);
        final CBTKontinentPresenter kontinentPresenter = new CBTKontinentPresenter(view, this);
        return kontinentPresenter;
    }

    @Override
    public CBTLandPresenter createLandPresenter() {
        final CBTLandView view = new CBTLandView(clubbiertestCss);
        final CBTLandPresenter landPresenter = new CBTLandPresenter(view, this);
        return landPresenter;
    }

    @Override
    public CBTSortePresenter createSortePresenter() {
        final CBTSorteView view = new CBTSorteView(clubbiertestCss);
        final CBTSortePresenter sortePresenter = new CBTSortePresenter(view, this);
        return sortePresenter;
    }

}
