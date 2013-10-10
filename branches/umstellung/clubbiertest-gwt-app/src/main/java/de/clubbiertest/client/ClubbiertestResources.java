/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ClubbiertestResources extends ClientBundle {
    ClubbiertestResources RESOURCES = GWT.create(ClubbiertestResources.class);

    @Source("anfang1.png")
    ImageResource anfang();

    @Source("clubbiertest.css")
    ClubbiertestCss getClubbiertestCss();

    @Source("welcome.css")
    WelcomeCss getWelcomeCss();
}
