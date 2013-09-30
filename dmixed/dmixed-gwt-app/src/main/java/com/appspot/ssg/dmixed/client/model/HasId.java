package com.appspot.ssg.dmixed.client.model;

import com.google.gwt.json.client.JSONObject;

public class HasId extends AbstractData {

    public HasId() {
	super();
    }

    public HasId(final JSONObject jsonObject) {
	super(jsonObject);
    }

    public Long getId() {
	return getLong("id");
    }

    public void setId(final Long id) {
	setLong("id", id);
    }

}
