package com.appspot.ssg.dmixed.server.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;

@XmlRootElement
public class Termine implements ITermine {
    private static final long serialVersionUID = 7954238446675965910L;

    @Override
    public List<ITermin> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

}