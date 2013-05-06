package com.appspot.ssg.dmixed.server.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "kind")
@NamedQueries({ @NamedQuery(name = JPAKind.KINDER_DER_ELTERN, query = "SELECT kind FROM JPAKind kind WHERE kind.familie = :familie"),
	@NamedQuery(name = JPAKind.KINDER_DER_LIGA, query = "SELECT kind FROM JPAKind kind WHERE kind.liga = :liga") })
public class JPAKind {

    public static final String KINDER_DER_ELTERN = "KINDER_DER_ELTERN";
    public static final String KINDER_DER_LIGA = "KINDER_DER_LIGA";

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long familie;
    @Column
    private Long liga;
    @Column
    private String vorname;
    @Column
    private Long birthday;

    public JPAKind() {
    }

    public JPAKind(final String vorname, final Date birthday) {
	this.vorname = vorname;
	this.birthday = birthday.getTime();
    }

    public Long getId() {
	return id;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    public Long getFamilie() {
	return familie;
    }

    public void setFamilie(final Long familie) {
	this.familie = familie;
    }

    public String getVorname() {
	return vorname;
    }

    public void setVorname(final String vorname) {
	this.vorname = vorname;
    }

    public Long getBirthday() {
	return birthday;
    }

    public void setBirthday(final Long birthday) {
	this.birthday = birthday;
    }

    public Long getLiga() {
	return liga;
    }

    public void setLiga(final Long liga) {
	this.liga = liga;
    }

}
