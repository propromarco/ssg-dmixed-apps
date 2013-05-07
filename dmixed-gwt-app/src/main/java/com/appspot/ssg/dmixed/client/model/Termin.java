package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ITermin;
import com.google.gwt.json.client.JSONObject;

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

}
