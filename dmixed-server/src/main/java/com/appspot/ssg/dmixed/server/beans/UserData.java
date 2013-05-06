package com.appspot.ssg.dmixed.server.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.KindAdapter;
import com.appspot.ssg.dmixed.shared.IKind;
import com.appspot.ssg.dmixed.shared.IUserData;

@XmlRootElement
public class UserData implements IUserData {
    private static final long serialVersionUID = 6162582455766509261L;

    private Long id;
    private String name;
    private boolean admin;
    private String email;
    private List<IKind> kinder = new ArrayList<IKind>();

    public UserData() {
    }

    @Override
    public Long getId() {
	return this.id;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    @Override
    public String getName() {
	return this.name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    @Override
    public boolean isAdmin() {
	return admin;
    }

    public void setAdmin(final boolean admin) {
	this.admin = admin;
    }

    @Override
    public String getEmail() {
	return email;
    }

    public void setEmail(final String email) {
	this.email = email;
    }

    @Override
    @XmlJavaTypeAdapter(KindAdapter.class)
    public List<IKind> getKinder() {
	return kinder;
    }

    public void setKinder(final List<IKind> kinder) {
	this.kinder = kinder;
    }
}
