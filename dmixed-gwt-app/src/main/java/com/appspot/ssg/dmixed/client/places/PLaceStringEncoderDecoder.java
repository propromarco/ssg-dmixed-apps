package com.appspot.ssg.dmixed.client.places;

import java.util.ArrayList;
import java.util.List;

public class PLaceStringEncoderDecoder {

    private static final int RADIX = 36;
    private static final String TRENNER = ":";

    public static List<Long> decode(final String token) {
	final String[] split = token.split(TRENNER);
	final List<Long> list = new ArrayList<Long>();
	for (final String string : split) {
	    final Long l = Long.valueOf(string, RADIX);
	    list.add(l);
	}
	return list;
    }

    public static String encode(final Long... longs) {
	final StringBuffer buffer = new StringBuffer();
	for (int i = 0; i < longs.length; i++) {
	    final Long l = longs[i];
	    final String s = Long.toString(l, RADIX);
	    buffer.append(s);
	    if (i < longs.length - 1) {
		buffer.append(TRENNER);
	    }
	}
	return buffer.toString();
    }

    public static Boolean toBoolean(final Long l) {
	return l == 0 ? false : true;
    }

    public static Long toLong(final Boolean b) {
	return b ? 1l : 0l;
    }

}
