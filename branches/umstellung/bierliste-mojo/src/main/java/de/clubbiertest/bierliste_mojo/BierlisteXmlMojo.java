/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.bierliste_mojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import org.w3c.dom.Node;

/**
 * @goal generate-xml
 *
 * @phase generate-sources
 */
public class BierlisteXmlMojo extends AbstractMojo
{
    /**
     * Location of the file.
     * @parameter
     * @required
     */
    protected File access;
    /**
     * Location of the file.
     * @parameter
     * @required
     */
    protected File kontinente;

    /**
     * Location of the file.
     * @parameter
     * @required
     */
    protected File output;

    /**
     * Location of the file.
     * @parameter
     * @required
     */
    protected String path;

    /**
     * @parameter expression="${project}"
     * @readonly
     */
    protected MavenProject project;

    public BierlisteXmlMojo()
    {
    }

    public void execute()
            throws MojoExecutionException, MojoFailureException
    {
        try
        {
            if ( this.output.exists() )
            {
                getLog().info("Data uptodate");
                return;
            }
            this.output.getParentFile().mkdirs();
            final StreamSource accessSource = new StreamSource(this.access);
            final StreamSource kontinenteSource = new StreamSource(this.kontinente);
            final OutputStream delegate = new FileOutputStream(this.output);
            final StXMLEncodedWriter writer = new StXMLEncodedWriter(delegate);
            final StreamResult outputResult = new StreamResult(writer);
            generateXml(accessSource, kontinenteSource, outputResult);
            writer.close();
            delegate.close();
            getLog().info("Data genarated");
            final Resource res = new Resource();
            res.setDirectory(this.path);
            this.project.addResource(res);
        }
        catch ( final Exception e )
        {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    protected static void generateXml(
            final Source access,
            final Source kontinente,
            final Result result
    )
            throws ParserConfigurationException, IOException, TransformerException
    {
        final DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
        final TransformerFactory tFactory = TransformerFactory.newInstance();
        final DocumentBuilder documentBuilder = builder.newDocumentBuilder();
        final Node kontinenteDomXsl = documentBuilder.newDocument();
        {
            // Kontinente transformieren
            final InputStream xsl = BierlisteXmlMojo.class.getResourceAsStream("kontinente.xsl");
            final Transformer transformer = tFactory.newTransformer(new StreamSource(xsl));
            xsl.close();
            transformer.transform(kontinente, new DOMResult(kontinenteDomXsl));
        }
        {
            // Access transformieren
            final InputStream xsl = BierlisteXmlMojo.class.getResourceAsStream("preaccess.xsl");
            tFactory.setURIResolver(new URIResolver()
            {
                public Source resolve( final String href, final String base )
                        throws TransformerException
                {
                    return new DOMSource(kontinenteDomXsl);
                }
            });
            final Transformer transformer = tFactory.newTransformer(new StreamSource(xsl));
            xsl.close();
            transformer.transform(access, result);
        }

    }
}
