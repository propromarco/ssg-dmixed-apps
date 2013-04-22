package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gwt.json.client.JSONObject;

public class UserData extends AbstractData implements IUserData {

    private static final long serialVersionUID = 8113909811709789110L;

    public UserData(final JSONObject object) {
	super(object);
    }

    @Override
    public Long getId() {
	return getLong("id");
    }

    @Override
    public String getVorname() {
	return getString("vorname");
    }

    @Override
    public String getName() {
	return getString("name");
    }

    @Override
    public Date getBirthday() {
	return getDate("birthday");
    }

    @Override
    public boolean isAdmin() {
	return getBoolean("admin");
    }

    @Override
    public String getEmail() {
	return getString("email");
    }

}
