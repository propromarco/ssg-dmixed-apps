/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.server.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import de.clubbiertest.liste.shared.ListItem;

public class ListItemAdapter extends XmlAdapter<ListItemImpl, ListItem>
{
    @Override
    public ListItemImpl marshal( final ListItem v ) throws Exception
    {
        return (ListItemImpl) v;
    }

    @Override
    public ListItem unmarshal( final ListItemImpl v ) throws Exception
    {
        return v;
    }
}
