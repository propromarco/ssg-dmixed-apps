package com.appspot.ssg.dmixed.server.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQuery(name = JPAUser.FINDUSER, query = "SELECT user FROM JPAUser user WHERE user.vorname = :vorname and user.email = :email")
public class JPAUser {

    public static final String FINDUSER = "FINDUSER";

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String vorname;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Date birthday;
    @Column
    private boolean admin;

    public JPAUser() {

    }

    public final Long getId() {
	return id;
    }

    public final void setId(final Long id) {
	this.id = id;
    }

    public String getVorname() {
	return vorname;
    }

    public void setVorname(final String vorname) {
	this.vorname = vorname;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public final String getEmail() {
	return email;
    }

    public final void setEmail(final String email) {
	this.email = email;
    }

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(final Date birthday) {
	this.birthday = birthday;
    }

    public boolean isAdmin() {
	return admin;
    }

    public void setAdmin(final boolean admin) {
	this.admin = admin;
    }

}
