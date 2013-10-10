package de.clubbiertest.client.mvp;

import com.google.gwt.user.client.ui.FlowPanel;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.mvp.ClubbiertestDataHandler.Sidebars;

public class SidebarContent extends FlowPanel {

    private Sidebars type;

    public SidebarContent(ClubbiertestDataHandler dataHandler, Sidebars type) {
        this.type = type;
        ClubbiertestCss css = dataHandler.getCss();
        setStyleName(css.content());
    }

}
