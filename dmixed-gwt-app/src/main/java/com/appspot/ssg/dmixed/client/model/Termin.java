package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ITermin;
import com.google.gwt.json.client.JSONObject;

public class Termin extends AbstractData implements ITermin {

    private static final long serialVersionUID = -4595597086302004317L;

    public Termin(JSONObject jsonObject) {
        super(jsonObject);
    }

    @Override
    public Long getTerminId() {
        return getLong("terminId");
    }

    @Override
    public boolean isHeimspiel() {
        return getBoolean("heimspiel");
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
    public String getTerminBeschreibung() {
        return getString("terminbeschreibung");
    }

}
