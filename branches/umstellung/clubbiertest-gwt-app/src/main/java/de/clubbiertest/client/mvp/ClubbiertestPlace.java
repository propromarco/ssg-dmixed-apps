package de.clubbiertest.client.mvp;

import com.google.gwt.place.shared.Place;

import de.clubbiertest.client.mvp.ClubbiertestDataHandler.Sidebars;

public class ClubbiertestPlace extends Place {

	private Sidebars openSidebar = Sidebars.Kontinente;

	public ClubbiertestPlace() {
	}

	public Sidebars getOpenSidebar() {
		return openSidebar;
	}

	public void setOpenSidebar(Sidebars openSidebar) {
		this.openSidebar = openSidebar;
	}

}
