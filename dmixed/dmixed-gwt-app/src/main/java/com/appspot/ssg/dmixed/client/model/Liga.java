package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ILiga;
import com.google.gwt.json.client.JSONObject;

public class Liga extends HasId implements ILiga {

    private static final long serialVersionUID = 6072078345397549136L;

    public Liga(final JSONObject jsonObject) {
	super(jsonObject);
    }

    @Override
    public String getBezeichnung() {
	return getString("bezeichnung");
    }

}
