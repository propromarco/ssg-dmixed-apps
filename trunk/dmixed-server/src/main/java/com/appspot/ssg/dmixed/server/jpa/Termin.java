package com.appspot.ssg.dmixed.server.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Termin {

    @Id
    @GeneratedValue
    private Long id;

    public Termin() {

    }

    public final Long getId() {
        return id;
    }

    public final void setId(Long id) {
        this.id = id;
    }

}
