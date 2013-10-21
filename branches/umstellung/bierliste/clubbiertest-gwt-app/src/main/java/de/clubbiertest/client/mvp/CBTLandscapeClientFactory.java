package de.clubbiertest.client.mvp;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.msc.framework.client.mvp.AMainPresenter;
import com.google.msc.framework.client.mvp.IClientFactory;
import com.google.msc.framework.client.widgets.SearchField.ISearchFieldDesign;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.client.WelcomeCss;
import de.clubbiertest.client.mvp.presenter.CBTBierPresenter;
import de.clubbiertest.client.mvp.presenter.CBTHeaderPresenter;
import de.clubbiertest.client.mvp.presenter.CBTKontinentePresenter;
import de.clubbiertest.client.mvp.presenter.CBTLaenderPresenter;
import de.clubbiertest.client.mvp.presenter.CBTMainListPresenter;
import de.clubbiertest.client.mvp.presenter.CBTMainPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSidebarPresenter;
import de.clubbiertest.client.mvp.presenter.CBTSortenPresenter;
import de.clubbiertest.client.mvp.presenter.CBTWelcomePresenter;
import de.clubbiertest.client.mvp.view.CBTBierView;
import de.clubbiertest.client.mvp.view.CBTHeaderView;
import de.clubbiertest.client.mvp.view.CBTKontinenteView;
import de.clubbiertest.client.mvp.view.CBTLaenderView;
import de.clubbiertest.client.mvp.view.CBTMainListView;
import de.clubbiertest.client.mvp.view.CBTMainView;
import de.clubbiertest.client.mvp.view.CBTSidebarView;
import de.clubbiertest.client.mvp.view.CBTSortenView;
import de.clubbiertest.client.mvp.view.CBTWelcomeView;

public class CBTLandscapeClientFactory implements IClientFactory<CBTContext>, CBTContext, PlaceHistoryMapper {

    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final ClubbiertestCss clubbiertestCss;
    private final ClubbiertestTexte texte;
    private final WelcomeCss welcomeCss;
    private final CBTModel model;
    private final ISearchFieldDesign searchFieldDesign;

    public CBTLandscapeClientFactory(final ClubbiertestCss clubbiertestCss, final WelcomeCss welcomeCss, final ISearchFieldDesign searchFieldDesign) {
        this.clubbiertestCss = clubbiertestCss;
        this.welcomeCss = welcomeCss;
        this.searchFieldDesign = searchFieldDesign;
        this.texte = ClubbiertestTexte.TEXTE;
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
        return this;
    }

    @Override
    public AMainPresenter<?, CBTContext> createMainPresenter() {
        final CBTMainView mainView = new CBTMainView(clubbiertestCss);
        final CBTMainPresenter mainPresenter = new CBTMainPresenter(mainView, this);
        return mainPresenter;
    }

    @Override
    public CBTHeaderPresenter createHeaderPresenter() {
        final CBTHeaderView view = new CBTHeaderView(clubbiertestCss, searchFieldDesign);
        final CBTHeaderPresenter headerPresenter = new CBTHeaderPresenter(view, this);
        return headerPresenter;
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

    @Override
    public CBTMainListPresenter createMainListPresenter() {
        final CBTMainListView view = new CBTMainListView(clubbiertestCss);
        final CBTMainListPresenter mainListPresenter = new CBTMainListPresenter(view, this);
        return mainListPresenter;
    }

    @Override
    public CBTBierPresenter createBierPresenter() {
        final CBTBierView view = new CBTBierView(clubbiertestCss);
        final CBTBierPresenter bierPresenter = new CBTBierPresenter(view, this);
        return bierPresenter;
    }

    @Override
    public Place getPlace(final String token) {
        final String[] split = token.split(":");
        final ClubbiertestPlace place;
        if (split != null)
            place = new ClubbiertestPlace(split);
        else
            place = new ClubbiertestPlace();
        return place;
    }

    @Override
    public String getToken(final Place place) {
        final ClubbiertestPlace clubbiertestPlace = (ClubbiertestPlace) place;
        final StringBuffer buffer = new StringBuffer();
        final String kontinentId = clubbiertestPlace.getKontinentId();
        if (kontinentId != null)
            buffer.append(kontinentId);
        buffer.append(':');
        final String landId = clubbiertestPlace.getLandId();
        if (landId != null)
            buffer.append(landId);
        buffer.append(':');
        final String sorteId = clubbiertestPlace.getSorteId();
        if (sorteId != null)
            buffer.append(sorteId);
        buffer.append(':');
        final String bierId = clubbiertestPlace.getBierId();
        if (bierId != null)
            buffer.append(bierId);
        final String token = buffer.toString();
        return token;
    }

}
