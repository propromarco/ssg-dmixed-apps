package com.appspot.ssg.dmixed.server.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appspot.ssg.dmixed.server.beans.Liga;
import com.appspot.ssg.dmixed.shared.ILiga;

public class LigaAdapter extends XmlAdapter<Liga, ILiga> {

    @Override
    public ILiga unmarshal(final Liga v) throws Exception {
	return v;
    }

    @Override
    public Liga marshal(final ILiga v) throws Exception {
	return (Liga) v;
    }

}
