package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.IUserData;

@XmlRootElement
public class UserData implements IUserData
{
    private static final long serialVersionUID = 6162582455766509261L;

    private Long id;
    private String vorname;
    private String name;
    private Date birthday;

    public UserData()
    {
    }

    public UserData(Long id, String vorname, String name, Date birthday)
    {
        this.id = id;
        this.vorname = vorname;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public String getVorname()
    {
        return this.vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public Date getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

}
