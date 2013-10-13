package de.clubbiertest.client.mvp.view;

import de.clubbiertest.client.ClubbiertestCss;

public class CBTMainListView extends AListView {

    public CBTMainListView(final ClubbiertestCss clubbiertestCss) {
        super(clubbiertestCss);
        setStyleName(clubbiertestCss.maincontent());
    }

}
