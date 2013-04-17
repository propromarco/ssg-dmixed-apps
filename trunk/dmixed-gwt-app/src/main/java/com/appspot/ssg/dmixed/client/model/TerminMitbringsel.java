package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class TerminMitbringsel extends AbstractData implements ITerminMitbringsel {
    private static final long serialVersionUID = -7422259613243218283L;

    public TerminMitbringsel(final JSONObject jsonObject) {
        super(jsonObject);
    }

    @Override
    public Long getId() {
        return getLong("id");
    }

    @Override
    public String getBeschreibung() {
        return getString("beschreibung");
    }

    @Override
    public ITerminTeilnehmer getMitbringer() {
        final JSONValue jsonValue = _jsonObject.get("mitbringer");
        final JSONObject object = jsonValue.isObject();
        return new TerminTeilnehmer(object);
    }

}
