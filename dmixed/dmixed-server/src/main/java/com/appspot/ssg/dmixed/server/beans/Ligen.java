package com.appspot.ssg.dmixed.server.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.LigaAdapter;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ILigen;

@XmlRootElement
public class Ligen implements ILigen {

    private static final long serialVersionUID = 5603674094271960067L;

    private List<ILiga> ligen;

    public Ligen() {
	ligen = new ArrayList<ILiga>();
    }

    @Override
    @XmlJavaTypeAdapter(LigaAdapter.class)
    public List<ILiga> getAll() {
	return ligen;
    }

    public void setAll(final List<ILiga> ligen) {
	this.ligen = ligen;
    }

}
