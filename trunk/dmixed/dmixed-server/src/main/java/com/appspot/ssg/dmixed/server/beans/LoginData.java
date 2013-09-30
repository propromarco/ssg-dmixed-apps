package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.ILoginData;

@XmlRootElement
public class LoginData implements ILoginData {
    private static final long serialVersionUID = 4317385007201849533L;

    private String vorname;
    private String email;

    public LoginData() {
    }

    @Override
    public final String getVorname() {
	return vorname;
    }

    public final void setVorname(final String vorname) {
	this.vorname = vorname;
    }

    @Override
    public final String getEmail() {
	return email;
    }

    public final void setEmail(final String email) {
	this.email = email;
    }

}
