package com.appspot.ssg.dmixed.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class LoginPlace extends Place {

    @Prefix("Home")
    public static class HomePlaceTokenizer implements PlaceTokenizer<LoginPlace> {

	@Override
	public LoginPlace getPlace(final String token) {
	    return new LoginPlace();
	}

	@Override
	public String getToken(final LoginPlace place) {
	    return "";
	}

    }

    @Override
    public int hashCode() {
	return 3;
    }

    @Override
    public boolean equals(final Object other) {
	if (other == this)
	    return true;
	if (other == null)
	    return false;

	if (other instanceof LoginPlace)
	    return true;
	return false;
    }
}
