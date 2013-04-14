package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ILoginData;

public class LoginData extends AbstractData implements ILoginData {

    private static final long serialVersionUID = 7042074774688530376L;
    
    public LoginData() {
        super();
    }

    public LoginData(String username, String password) {
        super();
        setString("username", username);
        setString("password", password);
    }

    @Override
    public String getUsername() {
        return getString("username");
    }

    @Override
    public String getPassword() {
        return getString("password");
    }

}
