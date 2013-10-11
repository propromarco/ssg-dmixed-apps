package de.clubbiertest.client.mvp;

import com.google.gwt.place.shared.Place;

import de.clubbiertest.client.mvp.ClubbiertestDataHandler.Sidebars;

public class ClubbiertestPlace extends Place {

    private Sidebars openSidebar = Sidebars.Kontinente;
    private String _kontinentId;
    private String _landId;
    private String _sorteId;

    public ClubbiertestPlace() {
    }

    public ClubbiertestPlace(final String kontinentId, final Sidebars openSidebar) {
        _kontinentId = kontinentId;
        this.openSidebar = openSidebar;
    }

    public ClubbiertestPlace(final String kontinentId, final String landId, final Sidebars openSidebar) {
        _kontinentId = kontinentId;
        _landId = landId;
        this.openSidebar = openSidebar;
    }

    public ClubbiertestPlace(final String kontinentId, final String landId, final String sorteId, final Sidebars openSidebar) {
        _kontinentId = kontinentId;
        _landId = landId;
        _sorteId = sorteId;
        this.openSidebar = openSidebar;
    }

    public Sidebars getOpenSidebar() {
        return openSidebar;
    }

    public void setOpenSidebar(final Sidebars openSidebar) {
        this.openSidebar = openSidebar;
    }

    public String getKontinentId() {
        return _kontinentId;
    }

    public void setKontinentId(final String kontinentId) {
        _kontinentId = kontinentId;
    }

    public String getLandId() {
        return _landId;
    }

    public void setLandId(final String landId) {
        _landId = landId;
    }

    public String getSorteId() {
        return _sorteId;
    }

    public void setSorteId(final String sorteId) {
        _sorteId = sorteId;
    }

}
