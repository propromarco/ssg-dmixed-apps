/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.shared;

public class SortUtil
{
    public static String replace( final String string )
    {
        String back;
        back = string.toLowerCase();
        back = back.replaceAll("�", "ae");
        back = back.replaceAll("�", "oe");
        back = back.replaceAll("�", "ue");
        back = back.replaceAll("�", "ss");
        back = back.replaceAll("/", "_");
        return back;
    }
}
