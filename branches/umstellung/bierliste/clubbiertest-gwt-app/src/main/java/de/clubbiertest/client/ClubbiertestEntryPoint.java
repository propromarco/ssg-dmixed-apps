package de.clubbiertest.client;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.msc.framework.client.mvp.AEntryPoint;
import com.google.msc.framework.client.mvp.IClientFactory;

import de.clubbiertest.client.mvp.CBTLandscapeClientFactory;
import de.clubbiertest.client.mvp.CBTPortraitClientFactory;
import de.clubbiertest.client.mvp.ClubbiertestPlace;

public class ClubbiertestEntryPoint extends AEntryPoint<CBTContext> {

    @Override
    public void onModuleLoad() {
        super.onModuleLoad();
        Window.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(final ResizeEvent event) {
                final String newUrl = Window.Location.getHref();
                Window.Location.replace(newUrl);
            }
        });
    }

    @Override
    protected IClientFactory<CBTContext> createFactory() {
        if (isLandScape()) {
            final ClubbiertestCss clubbiertestCss = ClubbiertestResources.RESOURCES.getCBTLandscapeCss();
            final WelcomeCss welcomeCss = ClubbiertestResources.RESOURCES.getWelcomeCss();
            clubbiertestCss.ensureInjected();
            welcomeCss.ensureInjected();
            final CBTLandscapeClientFactory factory = new CBTLandscapeClientFactory(clubbiertestCss, welcomeCss);
            return factory;
        }
        else {
            final ClubbiertestCss clubbiertestCss = ClubbiertestResources.RESOURCES.getCBTPortraitCss();
            final WelcomeCss welcomeCss = ClubbiertestResources.RESOURCES.getWelcomeCss();
            clubbiertestCss.ensureInjected();
            welcomeCss.ensureInjected();
            final CBTPortraitClientFactory factory = new CBTPortraitClientFactory(clubbiertestCss, welcomeCss);
            return factory;
        }
    }

    private boolean isLandScape() {
        final int height = Window.getClientHeight();
        final int width = Window.getClientWidth();
        return width > height;
    }

    @Override
    protected Place createDefaultPlace() {
        return new ClubbiertestPlace();
    }

}
