package de.clubbiertest.client;

import com.google.gwt.place.shared.Place;
import com.google.msc.framework.client.mvp.AEntryPoint;
import com.google.msc.framework.client.mvp.IClientFactory;

import de.clubbiertest.client.mvp.CBTClientFactory;
import de.clubbiertest.client.mvp.ClubbiertestPlace;

public class ClubbiertestEntryPoint extends AEntryPoint<CBTContext> {

    @Override
    protected IClientFactory<CBTContext> createFactory() {
        final ClubbiertestCss clubbiertestCss = ClubbiertestResources.RESOURCES.getClubbiertestCss();
        final WelcomeCss welcomeCss = ClubbiertestResources.RESOURCES.getWelcomeCss();
        clubbiertestCss.ensureInjected();
        welcomeCss.ensureInjected();
        final CBTClientFactory factory = new CBTClientFactory(clubbiertestCss, welcomeCss);
        return factory;
    }

    @Override
    protected Place createDefaultPlace() {
        return new ClubbiertestPlace();
    }

}
