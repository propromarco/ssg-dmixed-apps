package com.appspot.ssg.dmixed.server.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appspot.ssg.dmixed.server.beans.TerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;

public class TerminMitbringselAdapter extends XmlAdapter<TerminMitbringsel, ITerminMitbringsel> {

    @Override
    public ITerminMitbringsel unmarshal(final TerminMitbringsel v) throws Exception {
        return v;
    }

    @Override
    public TerminMitbringsel marshal(final ITerminMitbringsel v) throws Exception {
        return (TerminMitbringsel) v;
    }

}
