package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.ILiga;

public class Liga implements ILiga {

	private static final long serialVersionUID = 2514954624049603145L;
	private String bezeichnung;
	private Long id;

	public Liga() {
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	@Override
	public String toString() {
		return getBezeichnung();
	}

}
