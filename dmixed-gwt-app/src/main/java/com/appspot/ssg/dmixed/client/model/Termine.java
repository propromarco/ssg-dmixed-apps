package com.appspot.ssg.dmixed.client.model;

import java.util.List;

import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class Termine extends AbstractData implements ITermine {

    private static final long serialVersionUID = -6566178482824695480L;

    public Termine(final JSONObject object) {
        super(object);
    }

    @Override
    public List<ITermin> getAll() {
        final JSONArray array = getArray("all");
        return new Mapping<ITermin>(array) {
            @Override
            protected ITermin create(final JSONObject object) {
                return new Termin(object);
            }
        };
    }

}
