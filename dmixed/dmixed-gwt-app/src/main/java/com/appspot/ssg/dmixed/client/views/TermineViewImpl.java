/* Copyright, (c) 2013 Suretec GmbH  */

package com.appspot.ssg.dmixed.client.views;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.LoginActivity.WithTapHandlers;
import com.appspot.ssg.dmixed.client.activities.TermineActivity.TermineView;
import com.appspot.ssg.dmixed.client.components.IDatePickerDesign;
import com.appspot.ssg.dmixed.client.views.components.ButtonWithWait;
import com.appspot.ssg.dmixed.client.views.components.CellListWithHeader;
import com.appspot.ssg.dmixed.client.views.components.CellListWithHeader.BasicCell;
import com.appspot.ssg.dmixed.client.views.components.CssCheckBox;
import com.appspot.ssg.dmixed.client.views.components.CssDateBox;
import com.appspot.ssg.dmixed.client.views.components.CssListBox;
import com.appspot.ssg.dmixed.client.views.components.CssTextArea;
import com.appspot.ssg.dmixed.client.views.components.CssTextBox;
import com.appspot.ssg.dmixed.client.views.components.FormListEntry;
import com.appspot.ssg.dmixed.client.views.components.HasCellSelectedHandler;
import com.appspot.ssg.dmixed.client.views.components.HasValues;
import com.appspot.ssg.dmixed.client.views.components.TabPanel;
import com.appspot.ssg.dmixed.client.views.components.WidgetList;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITermin;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class TermineViewImpl extends AbstractDmixedView implements TermineView
{
    private final CellListWithHeader<ITermin> _cellList;
    private final CssDateBox terminDatum;
    private final TextBox kurzbeschreibung;
    private final CheckBox heimspiel;
    private final CssListBox liga;
    private ButtonWithWait newTerminButton;
    private TextArea beschreibung;

    public TermineViewImpl( final IDMixedMessages messages, final IDatePickerDesign iDatePickerDesign )
    {
        super(messages);
        setHeaderText("Termin&uuml;bersicht");
        _cellList = new CellListWithHeader<ITermin>(new BasicCell<ITermin>()
        {
            @Override public String getDisplayString( final ITermin termin )
            {
                final Date termineDatum = termin.getTermineDatum();
                final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
                final ILiga liga = termin.getLiga();
                final String bezeichnung = liga.getBezeichnung();
                final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
                final String d = formatter.format(termineDatum);
                final String title = terminKurzbeschreibung + "-" + bezeichnung + " - " + d;
                return title;
            }

            @Override public boolean canBeSelected( final ITermin model )
            {
                return true;
            }
        });

        // _cellList.getCellList().setRound(true);

        final ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.setWidget(_cellList);
        // scrollPanel.setScrollingEnabledX(false);

        final TabPanel tabPanel = new TabPanel();
        final Anchor termine = new Anchor();
        termine.setText(messages.termine());
        tabPanel.add(termine, scrollPanel);
        final Anchor neuerTermin = new Anchor();
        neuerTermin.setText(messages.neuerTermin());

        final FlowPanel container = new FlowPanel();
        container.setStyleName("form");
        {
            final WidgetList widgetList = new WidgetList();

            // lets put in some widgets
            this.terminDatum = new CssDateBox(iDatePickerDesign);
            terminDatum.setValue(new Date());
            widgetList.add(new FormListEntry(messages.terminCreateDatum(), terminDatum));
            this.kurzbeschreibung = new CssTextBox();
            widgetList.add(new FormListEntry(messages.terminCreateKurzbeschreibung(), kurzbeschreibung));
            this.heimspiel = new CssCheckBox();
            widgetList.add(new FormListEntry(messages.terminCreateHeimspiel(), heimspiel));
            this.liga = new CssListBox();
            widgetList.add(new FormListEntry(messages.terminCreateLiga(), liga));
            this.beschreibung = new CssTextArea();
            beschreibung.setVisibleLines(5);
            widgetList.add(new FormListEntry(messages.terminCreateBeschreibung(), beschreibung));
            container.add(widgetList);
            this.newTerminButton = new ButtonWithWait(messages.createTermin());
            container.add(newTerminButton);
        }
        tabPanel.add(neuerTermin, container);
        _layoutPanel.add(tabPanel);
        //versuch fuer spezifische names
        _layoutPanel.setStyleName("layoutpanel terminuebersicht_page");

    }

    @Override public HasCellSelectedHandler<ITermin> getCellSelectedHandler()
    {
        return _cellList.getCellList();
    }

    @Override public void updateList( final List<ITermin> termine )
    {
        _cellList.getCellList().render(termine);
    }

    @Override public HasValue<Date> getTerminDatum()
    {
        return terminDatum;
    }

    @Override public HasValue<String> getKurzbeschreibung()
    {
        return kurzbeschreibung;
    }

    @Override public HasValue<String> getBeschreibung()
    {
        return beschreibung;
    }

    @Override public HasValue<Boolean> getHeimspiel()
    {
        return heimspiel;
    }

    @Override public HasValues<ILiga> getLiga()
    {
        return liga;
    }

    @Override public WithTapHandlers getNewTerminButton()
    {
        return newTerminButton;
    }
}
