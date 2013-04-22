package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "terminteilnehmer")
public class JPATerminTeilnehmer {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private JPATermin termin;

    @ManyToOne
    private JPAUser user;

    public JPATerminTeilnehmer() {
    }

    public final long getId() {
	return id;
    }

    public final void setId(final long id) {
	this.id = id;
    }

    public final JPATermin getTermin() {
	return termin;
    }

    public final void setTermin(final JPATermin termin) {
	this.termin = termin;
    }

    public final JPAUser getUser() {
	return user;
    }

    public final void setUser(final JPAUser user) {
	this.user = user;
    }

}
