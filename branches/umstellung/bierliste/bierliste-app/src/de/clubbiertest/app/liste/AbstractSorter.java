/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.app.liste;

public class AbstractSorter
{
    public static String replace( final String string )
    {
        String back;
        back = string.toLowerCase();
        back = back.replaceAll("�", "ae");
        back = back.replaceAll("�", "oe");
        back = back.replaceAll("�", "ue");
        back = back.replaceAll("�", "ss");
        return back;
    }
}
