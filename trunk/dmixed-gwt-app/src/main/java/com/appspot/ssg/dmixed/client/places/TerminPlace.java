package com.appspot.ssg.dmixed.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TerminPlace extends Place {

    private final Long _termin;

    public static class TerminPlaceTokenizer implements PlaceTokenizer<TerminPlace> {

	@Override
	public TerminPlace getPlace(final String token) {
	    final Long terminId = Long.valueOf(token);
	    return new TerminPlace(terminId);
	}

	@Override
	public String getToken(final TerminPlace place) {
	    Long termin = place.getTermin();
	    return termin.toString();
	}

    }

    public TerminPlace(final Long terminId) {
	_termin = terminId;
    }

    public Long getTermin() {
	return _termin;
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
