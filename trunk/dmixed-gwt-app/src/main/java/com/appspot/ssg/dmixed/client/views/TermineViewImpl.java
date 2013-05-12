package com.appspot.ssg.dmixed.client.views;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TermineActivity.TermineView;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlowPanel;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MCheckBox;
import com.googlecode.mgwt.ui.client.widget.MDateBox;
import com.googlecode.mgwt.ui.client.widget.MListBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;
import com.googlecode.mgwt.ui.client.widget.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.HistoryTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.MostRecentTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class TermineViewImpl extends AbstractDmixedView implements TermineView {

    private final CellListWithHeader<ITermin> _cellList;
    private final MDateBox terminDatum;
    private final MTextBox kurzbeschreibung;
    private final MCheckBox heimspiel;
    private final MListBox liga;
    private Button newTerminButton;

    public TermineViewImpl(final IDMixedMessages messages) {
	super(messages);
	setHeaderText("Termine");
	_cellList = new CellListWithHeader<ITermin>(new BasicCell<ITermin>() {

	    @Override
	    public String getDisplayString(final ITermin termin) {
		final Date termineDatum = termin.getTermineDatum();
		final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
		final ILiga liga = termin.getLiga();
		final String bezeichnung = liga.getBezeichnung();
		final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
		final String d = formatter.format(termineDatum);
		final String title = terminKurzbeschreibung + "-" + bezeichnung + " - " + d;
		return title;
	    }

	    @Override
	    public boolean canBeSelected(final ITermin model) {
		return true;
	    }
	});

	_cellList.getCellList().setRound(true);

	final ScrollPanel scrollPanel = new ScrollPanel();
	scrollPanel.setWidget(_cellList);
	scrollPanel.setScrollingEnabledX(false);

	final TabPanel tabPanel = new TabPanel();
	final HistoryTabBarButton termine = new HistoryTabBarButton();
	termine.setText(messages.termine());
	tabPanel.add(termine, scrollPanel);
	final MostRecentTabBarButton neuerTermin = new MostRecentTabBarButton();
	neuerTermin.setText(messages.neuerTermin());

	final FlowPanel container = new FlowPanel();
	{
	    final WidgetList widgetList = new WidgetList();
	    widgetList.setRound(true);

	    // lets put in some widgets
	    this.terminDatum = new MDateBox();
	    terminDatum.setFormat("dd.MM.yyyy");
	    terminDatum.setValue(new Date());
	    widgetList.add(new FormListEntry(messages.terminCreateDatum(), terminDatum));
	    this.kurzbeschreibung = new MTextBox();
	    widgetList.add(new FormListEntry(messages.terminCreateKurzbeschreibung(), kurzbeschreibung));
	    this.heimspiel = new MCheckBox();
	    widgetList.add(new FormListEntry(messages.terminCreateHeimspiel(), heimspiel));
	    this.liga = new MListBox();
	    widgetList.add(new FormListEntry(messages.terminCreateLiga(), liga));
	    container.add(widgetList);

	    this.newTerminButton = new Button(messages.createTermin());
	    container.add(newTerminButton);
	}
	tabPanel.add(neuerTermin, container);
	_layoutPanel.add(tabPanel);

    }

    @Override
    public HasCellSelectedHandler getCellSelectedHandler() {
	return _cellList.getCellList();
    }

    @Override
    public void updateList(final List<ITermin> termine) {
	_cellList.getCellList().render(termine);
    }

    @Override
    public MDateBox getTerminDatum() {
	return terminDatum;
    }

    @Override
    public MTextBox getKurzbeschreibung() {
	return kurzbeschreibung;
    }

    @Override
    public MCheckBox getHeimspiel() {
	return heimspiel;
    }

    @Override
    public MListBox getLiga() {
	return liga;
    }

    @Override
    public Button getNewTerminButton() {
	return newTerminButton;
    }

}
