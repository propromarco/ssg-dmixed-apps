package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.activities.LoginActivity.LoginView;
import com.appspot.ssg.dmixed.client.activities.TerminActivity;
import com.appspot.ssg.dmixed.client.activities.TerminMitbringActivity;
import com.appspot.ssg.dmixed.client.activities.TerminTeilnahmeActivity;
import com.appspot.ssg.dmixed.client.activities.TermineActivity.TermineView;
import com.appspot.ssg.dmixed.client.model.DMixedUsecaseConnector;
import com.appspot.ssg.dmixed.client.views.LoginViewImpl;
import com.appspot.ssg.dmixed.client.views.TerminMitbringViewImpl;
import com.appspot.ssg.dmixed.client.views.TerminTeilnahmeViewImpl;
import com.appspot.ssg.dmixed.client.views.TerminViewImpl;
import com.appspot.ssg.dmixed.client.views.TermineViewImpl;
import com.appspot.ssg.dmixed.shared.DMixedUrlCreator;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {

    private final SimpleEventBus eventBus;
    private final PlaceController placeController;
    private final IDMixedMessages messages = GWT.create(IDMixedMessages.class);
    private final String baseUrl = GWT.getHostPageBaseURL();
    private final DMixedUrlCreator urlCreator = new DMixedUrlCreator(baseUrl);
    private final IDMixedUsecase service = new DMixedUsecaseConnector(urlCreator);
    private final DMixedModel model = new DMixedModel(messages);
    private final LoginViewImpl _loginViewImpl;
    private final TermineViewImpl _termineViewImpl;
    private final TerminViewImpl _terminView;
    private final TerminTeilnahmeViewImpl _terminTeilnahmeView;
    private final TerminMitbringViewImpl _terminMitbringView;

    public ClientFactoryImpl() {
	eventBus = new SimpleEventBus();
	placeController = new PlaceController(eventBus);
	_loginViewImpl = new LoginViewImpl(messages, true);
	_termineViewImpl = new TermineViewImpl(messages);
	_terminView = new TerminViewImpl(messages);
	_terminTeilnahmeView = new TerminTeilnahmeViewImpl(messages);
	_terminMitbringView = new TerminMitbringViewImpl(messages);
    }

    @Override
    public EventBus getEventBus() {
	return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
	return placeController;
    }

    @Override
    public final IDMixedMessages getMessages() {
	return messages;
    }

    @Override
    public final String getBaseUrl() {
	return baseUrl;
    }

    @Override
    public final IDMixedUsecase getService() {
	return service;
    }

    @Override
    public final DMixedModel getModel() {
	return model;
    }

    @Override
    public LoginView getLoginView() {
	return _loginViewImpl;
    }

    @Override
    public TermineView getTermineView() {
	return _termineViewImpl;
    }

    @Override
    public TerminActivity.TerminView getTerminView() {
	return _terminView;
    }

    @Override
    public TerminTeilnahmeActivity.TerminView getTerminTeilnahmeView() {
	return _terminTeilnahmeView;
    }

    @Override
    public TerminMitbringActivity.TerminView getTerminMitbringView() {
	return _terminMitbringView;
    }

}
