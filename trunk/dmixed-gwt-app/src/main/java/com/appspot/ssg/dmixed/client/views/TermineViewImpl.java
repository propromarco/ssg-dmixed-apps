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
	termine.setText("Termine");
	tabPanel.add(termine, scrollPanel);
	final MostRecentTabBarButton neuerTermin = new MostRecentTabBarButton();
	neuerTermin.setText("neuer Termin");
	tabPanel.add(neuerTermin, createNeuerTerminPanel());
	_layoutPanel.add(tabPanel);
    }

    private FlowPanel createNeuerTerminPanel() {
	final FlowPanel container = new FlowPanel();

	final WidgetList widgetList = new WidgetList();
	widgetList.setRound(true);

	// lets put in some widgets
	final MDateBox w = new MDateBox();
	w.setValue(new Date());
	widgetList.add(new FormListEntry("Datum", w));
	widgetList.add(new FormListEntry("Kurzbeschreibung", new MTextBox()));
	widgetList.add(new FormListEntry("Heimspiel", new MCheckBox()));
	widgetList.add(new FormListEntry("Liga", new MListBox()));
	container.add(widgetList);

	container.add(new Button("weiter"));
	return container;
    }

    @Override
    public HasCellSelectedHandler getCellSelectedHandler() {
	return _cellList.getCellList();
    }

    @Override
    public void updateList(final List<ITermin> termine) {
	_cellList.getCellList().render(termine);
    }

}
