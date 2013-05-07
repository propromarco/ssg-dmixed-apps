package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.json.client.JSONObject;

public class TerminTeilnehmer extends HasId implements ITerminTeilnehmer {

    private static final long serialVersionUID = -7582905882242579846L;

    public TerminTeilnehmer() {
	super(new JSONObject());
    }

    public TerminTeilnehmer(final JSONObject obj) {
	super(obj);
    }

    @Override
    public String getVorname() {
	return getString("vorname");
    }

    public void setVorname(final String vorname) {
	setString("vorname", vorname);
    }

    @Override
    public String getName() {
	return getString("name");
    }

    public void setName(final String name) {
	setString("name", name);
    }

    @Override
    public ETeilnahmeStatus getTeilnahme() {
	final String s = getString("teilnahme");
	return ETeilnahmeStatus.valueOf(s);
    }

    @Override
    public void setTeilnahme(final ETeilnahmeStatus teilnahme) {
	setString("teilnahme", teilnahme.name());
    }

    @Override
    public boolean isChangeAllowed() {
	return getBoolean("changeAllowed");
    }

}
