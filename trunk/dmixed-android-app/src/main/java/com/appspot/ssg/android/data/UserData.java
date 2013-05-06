package com.appspot.ssg.android.data;

import java.util.List;

import com.appspot.ssg.dmixed.shared.IKind;
import com.appspot.ssg.dmixed.shared.IUserData;

public class UserData implements IUserData {

    private static final long serialVersionUID = 4128088292403122593L;
    private Long id;
    private String name;
    private String email;
    private boolean admin;

    @Override
    public Long getId() {
	return id;
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
    public boolean isAdmin() {
	return admin;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public void setEmail(final String email) {
	this.email = email;
    }

    public void setAdmin(final boolean admin) {
	this.admin = admin;
    }

    @Override
    public List<IKind> getKinder() {
	// TODO Auto-generated method stub
	return null;
    }

}
