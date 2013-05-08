package com.appspot.ssg.android.data;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.IKind;
import com.appspot.ssg.dmixed.shared.ILiga;

public class Kind implements IKind {

	private static final long serialVersionUID = -1685931359621871687L;
	private long birthday;
	private Liga liga;
	private Long id;
	private String vorname;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getVorname() {
		return vorname;
	}

	@Override
	public Date getBirthday() {
		return new Date(birthday);
	}

	@Override
	public ILiga getLiga() {
		return liga;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

}
