package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;

@Entity
@Table(name = "terminteilnehmer")
@NamedQueries({
	@NamedQuery(name = JPATerminTeilnehmer.TEILNEHMER_EINES_TERMINS, query = "SELECT t FROM JPATerminTeilnehmer t WHERE t.termin = :termin"),
	@NamedQuery(name = JPATerminTeilnehmer.EIN_TEILNEHMER_EINES_TERMINS, query = "SELECT t FROM JPATerminTeilnehmer t WHERE t.termin = :termin AND t.user = :user") })
public class JPATerminTeilnehmer {

    public static final String TEILNEHMER_EINES_TERMINS = "TEILNEHMER_EINES_TERMINS";
    public static final String EIN_TEILNEHMER_EINES_TERMINS = "EIN_TEILNEHMER_EINES_TERMINS";

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long termin;

    @Column
    private Long user;

    @Enumerated(EnumType.STRING)
    private ETeilnahmeStatus status;

    public JPATerminTeilnehmer() {
    }

    public JPATerminTeilnehmer(final Long termin, final Long user) {
	this.termin = termin;
	this.user = user;
    }

    public Long getId() {
	return id;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    public Long getTermin() {
	return termin;
    }

    public void setTermin(final Long termin) {
	this.termin = termin;
    }

    public Long getUser() {
	return user;
    }

    public void setUser(final Long user) {
	this.user = user;
    }

    public ETeilnahmeStatus getStatus() {
	return status;
    }

    public void setStatus(final ETeilnahmeStatus status) {
	this.status = status;
    }

}
