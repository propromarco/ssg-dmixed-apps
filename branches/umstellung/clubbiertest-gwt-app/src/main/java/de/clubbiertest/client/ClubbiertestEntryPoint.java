package de.clubbiertest.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.msc.framework.client.mvp.presenter.AEntryPoint;
import com.google.msc.framework.client.mvp.presenter.IClientFactory;

import de.clubbiertest.client.mvp.CBTClientFactory;
import de.clubbiertest.client.mvp.ClubbiertestPlace;

public class ClubbiertestEntryPoint extends AEntryPoint<ClubbiertestContext> {

    @Override
    protected IClientFactory<ClubbiertestContext> createFactory() {
        final PlaceHistoryMapper placeHistoryMapper = null;
        final CBTClientFactory factory = new CBTClientFactory(placeHistoryMapper);
        return factory;
    }

    @Override
    protected Place createDefaultPlace() {
        return new ClubbiertestPlace();
    }

}
