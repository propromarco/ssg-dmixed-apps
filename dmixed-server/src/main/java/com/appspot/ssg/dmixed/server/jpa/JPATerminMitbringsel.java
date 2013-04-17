package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "terminmitbringsel")
public class JPATerminMitbringsel {

    @Id
    @GeneratedValue
    private long mitbringselId;

    @ManyToOne
    private JPATermin termin;

    @ManyToOne
    private JPAMitbringsel mitbringsel;

    @ManyToOne
    private JPAUser user;

    public JPATerminMitbringsel() {
    }

    public JPATerminMitbringsel(long mitbringselId) {
        this.mitbringselId = mitbringselId;
    }

    public final long getMitbringselId() {
        return mitbringselId;
    }

    public final void setMitbringselId(long mitbringselId) {
        this.mitbringselId = mitbringselId;
    }

    public final JPAMitbringsel getMitbringsel() {
        return mitbringsel;
    }

    public final void setMitbringsel(JPAMitbringsel mitbringsel) {
        this.mitbringsel = mitbringsel;
    }

    public final JPAUser getUser() {
        return user;
    }

    public final void setUser(JPAUser user) {
        this.user = user;
    }

}
