package com.appspot.ssg.dmixed.server.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appspot.ssg.dmixed.server.beans.UserData;
import com.appspot.ssg.dmixed.shared.IUserData;

public class UserDataAdapter extends XmlAdapter<UserData, IUserData> {

    @Override
    public IUserData unmarshal(final UserData v) throws Exception {
	return v;
    }

    @Override
    public UserData marshal(final IUserData v) throws Exception {
	return (UserData) v;
    }

}
