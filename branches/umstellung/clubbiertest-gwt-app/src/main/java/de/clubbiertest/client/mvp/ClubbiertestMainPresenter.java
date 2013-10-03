package de.clubbiertest.client.mvp;

import com.google.gwt.user.client.ui.FlowPanel;

import de.clubbiertest.client.ClubbiertestCss;

public class ClubbiertestMainPresenter extends FlowPanel {

	public ClubbiertestMainPresenter(ClubbiertestDataHandler dataHandler) {
		ClubbiertestCss css = dataHandler.getCss();
		setStyleName(css.main());
		ClubbiertestSidebar sidebar = new ClubbiertestSidebar(dataHandler);
		add(sidebar);
		ClubbiertestContent content = new ClubbiertestContent(dataHandler);
		add(content);
	}

}
