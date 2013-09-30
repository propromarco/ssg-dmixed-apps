package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminTeilnehmer implements ITerminTeilnehmer {

	private static final long serialVersionUID = 8486319046111484358L;
	private Long id;
	private String vorname;
	private String name;
	private ETeilnahmeStatus teilnahme;
	private boolean changeAllowed;

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

	public void setId(final Long id) {
		this.id = id;
	}

	public void setVorname(final String vorname) {
		this.vorname = vorname;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public void setTeilnahme(final ETeilnahmeStatus teilnahme) {
		this.teilnahme = teilnahme;
	}

	@Override
	public boolean isChangeAllowed() {
		return changeAllowed;
	}

	public void setChangeAllowed(boolean changeAllowed) {
		this.changeAllowed = changeAllowed;
	}
}
