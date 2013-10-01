/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.server.jaxb;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;
import de.clubbiertest.liste.shared.SortUtil;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@XmlRootElement public class ListeItemsImpl implements ListeItems
{
    public interface UriCallback
    {
        URI createUri( String i1 );
    }

    private String id, name;
    private List<ListItem> childs = new ArrayList<ListItem>();
    private boolean ordered;

    public ListeItemsImpl()
    {
    }

    public ListeItemsImpl( final String id, final String name, final NodeList nodes, final UriCallback callback )
    {
        this.id = id;
        this.name = name;
        for ( int i = 0; i < nodes.getLength(); i++ )
        {
            final Element element = (Element) nodes.item(i);
            final String n = element.getAttribute("name");
            final String i1 = SortUtil.replace(n);
            final URI uri = callback.createUri(n);
            final ListItemImpl l = new ListItemImpl(i1, n, element.getNodeName().equals("bier"), uri);
            childs.add(l);
        }
    }

    public ListeItemsImpl( final String id, final String name, final List<Element> nodes, final UriCallback callback )
    {
        this.id = id;
        this.name = name;
        for ( int i = 0; i < nodes.size(); i++ )
        {
            final Element element = nodes.get(i);
            final String n = element.getAttribute("name");
            final String i1 = SortUtil.replace(n);
            final URI uri = callback.createUri(n);
            final ListItemImpl l = new ListItemImpl(i1, n, element.getNodeName().equals("bier"), uri);
            childs.add(l);
        }
    }

    @XmlJavaTypeAdapter( ListItemAdapter.class )
    public List<ListItem> getChilds()
    {
        return childs;
    }

    public void setChilds( final List<ListItem> childs )
    {
        this.childs = childs;
    }

    public void setId( final String id )
    {
        this.id = id;
    }

    public void setName( final String name )
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Getter for property ordered.
     * @return the value of property ordered
     */
    public boolean isOrdered()
    {
        return ordered;
    }

    /**
     * Setter for property ordered
     * @param ordered the new value for property ordered to set.
     */
    public void setOrdered( final boolean ordered )
    {
        this.ordered = ordered;
    }
}
