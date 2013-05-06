package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "termin")
@NamedQuery(name = JPATermin.ALLE_TERMINE, query = "SELECT termin FROM JPATermin termin")
public class JPATermin {

    public static final String ALLE_TERMINE = "ALLE_TERMINE";
    @Id
    @GeneratedValue
    private Long terminId;
    @Column
    private Long liga;
    @Column
    private boolean heimspiel;
    @Column
    private Long termineDatum;
    @Column
    private String terminKurzbeschreibung;
    @Column
    private String terminBeschreibung;

    public JPATermin() {
    }

    public Long getTerminId() {
	return terminId;
    }

    public void setTerminId(final Long terminId) {
	this.terminId = terminId;
    }

    public boolean isHeimspiel() {
	return heimspiel;
    }

    public void setHeimspiel(final boolean heimspiel) {
	this.heimspiel = heimspiel;
    }

    public Long getTermineDatum() {
	return termineDatum;
    }

    public void setTermineDatum(final Long termineDatum) {
	this.termineDatum = termineDatum;
    }

    public String getTerminKurzbeschreibung() {
	return terminKurzbeschreibung;
    }

    public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
	this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

    public final String getTerminBeschreibung() {
	return terminBeschreibung;
    }

    public final void setTerminBeschreibung(final String terminBeschreibung) {
	this.terminBeschreibung = terminBeschreibung;
    }

    public Long getLiga() {
	return liga;
    }

    public void setLiga(final Long liga) {
	this.liga = liga;
    }

}
