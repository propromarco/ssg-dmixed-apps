package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.TerminTeilnehmerAdapter;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminMitbringsel implements ITerminMitbringsel {

    private static final long serialVersionUID = -2262927574869400873L;

    private Long id;
    private String beschreibung;
    private ITerminTeilnehmer mitbringer;

    public TerminMitbringsel() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    @XmlJavaTypeAdapter(TerminTeilnehmerAdapter.class)
    public ITerminTeilnehmer getMitbringer() {
        return mitbringer;
    }

    public void setMitbringer(ITerminTeilnehmer mitbringer) {
        this.mitbringer = mitbringer;
    }

}
