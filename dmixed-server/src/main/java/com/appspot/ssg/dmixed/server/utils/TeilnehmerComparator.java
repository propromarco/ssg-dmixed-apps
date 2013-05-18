package com.appspot.ssg.dmixed.server.utils;

import java.util.Comparator;

import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TeilnehmerComparator implements Comparator<ITerminTeilnehmer> {

    @Override
    public int compare(final ITerminTeilnehmer o1, final ITerminTeilnehmer o2) {
	final String vorname1 = o1.getVorname();
	final String vorname2 = o2.getVorname();
	final String name1 = o1.getName();
	final String name2 = o2.getName();
	final Long id1 = o1.getId();
	final Long id2 = o2.getId();
	int cmp = vorname1.compareTo(vorname2);
	if (cmp == 0) {
	    cmp = name1.compareTo(name2);
	    if (cmp == 0)
		cmp = id1.compareTo(id2);
	}
	return cmp;
    }

}
