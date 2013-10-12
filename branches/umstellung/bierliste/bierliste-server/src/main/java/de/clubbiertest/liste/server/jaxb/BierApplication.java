/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.server.jaxb;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;

import de.clubbiertest.liste.shared.UriUtils;

@XmlRootElement
public class BierApplication
{
    private List<ListItemImpl> childs = new ArrayList<ListItemImpl>();

    public BierApplication()
    {
    }

    /**
     * Getter for property childs.
     * @return the value of property childs
     */
    public List<ListItemImpl> getChilds()
    {
        return childs;
    }

    /**
     * Setter for property childs
     * @param childs the new value for property childs to set.
     */
    public void setChilds( final List<ListItemImpl> childs )
    {
        this.childs = childs;
    }

    public static BierApplication createFrom( final UriInfo info )
    {
        final BierApplication app = new BierApplication();
        {
            final URI uri = info.getBaseUriBuilder().path(UriUtils.getKontinentePath()).build();
            app.childs.add(new ListItemImpl("kontinente", "Komplette Liste", false, uri));
        }
        {
            final URI uri = info.getBaseUriBuilder().path(UriUtils.getBestenlistePath()).build();
            app.childs.add(new ListItemImpl("beste", "Bestenliste", false, uri));
        }
//        {
//            final URI uri = info.getBaseUriBuilder().path(UriUtils.getSchlechtestelistePath()).build();
//            app.childs.add(new ListItemImpl("schlechteste", "Schlechteste", false, uri));
//        }
        return app;
    }
}
