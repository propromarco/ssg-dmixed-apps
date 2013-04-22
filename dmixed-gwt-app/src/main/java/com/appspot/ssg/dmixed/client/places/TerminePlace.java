package com.appspot.ssg.dmixed.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TerminePlace extends Place {

    public static class TerminePlaceTokenizer implements PlaceTokenizer<TerminePlace> {

	@Override
	public TerminePlace getPlace(final String token) {
	    return new TerminePlace();
	}

	@Override
	public String getToken(final TerminePlace place) {
	    return "";
	}

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
