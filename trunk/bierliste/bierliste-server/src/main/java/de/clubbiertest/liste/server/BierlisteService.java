/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.liste.server;

import java.net.URI;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import javax.ws.rs.core.UriInfo;

import de.clubbiertest.liste.server.jaxb.BierApplication;
import de.clubbiertest.liste.server.jaxb.BierImpl;
import de.clubbiertest.liste.server.jaxb.ListeItemsImpl;
import de.clubbiertest.liste.server.jaxb.ListeItemsImpl.UriCallback;
import de.clubbiertest.liste.server.util.ListeParser;
import de.clubbiertest.liste.server.util.OrderUtils;
import de.clubbiertest.liste.server.util.UriUtils;
import de.clubbiertest.liste.shared.SortType;
import de.clubbiertest.liste.shared.Uris;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Path( UriUtils.LISTE_PATH ) @Produces( { APPLICATION_JSON, APPLICATION_XML } ) @Consumes( { APPLICATION_JSON, APPLICATION_XML } )
public class BierlisteService
{
    @Context private UriInfo info;

    private final ListeParser liste;

    public BierlisteService()
    {
        this.liste = ListeParser.getInstance();
    }

    public void setInfo( final UriInfo info )
    {
        this.info = info;
    }

    @GET public BierApplication getApplication()
    {
        return BierApplication.createFrom(this.info);
    }

    @GET @Path( UriUtils.BESTENLISTE_PATH )
    public ListeItemsImpl getBestenliste()
    {
        final NodeList beste = this.liste.getBestenliste();
        final List<Element> liste = OrderUtils.order(beste, SortType.sortByNoteDown);
        final UriCallback callback = new UriCallback()
        {
            public URI createUri( final String name )
            {
                return BierlisteService.this.info.getBaseUriBuilder().path(UriUtils.getBierPath(name)).build();
            }
        };
        final ListeItemsImpl listeItemsImpl = new ListeItemsImpl(Uris.BESTENLISTE_ID, "Bestenliste", liste, callback);
        listeItemsImpl.setOrdered(false);
        return listeItemsImpl;
    }

    @GET @Path( UriUtils.KONTINENTE_PATH )
    public ListeItemsImpl getKontinente()
    {
        final NodeList kontinente = this.liste.getKontinente();
        final UriCallback callback = new UriCallback()
        {
            public URI createUri( final String name )
            {
                return BierlisteService.this.info.getBaseUriBuilder().path(UriUtils.getKontinentPath(name)).build();
            }
        };
        final ListeItemsImpl listeItemsImpl = new ListeItemsImpl(Uris.KONTINENTE_ID, "Kontinente", kontinente, callback);
        listeItemsImpl.setOrdered(true);
        return listeItemsImpl;
    }

    @GET @Path( UriUtils.KONTINENT_PATH + "/{name}" )
    public ListeItemsImpl getKontinent( @PathParam( "name" ) final String name )
    {
        final Element kontinent = this.liste.getKontinent(name);
        final String kontinentName = kontinent.getAttribute("name");
        final UriCallback callback = new UriCallback()
        {
            public URI createUri( final String name )
            {
                return BierlisteService.this.info.getBaseUriBuilder().path(UriUtils.getLandPath(name)).build();
            }
        };
        final ListeItemsImpl listeItemsImpl = new ListeItemsImpl(Uris.KONTINENT_ID, kontinentName, kontinent.getChildNodes(), callback);
        listeItemsImpl.setOrdered(true);
        return listeItemsImpl;
    }

    @GET @Path( UriUtils.LAND_PATH + "/{name}" )
    public ListeItemsImpl getLand( @PathParam( "name" ) final String name )
    {
        final Element land = this.liste.getLand(name);
        final String landName = land.getAttribute("name");
        final UriCallback callback = new UriCallback()
        {
            public URI createUri( final String subname )
            {
                if ( "Deutschland".equals(name) )
                {
                    return BierlisteService.this.info.getBaseUriBuilder().path(UriUtils.getSortePath(subname)).build();
                }
                else
                {
                    return BierlisteService.this.info.getBaseUriBuilder().path(UriUtils.getBierPath(subname)).build();
                }
            }
        };
        final ListeItemsImpl listeItemsImpl = new ListeItemsImpl(Uris.LAND_ID, landName, land.getChildNodes(), callback);
        listeItemsImpl.setOrdered(true);
        return listeItemsImpl;
    }

    @GET @Path( UriUtils.SORTE_PATH + "/{name}" )
    public ListeItemsImpl getSorte( @PathParam( "name" ) final String name )
    {
        final Element sorte = this.liste.getSorte(name);
        final String sorteName = sorte.getAttribute("name");
        final UriCallback callback = new UriCallback()
        {
            public URI createUri( final String name )
            {
                return BierlisteService.this.info.getBaseUriBuilder().path(UriUtils.getBierPath(name)).build();
            }
        };
        final ListeItemsImpl listeItemsImpl = new ListeItemsImpl(Uris.SORTE_ID, sorteName, sorte.getChildNodes(), callback);
        listeItemsImpl.setOrdered(true);
        return listeItemsImpl;
    }

    @GET @Path( UriUtils.BIER_PATH + "/{name}" )
    public BierImpl getBier( @PathParam( "name" ) final String name )
    {
        final Element bier = this.liste.getBier(name);
        return new BierImpl(bier);
    }

    @GET @Path( UriUtils.SEARCH_PATH + "/{name}" )
    public ListeItemsImpl search( @PathParam( "name" ) final String name )
    {
        final NodeList el = this.liste.search(name);
        final List<Element> newNodes = OrderUtils.order(el, SortType.sortByNameUp);
        final UriCallback callback = new UriCallback()
        {
            public URI createUri( final String name )
            {
                return BierlisteService.this.info.getBaseUriBuilder().path(UriUtils.getBierPath(name)).build();
            }
        };
        return new ListeItemsImpl(Uris.SUCHE_ID, "Suchergebnis", newNodes, callback);
    }
}
