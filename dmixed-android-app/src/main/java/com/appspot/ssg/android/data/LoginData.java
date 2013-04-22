package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.ILoginData;

public class LoginData implements ILoginData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String vorname;

	@Override
	public String getVorname() {
		return vorname;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

}
