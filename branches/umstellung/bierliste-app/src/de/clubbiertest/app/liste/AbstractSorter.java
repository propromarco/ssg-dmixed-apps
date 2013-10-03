/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.app.liste;

public class AbstractSorter
{
    public static String replace( final String string )
    {
        String back;
        back = string.toLowerCase();
        back = back.replaceAll("ä", "ae");
        back = back.replaceAll("ö", "oe");
        back = back.replaceAll("ü", "ue");
        back = back.replaceAll("ß", "ss");
        return back;
    }
}
