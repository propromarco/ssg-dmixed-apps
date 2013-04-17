package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.DateAdapter;
import com.appspot.ssg.dmixed.shared.ITermin;

public class Termin implements ITermin {

    private static final long serialVersionUID = -8628810572519963582L;

    private Long terminId;
    private boolean heimspiel;
    private Date termineDatum;
    private String terminKurzbeschreibung;

    private String terminBeschreibung;

    public Termin() {
    }

    public Termin(ITermin termin) {
        terminId = termin.getTerminId();
        termineDatum = termin.getTermineDatum();
        terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
        heimspiel = termin.isHeimspiel();
    }

    @Override
    public Long getTerminId() {
        return terminId;
    }

    public void setTerminId(Long terminId) {
        this.terminId = terminId;
    }

    @Override
    public boolean isHeimspiel() {
        return heimspiel;
    }

    public void setHeimspiel(boolean heimspiel) {
        this.heimspiel = heimspiel;
    }

    @Override
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getTermineDatum() {
        return termineDatum;
    }

    public void setTermineDatum(Date termineDatum) {
        this.termineDatum = termineDatum;
    }

    @Override
    public String getTerminKurzbeschreibung() {
        return terminKurzbeschreibung;
    }

    public void setTerminKurzbeschreibung(String terminKurzbeschreibung) {
        this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

    @Override
    public String getTerminBeschreibung() {
        return this.terminBeschreibung;
    }

    public void setTerminBeschreibung(String terminBeschreibung) {
        this.terminBeschreibung = terminBeschreibung;
    }

}
