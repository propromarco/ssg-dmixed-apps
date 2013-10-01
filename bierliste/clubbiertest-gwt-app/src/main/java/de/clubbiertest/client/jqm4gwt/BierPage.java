/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.client.jqm4gwt;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;

import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.client.jqm4gwt.AbstractListePage.Before;
import de.clubbiertest.liste.shared.AbstractListe.Async;
import de.clubbiertest.liste.shared.Bier;

public class BierPage extends JQMPage
{
    public class BierNotTestet extends FlowPanel
    {
        public BierNotTestet()
        {
            setStyleName("info-section");
            final HTML val = new HTML(ClubbiertestTexte.TEXTE.nichtGetestet());
            val.setStyleName("nottestet");
            add(val);
        }
    }

    private final Before before;
    private final StServerCommunicationUtil util;
    private static final NumberFormat formatter = NumberFormat.getFormat("0.0");

    public class BierInfoSection extends FlowPanel
    {
        public BierInfoSection( final String description, final Double value )
        {
            this(description, ((( value != null ) && ( value > 0.0 ))) ? formatter.format(value): null);
        }

        public BierInfoSection( final String description, final String value )
        {
            setStyleName("info-section");
            final HTML desc = new HTML(description);
            desc.setStyleName("description");
            add(desc);
            final HTML val = new HTML(value);
            val.setStyleName("value");
            add(val);
            setVisible(value != null);
            final Panel p = new FlowPanel();
            p.setStyleName("ende");
            add(p);
        }

    }

    private boolean loaded = false;
    private final JQMHeader header;

    public BierPage( final Before before, final StServerCommunicationUtil util )
    {
        this.before = before;
        this.util = util;
        this.header = new JQMHeader("");
        add(this.header);
    }

    @Override protected void onPageShow()
    {
        super.onPageShow();
        this.header.setText(this.before.getName());
        if ( !this.loaded )
        {
            final Async<Bier> async = new Async<Bier>()
            {
                @Override public void onError( final Throwable exception )
                {
                    Window.alert(exception.getMessage());
                }

                @Override public void afterCall( final Bier result )
                {
                    add(new BierInfoSection(ClubbiertestTexte.TEXTE.land(), result.getLand()));
                    add(new BierInfoSection(ClubbiertestTexte.TEXTE.sorte(), result.getSorte()));
                    add(new BierInfoSection(ClubbiertestTexte.TEXTE.name(), result.getName()));
                    add(new BierInfoSection(ClubbiertestTexte.TEXTE.note(), result.getNote()));
                    add(new BierInfoSection(ClubbiertestTexte.TEXTE.design(), result.getDesign()));
                    if ( result.getNote() <= 0 )
                    {
                        add(new BierNotTestet());
                    }
                    BierPage.this.loaded = true;
                }
            };
            this.util.getBier(this.before.getUri(), async);
        }
    }
}
