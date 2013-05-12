package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.activities.LoginActivity.LoginView;
import com.appspot.ssg.dmixed.client.activities.TerminActivity;
import com.appspot.ssg.dmixed.client.activities.TermineActivity.TermineView;
import com.appspot.ssg.dmixed.client.model.DMixedUsecaseConnector;
import com.appspot.ssg.dmixed.client.views.LoginViewImpl;
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
    private final DMixedUrlCreator urlCreator;
    private final IDMixedUsecase service;
    private final LoginViewImpl _loginViewImpl;
    private final TermineViewImpl _termineViewImpl;

    public ClientFactoryImpl() {
	final String baseUrl = GWT.getHostPageBaseURL();
	urlCreator = new DMixedUrlCreator(baseUrl);
	service = new DMixedUsecaseConnector(urlCreator);
	eventBus = new SimpleEventBus();
	placeController = new PlaceController(eventBus);
	_loginViewImpl = new LoginViewImpl(messages, true);
	_termineViewImpl = new TermineViewImpl(messages);
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
    public final IDMixedUsecase getService() {
	return service;
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
	final TerminViewImpl _terminView = new TerminViewImpl(messages);
	return _terminView;
    }

}
