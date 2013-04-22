package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.activities.LoginActivity;
import com.appspot.ssg.dmixed.client.activities.TerminActivity;
import com.appspot.ssg.dmixed.client.activities.TermineActivity;
import com.appspot.ssg.dmixed.client.places.LoginPlace;
import com.appspot.ssg.dmixed.client.places.TerminPlace;
import com.appspot.ssg.dmixed.client.places.TerminePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class PhoneActivityMapper implements ActivityMapper {

    private final ClientFactory _clientFactory;

    public PhoneActivityMapper(final ClientFactory clientFactory) {
	_clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(final Place place) {
	if (place instanceof LoginPlace) {
	    return new LoginActivity(_clientFactory);
	} else if (place instanceof TerminePlace) {
	    return new TermineActivity(_clientFactory);
	} else if (place instanceof TerminPlace) {
	    final TerminPlace terminPlace = (TerminPlace) place;
	    return new TerminActivity(_clientFactory, terminPlace.getTermin());
	}
	return null;
    }

}
