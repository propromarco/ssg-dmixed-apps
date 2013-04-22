package com.appspot.ssg.dmixed.client.model;

import java.util.List;

import com.appspot.ssg.dmixed.shared.IUserData;
import com.appspot.ssg.dmixed.shared.IUsers;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class Users extends AbstractData implements IUsers {

    private static final long serialVersionUID = 1469442196683242394L;

    public Users(final JSONObject jsonObject) {
	super(jsonObject);
    }

    @Override
    public List<IUserData> getAll() {
	final JSONArray array = getArray("all");
	return new Mapping<IUserData>(array) {
	    @Override
	    protected IUserData create(final JSONObject object) {
		return new UserData(object);
	    }
	};
    }

}
