package com.appspot.ssg.dmixed.client.views;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.TermineActivity.TermineView;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public class TermineViewImpl extends Composite implements TermineView {

    private final LayoutPanel _layoutPanel;
    private final HeaderPanel _headerPanel;
    private final CellListWithHeader<ITermin> _cellList;

    public TermineViewImpl(final ClientFactory clientFactory) {
        _layoutPanel = new LayoutPanel();
        initWidget(_layoutPanel);
        _headerPanel = new HeaderPanel();
        _headerPanel.setCenter("Termine");
        _layoutPanel.add(_headerPanel);
        _cellList = new CellListWithHeader<ITermin>(new BasicCell<ITermin>() {

            @Override
            public String getDisplayString(final ITermin termin) {
                final Date termineDatum = termin.getTermineDatum();
                final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
                final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
                final String d = formatter.format(termineDatum);
                final String title = terminKurzbeschreibung + " - " + d;
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
        _layoutPanel.add(scrollPanel);
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
