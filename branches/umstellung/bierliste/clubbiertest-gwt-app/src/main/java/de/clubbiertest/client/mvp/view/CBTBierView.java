package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;

public class CBTBierView extends AView {

    public CBTBierView(final ClubbiertestCss clubbiertestCss) {
        setStyleName(clubbiertestCss.bierInfo());
    }

}
