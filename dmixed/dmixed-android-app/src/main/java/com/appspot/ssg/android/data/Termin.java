package com.appspot.ssg.android.data;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITermin;

public class Termin implements ITermin {

	private static final long serialVersionUID = 1931249628580345231L;
	private Long id;
	private Long termineDatum;
	private String terminKurzbeschreibung;
	private Liga liga;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Date getTermineDatum() {
		return new Date(termineDatum);
	}

	@Override
	public String getTerminKurzbeschreibung() {
		return terminKurzbeschreibung;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTermineDatum(final Long termineDatum) {
		this.termineDatum = termineDatum;
	}

	public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
		this.terminKurzbeschreibung = terminKurzbeschreibung;
	}

	@Override
	public ILiga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}
}