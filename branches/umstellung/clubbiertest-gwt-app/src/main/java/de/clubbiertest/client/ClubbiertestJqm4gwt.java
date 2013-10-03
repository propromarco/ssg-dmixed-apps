/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import de.clubbiertest.client.mvp.ClubbiertestDataHandler;
import de.clubbiertest.client.mvp.ClubbiertestMainPresenter;
import de.clubbiertest.client.mvp.ClubbiertestPlace;

public class ClubbiertestJqm4gwt implements EntryPoint {
	@Override
	public void onModuleLoad() {
		final StServerCommunicationUtil util = new StServerCommunicationUtil();
		ClubbiertestTexte texte = ClubbiertestTexte.TEXTE;
		ClubbiertestResources resources = ClubbiertestResources.RESOURCES;
		ClubbiertestCss css = resources.getClubbiertestCss();
		css.ensureInjected();
		// MVP
		EventBus eventBus = new SimpleEventBus();
		PlaceController placeController = new PlaceController(eventBus);
		ClubbiertestDataHandler mapper = new ClubbiertestDataHandler(util,
				eventBus, css, texte);
		ClubbiertestMainPresenter clubbiertestMainPresenter = new ClubbiertestMainPresenter(
				mapper);
		RootPanel.get().add(clubbiertestMainPresenter);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(mapper);
		ClubbiertestPlace mainPlace = new ClubbiertestPlace();
		historyHandler.register(placeController, eventBus, mainPlace);
		historyHandler.handleCurrentHistory();
		// final JQMWelcomePage page = new JQMWelcomePage(util);
		// JQMContext.changePage(page);
	}
}
