package com.appspot.ssg.android.data;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ITermin;

public class Termin implements ITermin {

	private static final long serialVersionUID = 1931249628580345231L;
	private Long terminId;
	private Long termineDatum;
	private String terminKurzbeschreibung;

	@Override
	public Long getId() {
		return terminId;
	}

	@Override
	public Date getTermineDatum() {
		return new Date(termineDatum);
	}

	@Override
	public String getTerminKurzbeschreibung() {
		return terminKurzbeschreibung;
	}

	public void setTerminId(final Long terminId) {
		this.terminId = terminId;
	}

	public void setTermineDatum(final Long termineDatum) {
		this.termineDatum = termineDatum;
	}

	public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
		this.terminKurzbeschreibung = terminKurzbeschreibung;
	}
}