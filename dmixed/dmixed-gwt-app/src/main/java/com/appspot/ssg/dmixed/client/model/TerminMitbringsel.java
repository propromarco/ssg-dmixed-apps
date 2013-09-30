package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class TerminMitbringsel extends HasId implements ITerminMitbringsel {
    private static final long serialVersionUID = -7422259613243218283L;

    public TerminMitbringsel(final JSONObject jsonObject) {
	super(jsonObject);
    }

    @Override
    public String getBeschreibung() {
	return getString("beschreibung");
    }

    @Override
    public ITerminTeilnehmer getMitbringer() {
	final JSONValue jsonValue = _jsonObject.get("mitbringer");
	if (jsonValue == null)
	    return null;
	final JSONObject object = jsonValue.isObject();
	return new TerminTeilnehmer(object);
    }

    @Override
    public void setMitbringer(final ITerminTeilnehmer mitbringer) {
	if (mitbringer == null) {
	    _jsonObject.put("mitbringer", null);
	} else {
	    _jsonObject.put("mitbringer", ((TerminTeilnehmer) mitbringer)._jsonObject);
	}
    }

}
