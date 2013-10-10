package de.clubbiertest.client.mvp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.mvp.ClubbiertestDataHandler.Sidebars;

public class ClubbiertestSidebar extends FlowPanel implements PlaceChangeEvent.Handler {

    private SidebarEntry kontinentEntry, laenderEntry, sortenEntry;
    private EventBus eventBus;
    private HandlerRegistration registration, kRegistration, lRegistration, sRegistration;

    public ClubbiertestSidebar(ClubbiertestDataHandler dataHandler) {
        this.eventBus = dataHandler.getEventBus();
        ClubbiertestCss css = dataHandler.getCss();
        setStyleName(css.sidebar());
        kontinentEntry = new SidebarEntry(dataHandler, "Kontinente", Sidebars.Kontinente);
        laenderEntry = new SidebarEntry(dataHandler, "L&auml;nder", Sidebars.Laender);
        sortenEntry = new SidebarEntry(dataHandler, "Sorten", Sidebars.Sorten);
        add(kontinentEntry.getHeader());
        add(kontinentEntry.getContent());
        add(laenderEntry.getHeader());
        add(laenderEntry.getContent());
        add(sortenEntry.getHeader());
        add(sortenEntry.getContent());
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        registration = eventBus.addHandler(PlaceChangeEvent.TYPE, this);
        kRegistration = kontinentEntry.getHeader().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                openSidebar(Sidebars.Kontinente);
            }
        });
        lRegistration = laenderEntry.getHeader().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                openSidebar(Sidebars.Laender);
            }
        });
        sRegistration = sortenEntry.getHeader().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                openSidebar(Sidebars.Sorten);
            }
        });
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        registration.removeHandler();
        kRegistration.removeHandler();
        lRegistration.removeHandler();
        sRegistration.removeHandler();
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
        ClubbiertestPlace newPlace = (ClubbiertestPlace) event.getNewPlace();
        Sidebars openSidebar = newPlace.getOpenSidebar();
        openSidebar(openSidebar);
    }

    private void openSidebar(Sidebars openSidebar) {
        switch (openSidebar) {
        case Kontinente:
            kontinentEntry.open(true);
            laenderEntry.open(false);
            sortenEntry.open(false);
            break;
        case Laender:
            kontinentEntry.open(false);
            laenderEntry.open(true);
            sortenEntry.open(false);
            break;
        case Sorten:
            kontinentEntry.open(false);
            laenderEntry.open(false);
            sortenEntry.open(true);
            break;
        }
    }
}
