package com.appspot.ssg.dmixed.server.adapter;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<Long, Date> {

    @Override
    public Date unmarshal(final Long v) throws Exception {
	return new Date(v);
    }

    @Override
    public Long marshal(final Date v) throws Exception {
	return v.getTime();
    }

}
