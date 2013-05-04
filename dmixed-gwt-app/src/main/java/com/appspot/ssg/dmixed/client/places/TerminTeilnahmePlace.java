package com.appspot.ssg.dmixed.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class TerminTeilnahmePlace extends Place {

    private final Long _terminId;
    private final Long userId;

    @Prefix("TerminTeilnahme")
    public static class TerminTeilnahmePlaceTokenizer implements PlaceTokenizer<TerminTeilnahmePlace> {

	@Override
	public TerminTeilnahmePlace getPlace(final String token) {
	    final String[] ids = token.split(":");
	    final Long userId = Long.valueOf(ids[0]);
	    final Long terminId = Long.valueOf(ids[1]);
	    return new TerminTeilnahmePlace(userId, terminId);
	}

	@Override
	public String getToken(final TerminTeilnahmePlace place) {
	    final Long userId = place.getUserId();
	    final Long terminId = place.getTerminId();
	    return userId + ":" + terminId;
	}

    }

    public TerminTeilnahmePlace(final Long userId, final Long terminId) {
	this.userId = userId;
	_terminId = terminId;
    }

    public Long getUserId() {
	return userId;
    }

    public Long getTerminId() {
	return _terminId;
    }

    @Override
    public int hashCode() {
	return 4;
    }

    @Override
    public boolean equals(final Object other) {
	if (other == this)
	    return true;
	if (other == null)
	    return false;

	if (other instanceof TerminTeilnahmePlace)
	    return true;
	return false;
    }
}
