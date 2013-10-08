package de.clubbiertest.client.mvp;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.msc.framework.client.mvp.presenter.AMainPresenter;
import com.google.msc.framework.client.mvp.presenter.IClientFactory;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.presenter.CBTMainPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSidebarPresenter;
import de.clubbiertest.client.mvp.presenter.CBTWelcomePresenter;
import de.clubbiertest.client.mvp.view.CBTMainView;
import de.clubbiertest.client.mvp.view.CBTWelcomeView;
import de.clubbiertest.client.mvp.view.SidebarView;

public class CBTClientFactory implements IClientFactory<ClubbiertestContext>, ClubbiertestContext {

    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final PlaceHistoryMapper placeHistoryMapper;

    public CBTClientFactory(final PlaceHistoryMapper placeHistoryMapper) {
        this.placeHistoryMapper = placeHistoryMapper;
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
        final CBTMainView mainView = new CBTMainView();
        final CBTMainPresenter mainPresenter = new CBTMainPresenter(mainView, this);
        return mainPresenter;
    }

    @Override
    public CBTSidebarPresenter createSidebarPresenter() {
        final SidebarView view = new SidebarView();
        final CBTSidebarPresenter sidebarPresenter = new CBTSidebarPresenter(view, this);
        return sidebarPresenter;
    }

    @Override
    public CBTWelcomePresenter createWelcomePresenter() {
        final CBTWelcomeView view = new CBTWelcomeView();
        final CBTWelcomePresenter welcomePresenter = new CBTWelcomePresenter(view, this);
        return welcomePresenter;
    }

}
