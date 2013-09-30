package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "terminmitbringsel")
@NamedQuery(name = JPATerminMitbringsel.MITBRINGSEL_EINES_TERMINS, query = "SELECT m FROM JPATerminMitbringsel m WHERE m.termin = :termin")
public class JPATerminMitbringsel {
    
    public static final String MITBRINGSEL_EINES_TERMINS = "MITBRINGSEL_EINES_TERMINS";

    @Id
    @GeneratedValue
    private Long mitbringselId;

    @Column
    private Long termin;

    @Column
    private Long mitbringsel;

    @Column
    private Long user;

    public JPATerminMitbringsel() {
    }

    public Long getMitbringselId() {
	return mitbringselId;
    }

    public void setMitbringselId(final Long mitbringselId) {
	this.mitbringselId = mitbringselId;
    }

    public Long getMitbringsel() {
	return mitbringsel;
    }

    public void setMitbringsel(final Long mitbringsel) {
	this.mitbringsel = mitbringsel;
    }

    public Long getUser() {
	return user;
    }

    public void setUser(final Long user) {
	this.user = user;
    }

    public Long getTermin() {
	return termin;
    }

    public void setTermin(final Long termin) {
	this.termin = termin;
    }

}
