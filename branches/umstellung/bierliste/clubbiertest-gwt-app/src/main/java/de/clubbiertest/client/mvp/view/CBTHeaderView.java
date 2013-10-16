package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;

public class CBTHeaderView extends AView {

    public CBTHeaderView(final ClubbiertestCss clubbiertestCss) {
        setStyleName(clubbiertestCss.mainheader());
    }

}
