package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ILoginData;

public class LoginData extends AbstractData implements ILoginData {

    private static final long serialVersionUID = 7042074774688530376L;

    public LoginData() {
        super();
    }

    public LoginData(final String vorname, final String email) {
        super();
        setString("vorname", vorname);
        setString("email", email);
    }

    @Override
    public String getVorname() {
        return getString("vorname");
    }

    @Override
    public String getEmail() {
        return getString("email");
    }

}
