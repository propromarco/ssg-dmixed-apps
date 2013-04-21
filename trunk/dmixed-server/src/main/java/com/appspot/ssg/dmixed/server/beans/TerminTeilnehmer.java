package com.appspot.ssg.dmixed.server.beans;

import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminTeilnehmer implements ITerminTeilnehmer {
    private static final long serialVersionUID = -7880403326312006230L;
    private Long id;
    private String vorname;
    private String name;
    private boolean teilnahme;

    public TerminTeilnehmer() {
    }

    @Override
    public final Long getId() {
        return id;
    }

    public final void setId(final Long id) {
        this.id = id;
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
    public boolean isTeilnahme() {
        return teilnahme;
    }

    public void setTeilnahme(final boolean teilnahme) {
        this.teilnahme = teilnahme;
    }

}
