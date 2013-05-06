package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.DateAdapter;
import com.appspot.ssg.dmixed.server.adapter.LigaAdapter;
import com.appspot.ssg.dmixed.shared.IKind;
import com.appspot.ssg.dmixed.shared.ILiga;

public class Kind implements IKind {

    private static final long serialVersionUID = 5449070923594844203L;
    private Long id;
    private String vorname;
    private Date birthday;
    private ILiga liga;

    public Kind() {
    }

    @Override
    public Long getId() {
	return id;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    @Override
    public String getVorname() {
	return vorname;
    }

    public void setVorname(final String vorname) {
	this.vorname = vorname;
    }

    @Override
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(final Date birthday) {
	this.birthday = birthday;
    }

    @Override
    @XmlJavaTypeAdapter(LigaAdapter.class)
    public ILiga getLiga() {
	return liga;
    }

    public void setLiga(final ILiga liga) {
	this.liga = liga;
    }

}
