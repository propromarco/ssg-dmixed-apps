package com.appspot.ssg.dmixed.server.beans;

import com.appspot.ssg.dmixed.shared.ILiga;

public class Liga extends HasId implements ILiga {

    private static final long serialVersionUID = -7123788888241386258L;
    private String bezeichnung;

    public Liga() {
    }

    @Override
    public String getBezeichnung() {
	return bezeichnung;
    }

    public void setBezeichnung(final String bezeichnung) {
	this.bezeichnung = bezeichnung;
    }

}
