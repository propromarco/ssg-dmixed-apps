package com.appspot.ssg.dmixed.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TerminePlace extends Place {

    private final Long userId;

    public static class TerminePlaceTokenizer implements PlaceTokenizer<TerminePlace> {

	@Override
	public TerminePlace getPlace(final String token) {
	    final Long userId = Long.valueOf(token);
	    return new TerminePlace(userId);
	}

	@Override
	public String getToken(final TerminePlace place) {
	    return place.getUserId().toString();
	}

    }

    public TerminePlace(final Long userId) {
	this.userId = userId;
    }

    public Long getUserId() {
	return userId;
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

	if (other instanceof TerminePlace)
	    return true;
	return false;
    }
}
