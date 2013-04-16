package com.appspot.ssg.dmixed.client.model;

import java.util.List;

import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class TerminDetails extends Termin implements ITerminDetails {

    private static final long serialVersionUID = -6936051379531665989L;

    public TerminDetails(JSONObject jsonObject) {
        super(jsonObject);
    }

    @Override
    public String getTerminBeschreibung() {
        return getString("terminBeschreibung");
    }

    @Override
    public List<ITerminTeilnehmer> getTeilnehmer() {
        JSONArray array = getArray("teilnehmer");
        return new Mapping<ITerminTeilnehmer>(array) {
            @Override
            protected ITerminTeilnehmer create(JSONObject object) {
                return new TerminTeilnehmer(object);
            }
        };
    }

    @Override
    public List<ITerminMitbringsel> getMitbringsel() {
        JSONArray array = getArray("teilnehmer");
        return new Mapping<ITerminMitbringsel>(array) {
            @Override
            protected ITerminMitbringsel create(JSONObject object) {
                return new TerminMitbringsel(object);
            }
        };
    }

}
