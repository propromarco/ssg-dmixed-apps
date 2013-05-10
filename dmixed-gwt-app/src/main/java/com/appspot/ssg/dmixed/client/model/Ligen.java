package com.appspot.ssg.dmixed.client.model;

import java.util.List;

import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ILigen;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class Ligen extends AbstractData implements ILigen {

    private static final long serialVersionUID = -7458432892675299571L;

    public Ligen(final JSONObject jsonObject) {
	super(jsonObject);
    }

    @Override
    public List<ILiga> getAll() {
	final JSONArray array = getArray("all");
	return new Mapping<ILiga>(array) {
	    @Override
	    protected ILiga create(final JSONObject object) {
		return new Liga(object);
	    }
	};
    }

}
