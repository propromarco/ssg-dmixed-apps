package com.appspot.ssg.dmixed.server.utils;

import java.util.Comparator;

import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;

public class MitbringselComparator implements Comparator<ITerminMitbringsel> {

    @Override
    public int compare(final ITerminMitbringsel o1, final ITerminMitbringsel o2) {
	final Long id1 = o1.getId();
	final String beschreibung1 = o1.getBeschreibung();
	final Long id2 = o2.getId();
	final String beschreibung2 = o2.getBeschreibung();
	int cmp = beschreibung1.compareTo(beschreibung2);
	if (cmp == 0)
	    cmp = id1.compareTo(id2);
	return cmp;
    }

}
