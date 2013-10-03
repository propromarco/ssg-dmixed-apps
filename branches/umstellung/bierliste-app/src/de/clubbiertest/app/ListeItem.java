/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app;

import java.io.Serializable;

import de.clubbiertest.app.liste.AbstractSorter;

public class ListeItem implements Serializable
{
    private static final long serialVersionUID = 3304662060369786323L;

    private long id;
    private final String name, replacedName;
    private Double design, note;
    private String land;
    private Integer childSize;
    private String uri;
    private boolean bier;

    private String search;

    private String sorte;

    public ListeItem( final String name )
    {
        this.name = name;
        this.replacedName = AbstractSorter.replace(name);
    }

    public long getId()
    {
        return this.id;
    }

    public void setId( final long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getReplacedName()
    {
        return this.replacedName;
    }

    public void setDesign( final Double design )
    {
        this.design = design;
    }

    public Double getDesign()
    {
        return this.design;
    }

    public void setNote( final Double note )
    {
        this.note = note;
    }

    public Double getNote()
    {
        return this.note;
    }

    public String getLand()
    {
        return this.land;
    }

    public void setLand( final String land )
    {
        this.land = land;
    }

    public void setChildSize( final Integer childSize )
    {
        this.childSize = childSize;
    }

    public Integer getChildSize()
    {
        return this.childSize;
    }

    public void setUri( final String uri )
    {
        this.uri = uri;
    }

    public String getUri()
    {
        return this.uri;
    }

    public boolean isBier()
    {
        return this.bier;
    }

    public void setBier( final boolean bier )
    {
        this.bier = bier;
    }

    public void setSearch( final String search )
    {
        this.search = search;
    }

    public String getSearch()
    {
        return this.search;
    }

    public String getSorte()
    {
        return this.sorte;
    }

    public void setSorte( final String sorte )
    {
        this.sorte = sorte;
    }
}
