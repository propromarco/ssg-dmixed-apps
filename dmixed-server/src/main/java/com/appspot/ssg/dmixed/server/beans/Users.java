package com.appspot.ssg.dmixed.server.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.UserDataAdapter;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.appspot.ssg.dmixed.shared.IUsers;

@XmlRootElement
public class Users implements IUsers {

    private static final long serialVersionUID = 5088845540647481994L;
    private List<IUserData> _all;

    public Users() {
    }

    @Override
    @XmlJavaTypeAdapter(UserDataAdapter.class)
    public List<IUserData> getAll() {
        return _all;
    }

    public void setAll(final List<IUserData> all) {
        _all = all;
    }

}
