package com.appspot.ssg.android.data;

import java.util.Date;

import com.appspot.ssg.dmixed.shared.IUserData;

public class UserData implements IUserData {

	private static final long serialVersionUID = 4128088292403122593L;
	private Long id;
	private String vorname;
	private String name;
	private String email;
	private Long birthday;
	private boolean admin;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getVorname() {
		return vorname;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Date getBirthday() {
		return new Date(birthday);
	}

	@Override
	public boolean isAdmin() {
		return admin;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
