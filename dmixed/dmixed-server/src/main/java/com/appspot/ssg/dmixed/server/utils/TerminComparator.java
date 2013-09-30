package com.appspot.ssg.dmixed.server.utils;

import java.util.Comparator;
import java.util.Date;

import com.appspot.ssg.dmixed.shared.ITermin;

public class TerminComparator implements Comparator<ITermin> {

    @Override
    public int compare(final ITermin o1, final ITermin o2) {
	final Date termineDatum1 = o1.getTermineDatum();
	final Date termineDatum2 = o2.getTermineDatum();
	final Long id1 = o1.getId();
	final Long id2 = o2.getId();
	int cmp = termineDatum1.compareTo(termineDatum2);
	if (cmp == 0)
	    cmp = id1.compareTo(id2);
	return cmp;
    }

}
