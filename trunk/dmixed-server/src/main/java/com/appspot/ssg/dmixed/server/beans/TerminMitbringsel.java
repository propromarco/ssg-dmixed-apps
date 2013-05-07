package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.TerminTeilnehmerAdapter;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminMitbringsel extends HasId implements ITerminMitbringsel {

    private static final long serialVersionUID = -2262927574869400873L;

    private String beschreibung;
    private ITerminTeilnehmer mitbringer;

    public TerminMitbringsel() {
    }

    @Override
    public String getBeschreibung() {
	return beschreibung;
    }

    public void setBeschreibung(final String beschreibung) {
	this.beschreibung = beschreibung;
    }

    @Override
    @XmlJavaTypeAdapter(TerminTeilnehmerAdapter.class)
    public ITerminTeilnehmer getMitbringer() {
	return mitbringer;
    }

    @Override
    public void setMitbringer(final ITerminTeilnehmer mitbringer) {
	this.mitbringer = mitbringer;
    }

}
