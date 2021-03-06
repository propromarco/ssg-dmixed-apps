/* Copyright, (c) 2013 Suretec GmbH  */

package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView;
import com.appspot.ssg.dmixed.client.views.components.FormListEntry;
import com.appspot.ssg.dmixed.client.views.components.MitbringRadioButton;
import com.appspot.ssg.dmixed.client.views.components.TabPanel;
import com.appspot.ssg.dmixed.client.views.components.TeilnehmerListBox;
import com.appspot.ssg.dmixed.client.views.components.WidgetList;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;

public class TerminViewImpl extends AbstractDmixedView implements TerminView
{
    private final HTML _beschreibung;
    private final WidgetList _teilnehmerList, _mitbrinselList;
    private ScrollPanel teilnehmerScrollPanel, mitbringselScrollPanel;

    public TerminViewImpl( final IDMixedMessages messages )
    {
        super(messages);
        final TabPanel tabPanel = new TabPanel();
        {
            // Page 1
            final FlowPanel container = new FlowPanel();
            _beschreibung = new HTML();
            _beschreibung.setStyleName("terminBeschreibung");
            container.add(_beschreibung);
            final Anchor allgemein = new Anchor();
            allgemein.setText("\u00DCbersicht");
            tabPanel.add(allgemein, container);
        }
        {
            // Page 2
            _teilnehmerList = new WidgetList();
            _teilnehmerList.setStyleName("listbox");
            this.teilnehmerScrollPanel = new ScrollPanel()
            {
                @Override protected void onAttach()
                {
                    super.onAttach();
//                  wieso eigentlich die hoehe setzen?
//                  final int offsetHeight = getParent().getOffsetHeight() - 20;
//                  setHeight(offsetHeight + "px");
                }
            };
            teilnehmerScrollPanel.setWidget(_teilnehmerList);
            // teilnehmerScrollPanel.setScrollingEnabledX(false);
            final String mitkommen = messages.mitkommen();
            final Anchor teilnehmer = new Anchor();
            teilnehmer.setText(mitkommen);
            tabPanel.add(teilnehmer, teilnehmerScrollPanel);
        }
        {
            // Page 3
            _mitbrinselList = new WidgetList();
            _teilnehmerList.setStyleName("listbox");
            this.mitbringselScrollPanel = new ScrollPanel()
            {
                @Override protected void onAttach()
                {
                    super.onAttach();
//                    final int offsetHeight = getParent().getOffsetHeight() - 20;
//                    setHeight(offsetHeight + "px");
                }
            };
            mitbringselScrollPanel.setWidget(_mitbrinselList);
            // mitbringselScrollPanel.setScrollingEnabledX(false);
            final String mitbringen = messages.mitbringen();
            final Anchor teilnehmer = new Anchor();
            teilnehmer.setText(mitbringen);
            tabPanel.add(teilnehmer, mitbringselScrollPanel);
        }
        _layoutPanel.add(tabPanel);
        //versuch fuer spezifische names
        _layoutPanel.setStyleName("layoutpanel termindetails_page");

    }

    @Override public void setTerminBeschreibung( final String terminBeschreibung )
    {
        _beschreibung.setHTML(terminBeschreibung);
    }

    @Override public IListCreator<ITerminTeilnehmer, ETeilnahmeStatus> fillTeilnehmer()
    {
        _teilnehmerList.clear();
        return new IListCreator<ITerminTeilnehmer, ETeilnahmeStatus>()
        {
            @Override public IListItem<ETeilnahmeStatus> create( final ITerminTeilnehmer terminTeilnehmer, final boolean loggedUser )
            {
                final String vorname = terminTeilnehmer.getVorname();
                final String name = terminTeilnehmer.getName();
                final String komplett = vorname + " " + name;
                final ETeilnahmeStatus teilnahme = terminTeilnehmer.getTeilnahme();
                final TeilnehmerListBox androidRadioButton = new TeilnehmerListBox(_messages, loggedUser);
                androidRadioButton.setValue(teilnahme);
                final FormListEntry entry = new FormListEntry(komplett, androidRadioButton);
                _teilnehmerList.add(entry);
                return androidRadioButton;
            }
        };
    }

    @Override public IListCreator<ITerminMitbringsel, Boolean> fillMitbringsel()
    {
        _mitbrinselList.clear();
        return new IListCreator<ITerminMitbringsel, Boolean>()
        {
            @Override public IListItem<Boolean> create( final ITerminMitbringsel terminMitbringsel, final boolean loggedUser )
            {
                final String beschreibung = terminMitbringsel.getBeschreibung();
                final ITerminTeilnehmer mitbringer = terminMitbringsel.getMitbringer();
                final MitbringRadioButton androidRadioButton = new MitbringRadioButton(beschreibung);
                androidRadioButton.setText(beschreibung);
                final boolean hatMitbringer = mitbringer != null;
                androidRadioButton.setValue(hatMitbringer);
                androidRadioButton.setEnabled(hatMitbringer);
                androidRadioButton.setMitbringer(hatMitbringer ? mitbringer.getName(): null);
                _mitbrinselList.add(androidRadioButton);
                return androidRadioButton;
            }
        };
    }
}
