/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.client.jqm4gwt;

import com.google.gwt.user.client.Window;

import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.liste.shared.AbstractListe.Async;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class ListPage extends AbstractListePage
{
    static class BeforeListImpl implements Before
    {
        private ListItem item;

        public BeforeListImpl()
        {
        }

        public BeforeListImpl( final ListItem item )
        {
            this.item = item;
        }

        @Override public String getName()
        {
            final String name = this.item.getName();
            return name;
        }

        @Override public String getUri()
        {
            final String uri = this.item.getUri();
            return uri;
        }

        @Override public void setName( final String name )
        {
        }

        @Override public void setItem( final ListItem listItem )
        {
            this.item = listItem;
        }

    }

    public ListPage( final Before before, final StServerCommunicationUtil util )
    {
        super(before, util);
    }

    @Override protected void loadPage( final After after )
    {
        final Async<ListeItems> async = new Async<ListeItems>()
        {
            @Override public void onError( final Throwable exception )
            {
                Window.alert(exception.getMessage());
            }

            @Override public void afterCall( final ListeItems result )
            {
                fillList(result);
                after.onComplete();
            }
        };
        this.util.call(this.before.getUri(), async);
    }
}
