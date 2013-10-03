/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface ClubbiertestTexte extends Messages
{
    ClubbiertestTexte TEXTE = GWT.create(ClubbiertestTexte.class);

    String ladeDaten();

    String land();

    String sorte();

    String name();

    String note();

    String design();

    String nichtGetestet();

    String willkommen();

    String unabhaengig();

    String suchergebnis();

    String about();

    String about1();

    String about2();

    String about3();
}
