package de.clubbiertest.client;

import com.google.gwt.place.shared.Place;
import com.google.msc.framework.client.mvp.AEntryPoint;
import com.google.msc.framework.client.mvp.IClientFactory;

import de.clubbiertest.client.mvp.CBTClientFactory;
import de.clubbiertest.client.mvp.ClubbiertestPlace;

public class ClubbiertestEntryPoint extends AEntryPoint<ClubbiertestContext> {

    @Override
    protected IClientFactory<ClubbiertestContext> createFactory() {
        final CBTClientFactory factory = new CBTClientFactory();
        return factory;
    }

    @Override
    protected Place createDefaultPlace() {
        return new ClubbiertestPlace();
    }

}
