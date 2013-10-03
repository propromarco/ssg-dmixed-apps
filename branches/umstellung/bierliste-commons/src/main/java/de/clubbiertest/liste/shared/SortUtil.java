/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.shared;

public class SortUtil
{
    public static String replace( final String string )
    {
        String back;
        back = string.toLowerCase();
        back = back.replaceAll("\u00E4", "ae");
        back = back.replaceAll("\u00F6", "oe");
        back = back.replaceAll("\u00FC", "ue");
        back = back.replaceAll("\u00DF", "ss");
        back = back.replaceAll("/", "_");
        return back;
    }
}
