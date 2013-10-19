package de.clubbiertest.client.mvp.presenter;

import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.msc.framework.client.mvp.AMainPresenter;
import com.google.msc.framework.client.mvp.Slot;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.ClubbiertestPlace;
import de.clubbiertest.client.mvp.events.CBTBestenlisteEvent;
import de.clubbiertest.client.mvp.events.CBTBestenlisteEvent.IBestenlisteHandler;
import de.clubbiertest.client.mvp.events.CBTBierEvent;
import de.clubbiertest.client.mvp.events.CBTBierEvent.IBierHandler;
import de.clubbiertest.client.mvp.events.CBTKontinentEvent;
import de.clubbiertest.client.mvp.events.CBTKontinentEvent.IKontinentHandler;
import de.clubbiertest.client.mvp.events.CBTKontinenteEvent;
import de.clubbiertest.client.mvp.events.CBTKontinenteEvent.IKontinenteHandler;
import de.clubbiertest.client.mvp.events.CBTLandEvent;
import de.clubbiertest.client.mvp.events.CBTLandEvent.ILandHandler;
import de.clubbiertest.client.mvp.events.CBTSorteEvent;
import de.clubbiertest.client.mvp.events.CBTSorteEvent.ISorteHandler;
import de.clubbiertest.client.mvp.view.CBTMainView;
import de.clubbiertest.client.mvp.view.CBTSidebarView.Stacks;

public class CBTMainPresenter extends AMainPresenter<CBTMainView, CBTContext> implements IKontinentHandler, ILandHandler, ISorteHandler,
        IBierHandler, IBestenlisteHandler, IKontinenteHandler {

    private CBTMainListPresenter mainListPresenter;
    private CBTWelcomePresenter welcomePresenter;

    public CBTMainPresenter(final CBTMainView view, final CBTContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        final EventBus eventBus = getContext().getEventBus();
        addHandler(eventBus.addHandler(CBTKontinentEvent.TYPE, this));
        addHandler(eventBus.addHandler(CBTLandEvent.TYPE, this));
        addHandler(eventBus.addHandler(CBTSorteEvent.TYPE, this));
        addHandler(eventBus.addHandler(CBTBierEvent.TYPE, this));
        addHandler(eventBus.addHandler(CBTKontinenteEvent.TYPE, this));
        addHandler(eventBus.addHandler(CBTBestenlisteEvent.TYPE, this));

        final CBTContext context = getContext();
        final CBTMainView view = getView();

        final Slot headerSlot = view.getHeaderSlot();
        final CBTHeaderPresenter headerPresenter = context.createHeaderPresenter();
        final Slot sidebarSlot = view.getSidebarSlot();
        setInSlot(headerSlot, headerPresenter);
        final CBTSidebarPresenter sidebarPresenter = context.createSidebarPresenter();
        setInSlot(sidebarSlot, sidebarPresenter);
        this.welcomePresenter = context.createWelcomePresenter();
        this.mainListPresenter = context.createMainListPresenter();
        final Slot bierSlot = view.getBierSlot();
        final CBTBierPresenter bierPresenter = context.createBierPresenter();
        setInSlot(bierSlot, bierPresenter);
    }

    @Override
    protected void onUpdate() {
        final CBTContext context = getContext();
        final CBTModel model = context.getModel();
        final String activeKontinent = model.getActiveKontinent();
        final String activeLand = model.getActiveLand();
        final String activeSorte = model.getActiveSorte();
        final Slot contentSlot = getView().getContentSlot();
        if (activeKontinent != null || activeLand != null || activeSorte != null) {
            setInSlot(contentSlot, mainListPresenter);
        }
        else {
            setInSlot(contentSlot, welcomePresenter);
        }
        super.onUpdate();
    }

    @Override
    public void onPlaceChange(final PlaceChangeEvent event) {
        final ClubbiertestPlace clubbiertestPlace = (ClubbiertestPlace) event.getNewPlace();
        final CBTModel model = getContext().getModel();
        model.setActiveKontinent(clubbiertestPlace.getKontinentId());
        model.setActiveLand(clubbiertestPlace.getLandId());
        model.setActiveSorte(clubbiertestPlace.getSorteId());
        model.setActiveBier(clubbiertestPlace.getBierId());
        model.setOpenSidebar(clubbiertestPlace.getOpenSidebar());
        onUpdate();
    }

    @Override
    public void onKontinentChanged(final CBTKontinentEvent event) {
        final String kontinentId = event.getKontinentId();
        final ClubbiertestPlace place = new ClubbiertestPlace(kontinentId, Stacks.LAENDER);
        getContext().getPlaceController().goTo(place);
    }

    @Override
    public void onLandChanged(final CBTLandEvent event) {
        final String kontinentId = getContext().getModel().getActiveKontinent();
        final String landId = event.getLandId();
        final boolean isSorte = "Deutschland".equals(landId);
        final ClubbiertestPlace place = new ClubbiertestPlace(kontinentId, landId, isSorte ? Stacks.SORTEN : null);
        getContext().getPlaceController().goTo(place);
    }

    @Override
    public void onSorteChanged(final CBTSorteEvent event) {
        final String kontinentId = getContext().getModel().getActiveKontinent();
        final String landId = getContext().getModel().getActiveLand();
        final String sorteId = event.getSorteId();
        final ClubbiertestPlace place = new ClubbiertestPlace(kontinentId, landId, sorteId, null);
        getContext().getPlaceController().goTo(place);
    }

    @Override
    public void onBierChanged(final CBTBierEvent event) {
        final String kontinentId = getContext().getModel().getActiveKontinent();
        final String landId = getContext().getModel().getActiveLand();
        final String sorteId = getContext().getModel().getActiveSorte();
        final String bierId = event.getBierId();
        final ClubbiertestPlace place = new ClubbiertestPlace(kontinentId, landId, sorteId, bierId, null);
        getContext().getPlaceController().goTo(place);
    }

    @Override
    public void onKontinente() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onBestenliste() {
        // TODO Auto-generated method stub
        
    }

}
