package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;

public class CBTWelcomeView extends AView {

    public CBTWelcomeView(final ClubbiertestCss clubbiertestCss) {
        setStyleName(clubbiertestCss.maincontent());
    }

}
