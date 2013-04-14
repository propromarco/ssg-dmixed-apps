package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appspot.ssg.dmixed.shared.ITermin;

public class TerminAdapter extends XmlAdapter<Termin, ITermin> {

    @Override
    public ITermin unmarshal(Termin v) throws Exception {
        return v;
    }

    @Override
    public Termin marshal(ITermin v) throws Exception {
        return (Termin) v;
    }

}
