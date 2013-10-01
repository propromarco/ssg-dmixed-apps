/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.liste.server;

import java.lang.reflect.Method;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;
import javax.ws.rs.core.UriInfo;

import de.clubbiertest.liste.server.jaxb.BierApplication;
import de.clubbiertest.liste.server.jaxb.BierImpl;
import de.clubbiertest.liste.server.jaxb.ListItemImpl;
import de.clubbiertest.liste.server.jaxb.ListeItemsImpl;
import de.clubbiertest.liste.shared.ListItem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BierlisteServiceTest
{
    private class TestBuilder extends UriBuilder
    {
        @Override public URI build( final Object... values )
                throws IllegalArgumentException, UriBuilderException
        {
            try
            {
                return new URI("");
            }
            catch ( final URISyntaxException e )
            {
                e.printStackTrace();
                return null;
            }
        }

        @Override public URI buildFromEncoded( final Object... values )
                throws IllegalArgumentException, UriBuilderException
        {
            return null;
        }

        @Override public URI buildFromEncodedMap( final Map<String, ? extends Object> values )
                throws IllegalArgumentException, UriBuilderException
        {
            return null;
        }

        @Override public URI buildFromMap( final Map<String, ? extends Object> values )
                throws IllegalArgumentException, UriBuilderException
        {
            return null;
        }

        @Override public UriBuilder clone()
        {
            return null;
        }

        @Override public UriBuilder fragment( final String fragment )
        {
            return null;
        }

        @Override public UriBuilder host( final String host )
                throws IllegalArgumentException
        {
            return new TestBuilder();
        }

        @Override public UriBuilder matrixParam( final String name, final Object... values )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder path( final String path )
                throws IllegalArgumentException
        {
            return new TestBuilder();
        }

        @SuppressWarnings( "unchecked" ) @Override
        public UriBuilder path( final Class resource )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder path( final Method method )
                throws IllegalArgumentException
        {
            return null;
        }

        @SuppressWarnings( "unchecked" ) @Override
        public UriBuilder path( final Class resource, final String method )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder port( final int port )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder queryParam( final String name, final Object... values )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder replaceMatrix( final String matrix )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder replaceMatrixParam( final String name, final Object... values )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder replacePath( final String path )
        {
            return null;
        }

        @Override public UriBuilder replaceQuery( final String query )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder replaceQueryParam( final String name, final Object... values )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder scheme( final String scheme )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder schemeSpecificPart( final String ssp )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder segment( final String... segments )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder uri( final URI uri )
                throws IllegalArgumentException
        {
            return null;
        }

        @Override public UriBuilder userInfo( final String ui )
        {
            return null;
        }
    }

    private BierlisteService service;

    @Before public void setUp()
            throws Exception
    {
        this.service = new BierlisteService();
        final UriInfo info = new UriInfo()
        {
            @Override public UriBuilder getRequestUriBuilder()
            {
                return null;
            }

            @Override public URI getRequestUri()
            {
                return null;
            }

            @Override public MultivaluedMap<String, String> getQueryParameters( final boolean decode )
            {
                return null;
            }

            @Override public MultivaluedMap<String, String> getQueryParameters()
            {
                return null;
            }

            @Override public List<PathSegment> getPathSegments( final boolean decode )
            {
                return null;
            }

            @Override public List<PathSegment> getPathSegments()
            {
                return null;
            }

            @Override public MultivaluedMap<String, String> getPathParameters( final boolean decode )
            {
                return null;
            }

            @Override public MultivaluedMap<String, String> getPathParameters()
            {
                return null;
            }

            @Override public String getPath( final boolean decode )
            {
                return null;
            }

            @Override public String getPath()
            {
                return null;
            }

            @Override public List<String> getMatchedURIs( final boolean decode )
            {
                return null;
            }

            @Override public List<String> getMatchedURIs()
            {
                return null;
            }

            @Override public List<Object> getMatchedResources()
            {
                return null;
            }

            @Override public UriBuilder getBaseUriBuilder()
            {
                return new TestBuilder();
            }

            @Override public URI getBaseUri()
            {
                return null;
            }

            @Override public UriBuilder getAbsolutePathBuilder()
            {
                return null;
            }

            @Override public URI getAbsolutePath()
            {
                return null;
            }
        };
        this.service.setInfo(info);
    }

    @Test public void testGetApplication()
    {
        final BierApplication application = this.service.getApplication();
        assertNotNull(application);
        final List<ListItemImpl> childs = application.getChilds();
        assertNotNull(childs);
        assertEquals(2, childs.size());
    }

    @Test public void testGetBestenliste()
    {
        final ListeItemsImpl liste = this.service.getBestenliste();
        assertNotNull(liste);
        final List<ListItem> childs = liste.getChilds();
        assertNotNull(childs);
        assertEquals(26, childs.size());
    }

    @Test public void testGetKontinente()
    {
        final ListeItemsImpl liste = this.service.getKontinente();
        assertNotNull(liste);
        final List<ListItem> childs = liste.getChilds();
        assertNotNull(childs);
        assertEquals(5, childs.size());
    }

    @Test public void testGetKontinent()
    {
        final ListeItemsImpl liste = this.service.getKontinent("Europa");
        assertNotNull(liste);
        final List<ListItem> childs = liste.getChilds();
        assertNotNull(childs);
        assertEquals(34, childs.size());
    }

    @Test public void testGetLand()
    {
        final ListeItemsImpl liste = this.service.getLand("Deutschland");
        assertNotNull(liste);
        final List<ListItem> childs = liste.getChilds();
        assertNotNull(childs);
        assertEquals(11, childs.size());
    }

    @Test public void testGetSorte()
    {
        final ListeItemsImpl liste = this.service.getSorte("Alt");
        assertNotNull(liste);
        final List<ListItem> childs = liste.getChilds();
        assertNotNull(childs);
        assertEquals(33, childs.size());
    }

    @Test public void testGetBier()
    {
        final BierImpl bier = this.service.getBier("Bolten Alt");
        assertNotNull(bier);
        assertEquals(6.0, bier.getDesign(), 0);
        assertNull(bier.getId());
        assertEquals("Deutschland", bier.getLand());
        assertEquals("Bolten Alt", bier.getName());
        assertEquals(5.0, bier.getNote(), 0);
        assertEquals("Alt", bier.getSorte());
        assertNull(bier.getUri());
    }

    @Test public void testSearch()
    {
        {
            final ListeItemsImpl liste = this.service.search("alt");
            assertNotNull(liste);
            final List<ListItem> childs = liste.getChilds();
            assertNotNull(childs);
            assertEquals(81, childs.size());
        }
        {
            final ListeItemsImpl liste = this.service.search("ALT");
            assertNotNull(liste);
            final List<ListItem> childs = liste.getChilds();
            assertNotNull(childs);
            assertEquals(81, childs.size());
        }
    }
}
