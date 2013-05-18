package com.appspot.ssg.android.data;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ITerminCreate;

public class CreateTermin implements ITerminCreate {

    private static final long serialVersionUID = -4394967729394425537L;
    private long terminDatum;
    private String terminKurzbeschreibung;
    private boolean heimspiel;
    private Long liga;
    private Long id;

    public CreateTermin() {
    }

    public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
	this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

    public void setTerminDatum(final long terminDatum) {
	this.terminDatum = terminDatum;
    }

    public void setHeimspiel(final boolean heimspiel) {
	this.heimspiel = heimspiel;
    }

    public void setLiga(final Long liga) {
	this.liga = liga;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    @Override
    public Long getId() {
	return id;
    }

    @Override
    public Date getTerminDatum() {
	return new Date(terminDatum);
    }

    @Override
    public String getTerminKurzbeschreibung() {
	return terminKurzbeschreibung;
    }

    @Override
    public Long getLiga() {
	return liga;
    }

    @Override
    public boolean isHeimspiel() {
	return heimspiel;
    }

    @Override
    public String getTerminBeschreibung() {
	// TODO Auto-generated method stub
	return null;
    }

}
