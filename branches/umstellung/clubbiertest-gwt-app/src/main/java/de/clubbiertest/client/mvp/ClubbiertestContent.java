package de.clubbiertest.client.mvp;

import com.google.gwt.user.client.ui.FlowPanel;

import de.clubbiertest.client.ClubbiertestCss;

public class ClubbiertestContent extends FlowPanel {

	public ClubbiertestContent(ClubbiertestDataHandler dataHandler) {
		ClubbiertestCss css = dataHandler.getCss();
		setStyleName(css.maincontent());
	}

}
