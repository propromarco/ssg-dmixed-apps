package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminTeilnehmerAdapter extends XmlAdapter<TerminTeilnehmer, ITerminTeilnehmer> {

    @Override
    public ITerminTeilnehmer unmarshal(TerminTeilnehmer v) throws Exception {
        return v;
    }

    @Override
    public TerminTeilnehmer marshal(ITerminTeilnehmer v) throws Exception {
        return (TerminTeilnehmer) v;
    }

}
