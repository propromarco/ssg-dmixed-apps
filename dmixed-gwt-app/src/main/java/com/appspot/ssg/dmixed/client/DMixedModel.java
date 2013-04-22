package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.shared.ITermine;
import com.appspot.ssg.dmixed.shared.IUserData;

public class DMixedModel {

    private IUserData _user;
    private ITermine _termine;
    private final IDMixedMessages _messages;

    public DMixedModel(final IDMixedMessages messages) {
	_messages = messages;
    }

    public IDMixedMessages getMessages() {
	return _messages;
    }

    public void setUser(final IUserData user) {
	_user = user;
    }

    public IUserData getUser() {
	return _user;
    }

    public void setTermine(final ITermine termine) {
	_termine = termine;
    }

    public ITermine getTermine() {
	return _termine;
    }

}
