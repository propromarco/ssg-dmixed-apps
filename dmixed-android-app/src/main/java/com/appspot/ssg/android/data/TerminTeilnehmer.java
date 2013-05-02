package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminTeilnehmer implements ITerminTeilnehmer {

	private static final long serialVersionUID = 8486319046111484358L;
	private Long id;
	private String vorname;
	private String name;
	private ETeilnahmeStatus teilnahme;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getVorname() {
		return vorname;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ETeilnahmeStatus getTeilnahme() {
		return teilnahme;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeilnahme(ETeilnahmeStatus teilnahme) {
		this.teilnahme = teilnahme;
	}

}
