package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.places.TerminePlace;
import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class PhoneAnimationMapper implements AnimationMapper {

    @Override
    public Animation getAnimation(final Place oldPlace, final Place newPlace) {
	if (newPlace instanceof TerminePlace)
	    return Animation.FADE;
	return null;
    }

}
