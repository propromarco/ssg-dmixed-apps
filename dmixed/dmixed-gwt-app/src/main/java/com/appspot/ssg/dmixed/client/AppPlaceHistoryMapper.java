package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.places.LoginPlace.HomePlaceTokenizer;
import com.appspot.ssg.dmixed.client.places.TerminPlace.TerminPlaceTokenizer;
import com.appspot.ssg.dmixed.client.places.TerminePlace.TerminePlaceTokenizer;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ HomePlaceTokenizer.class, TerminePlaceTokenizer.class, TerminPlaceTokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
