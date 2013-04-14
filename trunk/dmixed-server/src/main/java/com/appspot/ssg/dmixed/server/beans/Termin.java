package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ITermin;

public class Termin implements ITermin {

    private static final long serialVersionUID = -8628810572519963582L;

    private Long terminId;
    private boolean heimspiel;
    private Date termineDatum;
    private String terminKurzbeschreibung;

    public Termin() {
    }

    public Termin(Long terminId, Date termineDatum, String terminKurzbeschreibung, boolean heimspiel) {
        super();
        this.terminId = terminId;
        this.termineDatum = termineDatum;
        this.terminKurzbeschreibung = terminKurzbeschreibung;
        this.heimspiel = heimspiel;
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

}
