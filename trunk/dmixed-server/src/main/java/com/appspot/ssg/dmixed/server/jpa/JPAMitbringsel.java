package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terminmitbringsel")
public class JPAMitbringsel {

    @Id
    @GeneratedValue
    private long mitbringselId;
    @Column
    private String bezeichnung;

    public JPAMitbringsel() {
    }

    public JPAMitbringsel(final long mitbringselId, final String bezeichnung) {
	this.mitbringselId = mitbringselId;
	this.bezeichnung = bezeichnung;
    }

    public final long getMitbringselId() {
	return mitbringselId;
    }

    public final void setMitbringselId(final long mitbringselId) {
	this.mitbringselId = mitbringselId;
    }

    public final String getBezeichnung() {
	return bezeichnung;
    }

    public final void setBezeichnung(final String bezeichnung) {
	this.bezeichnung = bezeichnung;
    }

}
