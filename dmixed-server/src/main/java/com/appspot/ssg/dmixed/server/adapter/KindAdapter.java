package com.appspot.ssg.dmixed.server.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appspot.ssg.dmixed.server.beans.Kind;
import com.appspot.ssg.dmixed.shared.IKind;

public class KindAdapter extends XmlAdapter<Kind, IKind> {

    @Override
    public IKind unmarshal(final Kind v) throws Exception {
	return v;
    }

    @Override
    public Kind marshal(final IKind v) throws Exception {
	return (Kind) v;
    }

}
