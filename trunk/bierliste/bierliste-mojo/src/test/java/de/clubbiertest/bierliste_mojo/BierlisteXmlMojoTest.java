/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.bierliste_mojo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import junit.framework.TestCase;

public class BierlisteXmlMojoTest extends TestCase
{
    public void testGenerate()
            throws Exception
    {
        final InputStream accessIs = getClass().getResourceAsStream("/access.xml");
        final InputStream kontinenteIs = getClass().getResourceAsStream("/kontinente.xml");
        final ByteArrayOutputStream resultOs = new ByteArrayOutputStream();
        final StXMLEncodedWriter writer = new StXMLEncodedWriter(resultOs);
        final Source access = new StreamSource(accessIs);
        final Source kontinente = new StreamSource(kontinenteIs);
        final Result result = new StreamResult(writer);
        BierlisteXmlMojo.generateXml(access, kontinente, result);
        accessIs.close();
        kontinenteIs.close();
        resultOs.close();
        writer.close();
        System.out.println(new String(resultOs.toByteArray()));
    }
}
