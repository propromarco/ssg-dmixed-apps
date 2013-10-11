/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.shared;

public class UriUtils implements Uris {
    public static String getKontinentPath(final String basePath, final String kontinentName) {
        return basePath + getKontinentPath(kontinentName);
    }

    public static String getKontinentPath(final String kontinentName) {
        return LISTE_PATH + "/" + KONTINENT_PATH + "/" + kontinentName;
    }

    public static String getLandPath(final String basePath, final String landName) {
        return basePath + getLandPath(landName);
    }

    public static String getLandPath(final String landName) {
        return LISTE_PATH + "/" + LAND_PATH + "/" + landName;
    }

    public static String getBierPath(final String basePath, final String bierName) {
        return basePath + getBierPath(bierName);
    }

    public static String getBierPath(final String bierName) {
        return LISTE_PATH + "/" + BIER_PATH + "/" + bierName;
    }

    public static String getSortePath(final String basePath, final String sorteName) {
        return basePath + getSortePath(sorteName);
    }

    public static String getSortePath(final String sorteName) {
        return LISTE_PATH + "/" + SORTE_PATH + "/" + sorteName;
    }

    public static String getKontinentePath(final String basePath) {
        return basePath + getKontinentePath();
    }

    public static String getKontinentePath() {
        return LISTE_PATH + "/" + KONTINENTE_PATH;
    }

    public static String getBestenlistePath(final String basePath) {
        return basePath + getBestenlistePath();
    }

    public static String getBestenlistePath() {
        return LISTE_PATH + "/" + BESTENLISTE_PATH;
    }

}
