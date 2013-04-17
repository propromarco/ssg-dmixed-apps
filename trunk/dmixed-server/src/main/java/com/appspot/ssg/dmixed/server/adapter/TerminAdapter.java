package com.appspot.ssg.dmixed.server.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appspot.ssg.dmixed.server.beans.Termin;
import com.appspot.ssg.dmixed.shared.ITermin;

public class TerminAdapter extends XmlAdapter<Termin, ITermin> {

    @Override
    public ITermin unmarshal(final Termin v) throws Exception {
        return v;
    }

    @Override
    public Termin marshal(final ITermin v) throws Exception {
        return (Termin) v;
    }

}
