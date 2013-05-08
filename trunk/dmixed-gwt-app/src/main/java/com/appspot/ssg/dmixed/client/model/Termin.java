package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class Termin extends HasId implements ITermin {

    private static final long serialVersionUID = -4595597086302004317L;

    public Termin(final JSONObject jsonObject) {
	super(jsonObject);
    }

    @Override
    public Date getTermineDatum() {
	return getDate("termineDatum");
    }

    @Override
    public String getTerminKurzbeschreibung() {
	return getString("terminKurzbeschreibung");
    }

    @Override
    public ILiga getLiga() {
	final JSONValue jsonValue = _jsonObject.get("liga");
	if (jsonValue == null)
	    return null;
	final JSONObject object = jsonValue.isObject();
	return new Liga(object);
    }

}
