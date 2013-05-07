package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.DateAdapter;
import com.appspot.ssg.dmixed.shared.ITermin;

public class Termin extends HasId implements ITermin {

    private static final long serialVersionUID = -8628810572519963582L;

    private Date termineDatum;
    private String terminKurzbeschreibung;

    public Termin() {
    }

    @Override
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getTermineDatum() {
	return termineDatum;
    }

    public void setTermineDatum(final Date termineDatum) {
	this.termineDatum = termineDatum;
    }

    @Override
    public String getTerminKurzbeschreibung() {
	return terminKurzbeschreibung;
    }

    public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
	this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

}
