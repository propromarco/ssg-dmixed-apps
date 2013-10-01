/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.client.jqm4gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;

import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.button.JQMButton;
import com.sksamuel.jqm4gwt.button.JQMButtonGroup;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

import de.clubbiertest.client.ClubbiertestResources;
import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.client.beans.JSONItem;
import de.clubbiertest.client.jqm4gwt.AbstractListePage.Before;
import de.clubbiertest.client.jqm4gwt.ListPage.BeforeListImpl;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.Uris;

public class JQMWelcomePage extends JQMPage
{
    static class BeforeWelcomImpl implements Before
    {
        private String name;

        public BeforeWelcomImpl()
        {
        }

        @Override public String getName()
        {
            return this.name;
        }

        @Override public String getUri()
        {
            return null;
        }

        @Override public void setName( final String name )
        {
            this.name = name;
        }

        @Override public void setItem( final ListItem listItem )
        {
        }

    }

    public JQMWelcomePage( final StServerCommunicationUtil util )
    {
        add(new JQMHeader(ClubbiertestTexte.TEXTE.willkommen()));
        final FlowPanel bildDescriptionContainer = new FlowPanel();
        bildDescriptionContainer.setStyleName("willkommen-first");
        add(bildDescriptionContainer);
        final FlowPanel bildContainer = new FlowPanel();
        bildContainer.setStyleName("willkommen-bild");
        final Image image = new Image(ClubbiertestResources.RESOURCES.anfang());
        bildContainer.add(image);
        bildDescriptionContainer.add(bildContainer);
        final HTML unabhaengig = new HTML(ClubbiertestTexte.TEXTE.unabhaengig());
        unabhaengig.setStyleName("willkommen-bild-beschriftung");
        bildDescriptionContainer.add(unabhaengig);
        final FlowPanel inputContainer = new FlowPanel();
        inputContainer.setStyleName("willkommen-second");
        add(inputContainer);
        final JQMButtonGroup grp = new JQMButtonGroup();
        {
            final String name = "Bestenliste";
            final String url = GWT.getHostPageBaseURL() + "services/" + Uris.LISTE_PATH + "/" + Uris.BESTENLISTE_PATH;
            final ListItem listItem = new JSONItem(name, url);
            final Before before = new BeforeListImpl(listItem);
            final ListPage page = new ListPage(before, util);
            final JQMButton button = new JQMButton(name, page);
            grp.add(button);
        }
        {
            final String name = "komplette Liste";
            final String url = GWT.getHostPageBaseURL() + "services/" + Uris.LISTE_PATH + "/" + Uris.KONTINENTE_PATH;
            final ListItem listItem = new JSONItem(name, url);
            final Before before = new BeforeListImpl(listItem);
            final ListPage page = new ListPage(before, util);
            final JQMButton button = new JQMButton(name, page);
            grp.add(button);
        }
        {
            final JQMButton button = new JQMButton(ClubbiertestTexte.TEXTE.about(), new AboutPage());
            grp.add(button);
        }
        inputContainer.add(grp);
        {
            final TextBox search = new TextBox();
            final Before before = new BeforeWelcomImpl();
            final SearchPage page = new SearchPage(before, util);
            final ChangeHandler handler = new ChangeHandler()
            {
                @Override public void onChange( final ChangeEvent event )
                {
                    final HasText hasText = (HasText) event.getSource();
                    final String searchText = hasText.getText();
                    page.setSearchText(searchText);
                    JQMContext.changePage(page);
                }
            };
            search.addChangeHandler(handler);
            inputContainer.add(search);
        }
    }
}
