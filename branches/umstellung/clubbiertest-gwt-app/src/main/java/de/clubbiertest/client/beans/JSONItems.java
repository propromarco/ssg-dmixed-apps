/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.client.beans;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class JSONItems implements ListeItems
{
    private final ArrayList<ListItem> childs;
    private final String id;
    private final String name;
    private final boolean ordered;

    public JSONItems( final JSONObject obj )
    {
        this.childs = new ArrayList<ListItem>();
        this.id = JSONUtils.getString(obj.get("id"));
        this.name = JSONUtils.getString(obj.get("name"));
        this.ordered = JSONUtils.getBoolean(obj.get("ordered"));
        final JSONValue jsonValue = obj.get("childs");
        if ( jsonValue != null )
        {
            final JSONArray koo = jsonValue.isArray();
            for ( int i = 0; i < koo.size(); i++ )
            {
                final JSONObject object = koo.get(i).isObject();
                this.childs.add(new JSONItem(object));
            }
        }
    }

    @Override public List<ListItem> getChilds()
    {
        return this.childs;
    }

    /**
     * Getter for property id.
     * @return the value of property id
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * Getter for property name.
     * @return the value of property name
     */
    public String getName()
    {
        return this.name;
    }

    public boolean isOrdered()
    {
        return this.ordered;
    }
}
