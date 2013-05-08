package com.appspot.ssg.android.data;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITerminCreate;

public class CreateTermin implements ITerminCreate {

	private static final long serialVersionUID = -4394967729394425537L;
	private long terminDatum;
	private String terminKurzbeschreibung;
	private boolean heimspiel;
	private Liga liga;
	private Long id;

	public CreateTermin() {
	}

	public void setTerminKurzbeschreibung(String terminKurzbeschreibung) {
		this.terminKurzbeschreibung = terminKurzbeschreibung;
	}

	public void setTerminDatum(long terminDatum) {
		this.terminDatum = terminDatum;
	}

	public void setHeimspiel(boolean heimspiel) {
		this.heimspiel = heimspiel;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public void setId(Long id) {
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
	public ILiga getLiga() {
		return liga;
	}

	@Override
	public boolean isHeimspiel() {
		return heimspiel;
	}

}
