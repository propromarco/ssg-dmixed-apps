package com.appspot.ssg.dmixed.server.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.TerminAdapter;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;

@XmlRootElement
public class Termine implements ITermine {
    private static final long serialVersionUID = 7954238446675965910L;

    private List<ITermin> all;

    public Termine() {
	all = new ArrayList<ITermin>();
    }

    @Override
    @XmlJavaTypeAdapter(TerminAdapter.class)
    public List<ITermin> getAll() {
	return all;
    }

    public void setAll(final List<ITermin> all) {
	this.all = all;
    }

}
