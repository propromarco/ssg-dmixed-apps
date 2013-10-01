/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.shared;

public class SortUtil
{
    public static String replace( final String string )
    {
        String back;
        back = string.toLowerCase();
        back = back.replaceAll("ä", "ae");
        back = back.replaceAll("ö", "oe");
        back = back.replaceAll("ü", "ue");
        back = back.replaceAll("ß", "ss");
        back = back.replaceAll("/", "_");
        return back;
    }
}
