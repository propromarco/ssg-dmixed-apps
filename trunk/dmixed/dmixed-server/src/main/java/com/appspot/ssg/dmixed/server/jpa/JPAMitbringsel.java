package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mitbringsel")
public class JPAMitbringsel {

    @Id
    @GeneratedValue
    private Long mitbringselId;
    @Column
    private String bezeichnung;

    public JPAMitbringsel() {
    }

    public final Long getMitbringselId() {
	return mitbringselId;
    }

    public final void setMitbringselId(final Long mitbringselId) {
	this.mitbringselId = mitbringselId;
    }

    public final String getBezeichnung() {
	return bezeichnung;
    }

    public final void setBezeichnung(final String bezeichnung) {
	this.bezeichnung = bezeichnung;
    }

}
