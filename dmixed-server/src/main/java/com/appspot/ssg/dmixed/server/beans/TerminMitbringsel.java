package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminMitbringsel implements ITerminMitbringsel {

    private static final long serialVersionUID = -2262927574869400873L;

    private Long id;
    private String beschreibung;

    public TerminMitbringsel() {
    }

    public TerminMitbringsel(Long id, String beschreibung) {
        this.id = id;
        this.beschreibung = beschreibung;
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
        // TODO Auto-generated method stub
        return null;
    }

}
