package de.clubbiertest.client.mvp.presenter;

import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.msc.framework.client.mvp.AMainPresenter;
import com.google.msc.framework.client.mvp.Slot;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.ClubbiertestDataHandler.Sidebars;
import de.clubbiertest.client.mvp.ClubbiertestPlace;
import de.clubbiertest.client.mvp.events.CBTKontinentEvent;
import de.clubbiertest.client.mvp.events.CBTKontinentEvent.IKontinentHandler;
import de.clubbiertest.client.mvp.events.CBTLandEvent.ILandHandler;
import de.clubbiertest.client.mvp.events.CBTSorteEvent.ISorteHandler;
import de.clubbiertest.client.mvp.events.CBTLandEvent;
import de.clubbiertest.client.mvp.events.CBTSorteEvent;
import de.clubbiertest.client.mvp.view.CBTMainView;

public class CBTMainPresenter extends AMainPresenter<CBTMainView, ClubbiertestContext> implements IKontinentHandler, ILandHandler, ISorteHandler {

    public CBTMainPresenter(final CBTMainView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        final EventBus eventBus = getContext().getEventBus();
        addHandler(eventBus.addHandler(CBTKontinentEvent.TYPE, this));
        addHandler(eventBus.addHandler(CBTLandEvent.TYPE, this));
        addHandler(eventBus.addHandler(CBTSorteEvent.TYPE, this));

        final ClubbiertestContext context = getContext();
        final CBTMainView view = getView();
        final Slot sidebarSlot = view.getSidebarSlot();
        final CBTSidebarPresenter sidebarPresenter = context.createSidebarPresenter();
        setInSlot(sidebarSlot, sidebarPresenter);
        final Slot contentSlot = view.getContentSlot();
        final CBTWelcomePresenter welcomePresenter = context.createWelcomePresenter();
        setInSlot(contentSlot, welcomePresenter);
    }

    @Override
    public void onPlaceChange(final PlaceChangeEvent event) {
        final ClubbiertestPlace clubbiertestPlace = (ClubbiertestPlace) event.getNewPlace();
        final CBTModel model = getContext().getModel();
        model.setActiveKontinent(clubbiertestPlace.getKontinentId());
        model.setActiveLand(clubbiertestPlace.getLandId());
        model.setActiveSorte(clubbiertestPlace.getSorteId());
        super.onUpdate();
    }

    @Override
    public void onKontinentChanged(final CBTKontinentEvent event) {
        final String kontinentId = event.getKontinentId();
        final ClubbiertestPlace place = new ClubbiertestPlace(kontinentId, Sidebars.Laender);
        getContext().getPlaceController().goTo(place);
    }

    @Override
    public void onLandChanged(final CBTLandEvent event) {
        final String kontinentId = getContext().getModel().getActiveKontinent();
        final String landId = event.getLandId();
        final ClubbiertestPlace place = new ClubbiertestPlace(kontinentId, landId, Sidebars.Sorten);
        getContext().getPlaceController().goTo(place);
    }

    @Override
    public void onSorteChanged(final CBTSorteEvent event) {
        final String kontinentId = getContext().getModel().getActiveKontinent();
        final String landId = getContext().getModel().getActiveLand();
        final String sorteId = event.getSorteId();
        final ClubbiertestPlace place = new ClubbiertestPlace(kontinentId, landId, sorteId, Sidebars.Laender);
        getContext().getPlaceController().goTo(place);
    }

}
