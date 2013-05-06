package com.appspot.ssg.dmixed.client.model;

import java.util.List;

import com.appspot.ssg.dmixed.shared.IKind;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gwt.json.client.JSONArray;
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
    public String getName() {
	return getString("name");
    }

    @Override
    public boolean isAdmin() {
	return getBoolean("admin");
    }

    @Override
    public String getEmail() {
	return getString("email");
    }

    @Override
    public List<IKind> getKinder() {
	final JSONArray array = getArray("kinder");
	return new Mapping<IKind>(array) {
	    @Override
	    protected IKind create(final JSONObject object) {
		return new Kind(object);
	    }
	};
    }

}
