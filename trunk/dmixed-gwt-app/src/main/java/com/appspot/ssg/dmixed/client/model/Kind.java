package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.IKind;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.google.gwt.json.client.JSONObject;

public class Kind extends AbstractData implements IKind {

    private static final long serialVersionUID = 2547346106975267577L;

    public Kind(final JSONObject jsonObject) {
	super(jsonObject);
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
    public Date getBirthday() {
	return getDate("birthday");
    }

    @Override
    public ILiga getLiga() {
	final JSONObject obj = getObject("liga");
	final Liga liga = new Liga(obj);
	return liga;
    }

}
