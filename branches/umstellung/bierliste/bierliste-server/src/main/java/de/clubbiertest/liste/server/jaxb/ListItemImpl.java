/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.server.jaxb;

import java.net.URI;

import de.clubbiertest.liste.shared.ListItem;

public class ListItemImpl implements ListItem
{
    private String id;
    private String name;
    private String uri;
    private boolean bier;

    public ListItemImpl()
    {
    }

    public ListItemImpl( final String id, final String name, final boolean bier, final URI uri )
    {
        this.id = id;
        this.name = name;
        this.bier = bier;
        this.uri = uri.toString();
    }

    /**
     * Getter for property id.
     * @return the value of property id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Setter for property id
     * @param id the new value for property id to set.
     */
    public void setId( final String id )
    {
        this.id = id;
    }

    /**
     * Getter for property name.
     * @return the value of property name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for property name
     * @param name the new value for property name to set.
     */
    public void setName( final String name )
    {
        this.name = name;
    }

    /**
     * Getter for property uri.
     * @return the value of property uri
     */
    public String getUri()
    {
        return uri;
    }

    /**
     * Setter for property uri
     * @param uri the new value for property uri to set.
     */
    public void setUri( final String uri )
    {
        this.uri = uri;
    }

    /**
     * Getter for property bier.
     * @return the value of property bier
     */
    public boolean isBier()
    {
        return bier;
    }

    /**
     * Setter for property bier
     * @param bier the new value for property bier to set.
     */
    public void setBier( final boolean bier )
    {
        this.bier = bier;
    }
}
