package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.json.client.JSONObject;

public class TerminTeilnehmer extends AbstractData implements ITerminTeilnehmer {

    private static final long serialVersionUID = -7582905882242579846L;

    public TerminTeilnehmer(final JSONObject obj) {
        super(obj);
    }

    @Override
    public String getVorname() {
        return getString("vorname");
    }

    @Override
    public String getName() {
        return getString("name");
    }

    @Override
    public boolean isTeilnahme() {
        return getBoolean("teilnahme");
    }

}
