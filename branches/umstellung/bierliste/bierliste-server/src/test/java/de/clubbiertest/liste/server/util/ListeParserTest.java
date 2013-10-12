/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.liste.server.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListeParserTest
{
    private ListeParser parser;

    @Before public void setUp()
            throws Exception
    {
        this.parser = ListeParser.getInstance();
    }

    @Test public void testGetListe()
    {
        final Document liste = this.parser.getListe();
        assertNotNull(liste);
        checkRoot(liste.getDocumentElement());
    }

    private void checkRoot( final Element documentElement )
    {
        assertEquals("liste", documentElement.getNodeName());
        final NodeList childNodes = documentElement.getChildNodes();
        for ( int i = 0; i < childNodes.getLength(); i++ )
        {
            final Node node = childNodes.item(i);
            checkkontinent(node);
        }
    }

    private void checkkontinent( final Node checknode )
    {
        assertEquals("kontinent", checknode.getNodeName());
        final NodeList childNodes = checknode.getChildNodes();
        for ( int i = 0; i < childNodes.getLength(); i++ )
        {
            final Node node = childNodes.item(i);
            checkland(node);
        }
    }

    private void checkland( final Node checknode )
    {
        assertEquals("land", checknode.getNodeName());
        final NodeList childNodes = checknode.getChildNodes();
        for ( int i = 0; i < childNodes.getLength(); i++ )
        {
            final Node node = childNodes.item(i);
            if ( node.getNodeName().equals("sorte") )
            {
                checksorte(node);
            }
            else
            {
                checkbier(node);
            }
        }
    }

    private void checksorte( final Node checknode )
    {
        assertEquals("sorte", checknode.getNodeName());
        final NodeList childNodes = checknode.getChildNodes();
        for ( int i = 0; i < childNodes.getLength(); i++ )
        {
            final Node node = childNodes.item(i);
            checkbier(node);
        }
    }

    private void checkbier( final Node checknode )
    {
        assertEquals("bier", checknode.getNodeName());
    }
}
