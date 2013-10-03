package de.clubbiertest.client.mvp;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.client.StServerCommunicationUtil;

public class ClubbiertestDataHandler implements PlaceHistoryMapper {

	public enum Sidebars {
		Kontinente, Laender, Sorten
	}

	private StServerCommunicationUtil util;
	private EventBus eventBus;
	private ClubbiertestCss css;
	private ClubbiertestTexte texte;

	public ClubbiertestDataHandler(StServerCommunicationUtil util,
			EventBus eventBus, ClubbiertestCss css, ClubbiertestTexte texte) {
		this.util = util;
		this.eventBus = eventBus;
		this.css = css;
		this.texte = texte;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public StServerCommunicationUtil getUtil() {
		return util;
	}

	public ClubbiertestCss getCss() {
		return css;
	}

	public ClubbiertestTexte getTexte() {
		return texte;
	}

	@Override
	public Place getPlace(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToken(Place place) {
		// TODO Auto-generated method stub
		return null;
	}

}
