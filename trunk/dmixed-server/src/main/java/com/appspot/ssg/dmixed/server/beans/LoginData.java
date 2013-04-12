package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.ILoginData;

@XmlRootElement
public class LoginData implements ILoginData
{
    private static final long serialVersionUID = 4317385007201849533L;

    private String username;
    private String password;

    public LoginData()
    {
    }

    public LoginData(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
