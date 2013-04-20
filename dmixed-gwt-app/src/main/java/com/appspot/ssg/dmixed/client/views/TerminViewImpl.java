package com.appspot.ssg.dmixed.client.views;

import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MRadioButton;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class TerminViewImpl extends Composite implements TerminView {

    private final LayoutPanel _layoutPanel;
    private final HeaderPanel _headerPanel;
    private final ClientFactory _clientFactory;
    private final WidgetList _teilnehmerList;
    private final WidgetList _mitbrinselList;

    public TerminViewImpl(final ClientFactory clientFactory) {
        _clientFactory = clientFactory;
        _layoutPanel = new LayoutPanel();
        _headerPanel = new HeaderPanel();
        _layoutPanel.add(_headerPanel);
        initWidget(_layoutPanel);
        final HTML teilNehmerHeader = new HTML("Teilnehmer");
        teilNehmerHeader.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
        _layoutPanel.add(teilNehmerHeader);
        _teilnehmerList = new WidgetList();
        _layoutPanel.add(_teilnehmerList);
        final HTML mitbringerHeader = new HTML("Was muss mitgebracht werden?");
        mitbringerHeader.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
        _layoutPanel.add(mitbringerHeader);
        _mitbrinselList = new WidgetList();
        _layoutPanel.add(_mitbrinselList);
    }

    @Override
    public void setText(final String title) {
        _headerPanel.setCenter(title);
    }

    @Override
    public void setTerminBeschreibung(final String terminBeschreibung) {
        // TODO Auto-generated method stub

    }

    @Override
    public void fillTeilnehmer(final List<ITerminTeilnehmer> teilnehmer) {
        _teilnehmerList.clear();
        for (final ITerminTeilnehmer terminTeilnehmer : teilnehmer) {
            final String vorname = terminTeilnehmer.getVorname();
            final String name = terminTeilnehmer.getName();
            final String komplett = vorname + " " + name;
            final boolean teilnahme = terminTeilnehmer.isTeilnahme();
            final MRadioButton androidRadioButton = new MRadioButton(komplett);
            androidRadioButton.setText(komplett);
            androidRadioButton.setValue(teilnahme);
            androidRadioButton.setEnabled(false);
            _teilnehmerList.add(androidRadioButton);
        }
    }

    @Override
    public void fillMitbringsel(final List<ITerminMitbringsel> mitbringsel) {
        _mitbrinselList.clear();
        for (final ITerminMitbringsel terminMitbringsel : mitbringsel) {
            final Long id = terminMitbringsel.getId();
            final String beschreibung = terminMitbringsel.getBeschreibung();
            final ITerminTeilnehmer mitbringer = terminMitbringsel.getMitbringer();
            final MRadioButton androidRadioButton = new MRadioButton(id.toString());
            androidRadioButton.setText(beschreibung);
            final boolean hatMitbringer = mitbringer != null;
            androidRadioButton.setValue(hatMitbringer);
            androidRadioButton.setEnabled(hatMitbringer);
            _mitbrinselList.add(androidRadioButton);
        }
    }

}
