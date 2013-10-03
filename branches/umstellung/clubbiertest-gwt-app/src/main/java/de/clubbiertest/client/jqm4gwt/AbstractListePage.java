/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.client.jqm4gwt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.Mobile;
import com.sksamuel.jqm4gwt.list.JQMList;
import com.sksamuel.jqm4gwt.list.JQMListItem;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.client.jqm4gwt.ListPage.BeforeListImpl;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public abstract class AbstractListePage extends JQMPage
{
    protected final StServerCommunicationUtil util;
    private final JQMList liste;
    private final Map<JQMListItem, JQMPage> items = new HashMap<JQMListItem, JQMPage>();
    protected final Before before;
    protected final JQMHeader header;

    public interface After
    {
        void onComplete();
    }

    public interface Before
    {
        String getName();

        void setName( String name );

        String getUri();

        void setItem( ListItem listItem );
    }

    public AbstractListePage( final Before before, final StServerCommunicationUtil util )
    {
        this.before = before;
        this.util = util;
        this.header = new JQMHeader("");
        add(this.header);
        this.liste = new JQMList();
        add(this.liste);
    }

    @Override protected void onPageShow()
    {
        super.onPageShow();
        final String name = ( this.before == null ) ? "": ( this.before.getName() == null ) ? "": this.before.getName();
        this.header.setText(name);
        Mobile.showLoadingDialog(ClubbiertestTexte.TEXTE.ladeDaten());
        final After after = new After()
        {
            @Override public void onComplete()
            {
                Mobile.hideLoadingDialog();
            }
        };
        loadPage(after);
    }

    protected void fillList( final ListeItems result )
    {
        for ( final JQMListItem item: this.items.keySet() )
        {
            final JQMPage jqmPage = this.items.get(item);
            jqmPage.removeFromParent();
        }
        this.items.clear();
        this.liste.clear();

        final List<ListItem> childs = result.getChilds();
        final boolean addDivider = ( childs.size() > 20 ) && result.isOrdered();
        char start = ' ';
        final Before newBefore = new BeforeListImpl();
        final BierPage bierPage = new BierPage(newBefore, this.util);
        final ListPage listPage = new ListPage(newBefore, this.util);
        for ( final ListItem listItem: childs )
        {
            final char c = listItem.getId().charAt(0);
            if ( start != c )
            {
                start = c;
                final char upper = Character.toUpperCase(c);
                if ( addDivider )
                {
                    this.liste.addDivider(Character.toString(upper));
                }
            }
            final JQMPage page;
            if ( listItem.isBier() )
            {
                page = bierPage;
            }
            else
            {
                page = listPage;
            }
            final JQMListItem item = this.liste.addItem(listItem.getName(), page);
            final ClickHandler handler = new ClickHandler()
            {
                @Override public void onClick( final ClickEvent event )
                {
                    newBefore.setItem(listItem);
                }
            };
            item.addDomHandler(handler, ClickEvent.getType());
            this.items.put(item, page);
        }
        this.liste.refresh();
    }

    protected abstract void loadPage( final After after );
}
