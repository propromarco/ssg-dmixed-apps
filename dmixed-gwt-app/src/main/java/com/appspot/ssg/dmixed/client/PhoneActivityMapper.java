package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.activities.LoginActivity;
import com.appspot.ssg.dmixed.client.activities.TerminActivity;
import com.appspot.ssg.dmixed.client.activities.TerminMitbringActivity;
import com.appspot.ssg.dmixed.client.activities.TerminTeilnahmeActivity;
import com.appspot.ssg.dmixed.client.activities.TermineActivity;
import com.appspot.ssg.dmixed.client.places.LoginPlace;
import com.appspot.ssg.dmixed.client.places.TerminMitbringPlace;
import com.appspot.ssg.dmixed.client.places.TerminPlace;
import com.appspot.ssg.dmixed.client.places.TerminTeilnahmePlace;
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
	    return new TerminActivity(_clientFactory, terminPlace.getTerminId());
	} else if (place instanceof TerminMitbringPlace) {
	    final TerminMitbringPlace mitbringPlace = (TerminMitbringPlace) place;
	    return new TerminMitbringActivity(_clientFactory, mitbringPlace.getTerminId());
	} else if (place instanceof TerminTeilnahmePlace) {
	    final TerminTeilnahmePlace teilnahmePlace = (TerminTeilnahmePlace) place;
	    return new TerminTeilnahmeActivity(_clientFactory, teilnahmePlace.getTerminId());
	}
	return null;
    }

}
