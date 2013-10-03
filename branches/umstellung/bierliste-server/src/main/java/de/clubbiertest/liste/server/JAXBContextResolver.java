/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.server;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONConfiguration.NaturalBuilder;
import com.sun.jersey.api.json.JSONJAXBContext;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Provider public final class JAXBContextResolver implements ContextResolver<JAXBContext>
{
    private final JSONConfiguration config;

    public JAXBContextResolver()
            throws Exception
    {
        final NaturalBuilder builder = JSONConfiguration.natural();
        this.config = builder.build();
    }

    public JAXBContext getContext( final Class<?> objectType )
    {
        JSONJAXBContext context;
        try
        {
            context = new JSONJAXBContext(this.config, objectType);
        }
        catch ( final JAXBException e )
        {
            throw new RuntimeException(e);
        }
        return context;
    }
}
