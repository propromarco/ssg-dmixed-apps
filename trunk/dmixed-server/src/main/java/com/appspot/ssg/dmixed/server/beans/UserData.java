package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.DateAdapter;
import com.appspot.ssg.dmixed.shared.IUserData;

@XmlRootElement
public class UserData implements IUserData {
    private static final long serialVersionUID = 6162582455766509261L;

    private Long id;
    private String vorname;
    private String name;
    private Date birthday;
    private boolean admin;

    private String email;

    public UserData() {
    }

    @Override
    public Long getId() {
	return this.id;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    @Override
    public String getVorname() {
	return this.vorname;
    }

    public void setVorname(final String vorname) {
	this.vorname = vorname;
    }

    @Override
    public String getName() {
	return this.name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    @Override
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getBirthday() {
	return this.birthday;
    }

    public void setBirthday(final Date birthday) {
	this.birthday = birthday;
    }

    @Override
    public boolean isAdmin() {
	return admin;
    }

    public void setAdmin(final boolean admin) {
	this.admin = admin;
    }

    @Override
    public String getEmail() {
	return email;
    }

    public void setEmail(final String email) {
	this.email = email;
    }
}
