/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.shared;


public class UriUtils implements Uris
{
    public static String getKontinentPath( final String kontinentName )
    {
        return LISTE_PATH + "/" + KONTINENT_PATH + "/" + kontinentName;
    }

    public static String getLandPath( final String landName )
    {
        return LISTE_PATH + "/" + LAND_PATH + "/" + landName;
    }

    public static String getBierPath( final String bierName )
    {
        return LISTE_PATH + "/" + BIER_PATH + "/" + bierName;
    }

    public static String getSortePath( final String sorteName )
    {
        return LISTE_PATH + "/" + SORTE_PATH + "/" + sorteName;
    }

    public static String getKontinentePath()
    {
        return LISTE_PATH + "/" + KONTINENTE_PATH;
    }

    public static String getBestenlistePath()
    {
        return LISTE_PATH + "/" + BESTENLISTE_PATH;
    }

//    public static String getSchlechtestelistePath()
//    {
//        return LISTE_PATH + "/" + SCHLECHTESTELISTE_PATH;
//    }
}
