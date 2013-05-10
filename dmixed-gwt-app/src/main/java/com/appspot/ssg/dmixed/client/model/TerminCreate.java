package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.ITerminCreate;

public class TerminCreate extends HasId implements ITerminCreate {

    private static final long serialVersionUID = 6251344279023275417L;

    public TerminCreate() {
	super();
    }

    public TerminCreate(final Date terminDatum, final String terminKurzbeschreibung, final Long liga, final Boolean heimSpiel) {
	super();
	setTerminDatum(terminDatum);
	setTerminKurzbeschreibung(terminKurzbeschreibung);
	setLiga(liga);
	setHeimspiel(heimSpiel);
    }

    @Override
    public Date getTerminDatum() {
	return getDate("terminDatum");
    }

    public void setTerminDatum(final Date terminDatum) {
	setLong("terminDatum", terminDatum.getTime());
    }

    @Override
    public String getTerminKurzbeschreibung() {
	return getString("terminKurzbeschreibung");
    }

    public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
	setString("terminKurzbeschreibung", terminKurzbeschreibung);
    }

    @Override
    public Long getLiga() {
	return getLong("liga");
    }

    public void setLiga(final Long liga) {
	setLong("liga", liga);
    }

    @Override
    public boolean isHeimspiel() {
	return getBoolean("heimspiel");
    }

    public void setHeimspiel(final boolean heimspiel) {
	setBoolean("heimspiel", heimspiel);
    }

}
