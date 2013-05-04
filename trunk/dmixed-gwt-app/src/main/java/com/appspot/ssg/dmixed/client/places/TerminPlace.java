package com.appspot.ssg.dmixed.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class TerminPlace extends Place {

    private final Long _terminId;
    private final Long userId;

    @Prefix("Termin")
    public static class TerminPlaceTokenizer implements PlaceTokenizer<TerminPlace> {

	@Override
	public TerminPlace getPlace(final String token) {
	    final String[] ids = token.split(":");
	    final Long userId = Long.valueOf(ids[0]);
	    final Long terminId = Long.valueOf(ids[1]);
	    return new TerminPlace(userId, terminId);
	}

	@Override
	public String getToken(final TerminPlace place) {
	    final Long userId = place.getUserId();
	    final Long terminId = place.getTerminId();
	    return userId + ":" + terminId;
	}

    }

    public TerminPlace(final Long userId, final Long terminId) {
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

	if (other instanceof TerminPlace)
	    return true;
	return false;
    }
}
