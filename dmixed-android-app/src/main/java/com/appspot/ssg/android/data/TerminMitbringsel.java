package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminMitbringsel implements ITerminMitbringsel {

	private static final long serialVersionUID = -3024279990023869953L;
	private Long id;
	private String beschreibung;
	private TerminTeilnehmer mitbringer;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getBeschreibung() {
		return beschreibung;
	}

	@Override
	public ITerminTeilnehmer getMitbringer() {
		return mitbringer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public void setMitbringer(TerminTeilnehmer mitbringer) {
		this.mitbringer = mitbringer;
	}

	@Override
	public void setMitbringer(ITerminTeilnehmer mitbringer) {
		this.mitbringer = new TerminTeilnehmer();
		this.mitbringer.setTeilnahme(mitbringer.getTeilnahme());
		this.mitbringer.setName(mitbringer.getName());
		this.mitbringer.setId(mitbringer.getId());
		this.mitbringer.setVorname(mitbringer.getVorname());
	}

}
