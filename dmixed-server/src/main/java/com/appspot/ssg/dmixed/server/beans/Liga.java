package com.appspot.ssg.dmixed.server.beans;

import com.appspot.ssg.dmixed.shared.ILiga;

public class Liga implements ILiga {

    private static final long serialVersionUID = -7123788888241386258L;
    private Long id;
    private String bezeichnung;

    public Liga() {
    }

    @Override
    public Long getId() {
	return id;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    @Override
    public String getBezeichnung() {
	return bezeichnung;
    }

    public void setBezeichnung(final String bezeichnung) {
	this.bezeichnung = bezeichnung;
    }

}
