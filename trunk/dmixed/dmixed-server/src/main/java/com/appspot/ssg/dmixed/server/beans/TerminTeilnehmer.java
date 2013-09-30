package com.appspot.ssg.dmixed.server.beans;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminTeilnehmer extends HasId implements ITerminTeilnehmer {
    private static final long serialVersionUID = -7880403326312006230L;
    private String vorname;
    private String name;
    private ETeilnahmeStatus teilnahme;
    private boolean changeAllowed;

    public TerminTeilnehmer() {
    }

    @Override
    public String getVorname() {
	return vorname;
    }

    public void setVorname(final String vorname) {
	this.vorname = vorname;
    }

    @Override
    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    @Override
    public ETeilnahmeStatus getTeilnahme() {
	return teilnahme;
    }

    @Override
    public void setTeilnahme(final ETeilnahmeStatus teilnahme) {
	this.teilnahme = teilnahme;
    }

    @Override
    public boolean isChangeAllowed() {
	return changeAllowed;
    }

    public void setChangeAllowed(final boolean changeAllowed) {
	this.changeAllowed = changeAllowed;
    }

}
