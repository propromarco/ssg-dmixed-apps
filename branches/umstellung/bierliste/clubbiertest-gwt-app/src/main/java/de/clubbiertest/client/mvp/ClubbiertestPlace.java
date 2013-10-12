package de.clubbiertest.client.mvp;

import com.google.gwt.place.shared.Place;

import de.clubbiertest.client.mvp.view.CBTSidebarView.Stacks;

public class ClubbiertestPlace extends Place {

    private Stacks openSidebar = Stacks.KONTINENTE;
    private String _kontinentId;
    private String _landId;
    private String _sorteId;

    public ClubbiertestPlace() {
    }

    public ClubbiertestPlace(final String[] split) {
        for (int i = 0; i < split.length; i++) {
            final String string = split[i];
            switch (i) {
            case 0:
                _kontinentId = string;
                break;
            case 1:
                _landId = string;
                break;
            case 2:
                _sorteId = string;
                break;
            }
        }
    }

    public ClubbiertestPlace(final String kontinentId, final Stacks openSidebar) {
        _kontinentId = kontinentId;
        this.openSidebar = openSidebar;
    }

    public ClubbiertestPlace(final String kontinentId, final String landId, final Stacks openSidebar) {
        _kontinentId = kontinentId;
        _landId = landId;
        this.openSidebar = openSidebar;
    }

    public ClubbiertestPlace(final String kontinentId, final String landId, final String sorteId, final Stacks openSidebar) {
        _kontinentId = kontinentId;
        _landId = landId;
        _sorteId = sorteId;
        this.openSidebar = openSidebar;
    }

    public Stacks getOpenSidebar() {
        return openSidebar;
    }

    public void setOpenSidebar(final Stacks openSidebar) {
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
