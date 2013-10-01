/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.shared;

import java.util.List;

public interface ListeItems
{
    /**
     * Getter for property id.
     * @return the value of property id
     */
    public String getId();

    /**
     * Getter for property name.
     * @return the value of property name
     */
    public String getName();

    /**
     * Getter for property childs.
     * @return the value of property childs
     */
    List<ListItem> getChilds();

    /**
     * Getter for property ordered.
     * @return the value of property ordered
     */
    public boolean isOrdered();
}
