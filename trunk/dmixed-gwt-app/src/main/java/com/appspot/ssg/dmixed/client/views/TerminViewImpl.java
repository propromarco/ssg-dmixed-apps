package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.MRadioButton;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class TerminViewImpl extends AbstractDmixedView implements TerminView {

    public class InternalRadioButton extends MRadioButton implements IListItem {

	private final String _text;

	public InternalRadioButton(final String name) {
	    super(name);
	    _text = name;
	}

	@Override
	public void setMitbringer(final String user) {
	    if (user != null) {
		setText(_text + "(" + user + ")");
	    } else {
		setText(_text);
	    }
	}

    }

    private final WidgetList _teilnehmerList, _mitbrinselList;
    private final HTML _beschreibung;
    private final HTML _teilnehmerHeader, _mitbringerHeader;

    public TerminViewImpl(final IDMixedMessages messages) {
	super(messages);
	_beschreibung = new HTML();
	_beschreibung.setStyleName("terminBeschreibung");
	_layoutPanel.add(_beschreibung);
	_teilnehmerHeader = new HTML(messages.teilnehmer());
	_teilnehmerHeader.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
	_layoutPanel.add(_teilnehmerHeader);
	_teilnehmerList = new WidgetList();
	_layoutPanel.add(_teilnehmerList);
	_mitbringerHeader = new HTML(messages.mitbringen());
	_mitbringerHeader.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
	_layoutPanel.add(_mitbringerHeader);
	_mitbrinselList = new WidgetList();
	_layoutPanel.add(_mitbrinselList);
    }

    @Override
    public void setTerminBeschreibung(final String terminBeschreibung) {
	_beschreibung.setHTML(terminBeschreibung);
    }

    @Override
    public IListCreator<ITerminTeilnehmer> fillTeilnehmer() {
	_teilnehmerList.clear();
	return new IListCreator<ITerminTeilnehmer>() {
	    @Override
	    public IListItem create(final ITerminTeilnehmer terminTeilnehmer) {
		final String vorname = terminTeilnehmer.getVorname();
		final String name = terminTeilnehmer.getName();
		final String komplett = vorname + " " + name;
		final boolean teilnahme = terminTeilnehmer.isTeilnahme();
		final InternalRadioButton androidRadioButton = new InternalRadioButton(komplett);
		androidRadioButton.setText(komplett);
		androidRadioButton.setValue(teilnahme);
		androidRadioButton.setEnabled(false);
		_teilnehmerList.add(androidRadioButton);
		return androidRadioButton;
	    }

	    @Override
	    public void onFinish(final boolean hasItems) {
		_teilnehmerHeader.setVisible(hasItems);
	    }
	};
    }

    @Override
    public IListCreator<ITerminMitbringsel> fillMitbringsel() {
	_mitbrinselList.clear();
	return new IListCreator<ITerminMitbringsel>() {
	    @Override
	    public IListItem create(final ITerminMitbringsel terminMitbringsel) {
		final Long id = terminMitbringsel.getId();
		final String beschreibung = terminMitbringsel.getBeschreibung();
		final ITerminTeilnehmer mitbringer = terminMitbringsel.getMitbringer();
		final InternalRadioButton androidRadioButton = new InternalRadioButton(beschreibung);
		androidRadioButton.setText(beschreibung);
		final boolean hatMitbringer = mitbringer != null;
		androidRadioButton.setValue(hatMitbringer);
		androidRadioButton.setEnabled(hatMitbringer);
		androidRadioButton.setMitbringer(hatMitbringer ? mitbringer.getName() : null);
		_mitbrinselList.add(androidRadioButton);
		return androidRadioButton;
	    }

	    @Override
	    public void onFinish(final boolean hasItems) {
		_mitbringerHeader.setVisible(hasItems);
	    }
	};
    }
}
