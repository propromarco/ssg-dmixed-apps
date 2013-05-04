package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.activities.LoginActivity.LoginView;
import com.appspot.ssg.dmixed.client.activities.TerminActivity;
import com.appspot.ssg.dmixed.client.activities.TerminMitbringActivity;
import com.appspot.ssg.dmixed.client.activities.TerminTeilnahmeActivity;
import com.appspot.ssg.dmixed.client.activities.TermineActivity.TermineView;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {

    EventBus getEventBus();

    PlaceController getPlaceController();

    IDMixedMessages getMessages();

    IDMixedUsecase getService();

    LoginView getLoginView();

    TermineView getTermineView();

    TerminActivity.TerminView getTerminView();

    TerminTeilnahmeActivity.TerminView getTerminTeilnahmeView();

    TerminMitbringActivity.TerminView getTerminMitbringView();
}
