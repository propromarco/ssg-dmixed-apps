package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mitbringsel")
public class JPATerminMitbringsel {

    @Id
    @GeneratedValue
    private long mitbringselId;
    @Column
    private String bezeichnung;

    public JPATerminMitbringsel() {
        // TODO Auto-generated constructor stub
    }

    public JPATerminMitbringsel(long mitbringselId, String bezeichnung) {
        this.mitbringselId = mitbringselId;
        this.bezeichnung = bezeichnung;
    }

    public final long getMitbringselId() {
        return mitbringselId;
    }

    public final void setMitbringselId(long mitbringselId) {
        this.mitbringselId = mitbringselId;
    }

    public final String getBezeichnung() {
        return bezeichnung;
    }

    public final void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

}
