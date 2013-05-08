package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.LigaAdapter;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITerminCreate;

@XmlRootElement
public class TerminCreate extends HasId implements ITerminCreate {

    private static final long serialVersionUID = 8700225597652779011L;
    private Date terminDatum;
    private String terminKurzbeschreibung;
    private ILiga liga;
    private boolean heimspiel;

    public TerminCreate() {
    }

    @Override
    public Date getTerminDatum() {
	return terminDatum;
    }

    public void setTerminDatum(final Date terminDatum) {
	this.terminDatum = terminDatum;
    }

    @Override
    public String getTerminKurzbeschreibung() {
	return terminKurzbeschreibung;
    }

    public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
	this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

    @Override
    @XmlJavaTypeAdapter(LigaAdapter.class)
    public ILiga getLiga() {
	return liga;
    }

    public void setLiga(final ILiga liga) {
	this.liga = liga;
    }

    @Override
    public boolean isHeimspiel() {
	return heimspiel;
    }

    public void setHeimspiel(final boolean heimspiel) {
	this.heimspiel = heimspiel;
    }

}
