/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.liste.server.util;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ListeParser
{
    private static ListeParser instance;
    private Document liste;
    private final XPath xPath;

    private ListeParser()
    {
        final XPathFactory xFactory = XPathFactory.newInstance();
        this.xPath = xFactory.newXPath();
        try
        {
            final DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = builder.newDocumentBuilder();
            final InputStream is = getClass().getResourceAsStream("/META-INF/liste.xml");
            this.liste = documentBuilder.parse(is);
            is.close();
        }
        catch ( final Exception e )
        {
            throw new RuntimeException(e);
        }
    }

    public static ListeParser getInstance()
    {
        if ( instance == null )
        {
            instance = new ListeParser();
        }
        return instance;
    }

    public NodeList getBestenliste()
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//bier[@note >= 8.0]");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODESET);
            return (NodeList) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public NodeList getSchlechtesteliste()
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//bier[@note <= 3 and @note > 0]");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODESET);
            return (NodeList) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public NodeList getKontinente()
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//kontinent");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODESET);
            return (NodeList) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public NodeList getAlleBiere()
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//bier");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODESET);
            return (NodeList) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public Element getKontinent( final String name )
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//kontinent[@name='" + name + "']");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODE);
            return (Element) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public Element getLand( final String name )
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//land[@name='" + name + "']");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODE);
            return (Element) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public Element getSorte( final String name )
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//sorte[@name='" + name + "']");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODE);
            return (Element) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public Element getBier( final String name )
    {
        try
        {
            final XPathExpression expr = this.xPath.compile("//bier[@name='" + name + "']");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODE);
            return (Element) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    public NodeList search( final String search )
    {
        try
        {
            final String trans = "'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'";
            final XPathExpression expr = this.xPath.compile("//bier[contains(translate(@name," + trans + "),translate('" + search + "'," + trans
                                             + "))]");
            final Object result = expr.evaluate(this.liste, XPathConstants.NODESET);
            return (NodeList) result;
        }
        catch ( final XPathExpressionException e )
        {
            e.printStackTrace();
            return null;
        }
    }

    Document getListe()
    {
        return this.liste;
    }
}
