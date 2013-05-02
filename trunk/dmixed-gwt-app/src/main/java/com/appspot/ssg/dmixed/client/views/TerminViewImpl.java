package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MListBox;
import com.googlecode.mgwt.ui.client.widget.MRadioButton;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class TerminViewImpl extends AbstractDmixedView implements TerminView {

    public class InternalRadioButton extends MRadioButton implements IListItem<Boolean> {

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

    public class InternalListBox extends MListBox implements IListItem<ETeilnahmeStatus> {

	public InternalListBox() {
	    final ETeilnahmeStatus[] values = ETeilnahmeStatus.values();
	    for (final ETeilnahmeStatus teilnahmeStatus : values) {
		addItem(getListText(teilnahmeStatus), teilnahmeStatus.name());
	    }
	}

	private String getListText(final ETeilnahmeStatus status) {
	    switch (status) {
	    case NimmtTeil:
		return _messages.nimmtTeil();
	    case NimmtNichtTeil:
		return _messages.nimmtNichtTeil();
	    case Vielleicht:
		return _messages.vielleicht();
	    case NichtEntschieden:
	    default:
		return _messages.nichtEntschieden();
	    }
	}

	@Override
	public ETeilnahmeStatus getValue() {
	    final int selectedIndex = getSelectedIndex();
	    final String value = getValue(selectedIndex);
	    return ETeilnahmeStatus.valueOf(value);
	}

	@Override
	public void setValue(final ETeilnahmeStatus value) {
	    final int index = value.ordinal();
	    setSelectedIndex(index);
	}

	@Override
	public void setValue(final ETeilnahmeStatus value, final boolean fireEvents) {
	    // TODO Auto-generated method stub

	}

	@Override
	public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<ETeilnahmeStatus> handler) {
	    return addChangeHandler(new ChangeHandler() {

		@Override
		public void onChange(final ChangeEvent event) {
		    final ValueChangeEvent<ETeilnahmeStatus> evt = new ValueChangeEvent<ETeilnahmeStatus>(getValue()) {
		    };
		    handler.onValueChange(evt);
		}
	    });
	}

	@Override
	public HandlerRegistration addTapHandler(final TapHandler handler) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public void setMitbringer(final String string) {
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
	final ScrollPanel scrollPanel = new ScrollPanel();
	scrollPanel.setWidget(_teilnehmerList);
	scrollPanel.setScrollingEnabledX(false);
	_layoutPanel.add(scrollPanel);

	_mitbringerHeader = new HTML(messages.mitbringen());
	_mitbringerHeader.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
	_layoutPanel.add(_mitbringerHeader);

	_mitbrinselList = new WidgetList();
	final ScrollPanel scrollPanel2 = new ScrollPanel();
	scrollPanel2.setWidget(_mitbrinselList);
	scrollPanel2.setScrollingEnabledX(false);
	_layoutPanel.add(scrollPanel2);
    }

    @Override
    public void setTerminBeschreibung(final String terminBeschreibung) {
	_beschreibung.setHTML(terminBeschreibung);
    }

    @Override
    public IListCreator<ITerminTeilnehmer, ETeilnahmeStatus> fillTeilnehmer() {
	_teilnehmerList.clear();
	return new IListCreator<ITerminTeilnehmer, ETeilnahmeStatus>() {
	    @Override
	    public IListItem<ETeilnahmeStatus> create(final ITerminTeilnehmer terminTeilnehmer) {
		final String vorname = terminTeilnehmer.getVorname();
		final String name = terminTeilnehmer.getName();
		final String komplett = vorname + " " + name;
		final ETeilnahmeStatus teilnahme = terminTeilnehmer.getTeilnahme();
		final InternalListBox androidRadioButton = new InternalListBox();
		androidRadioButton.setValue(teilnahme);
		final FormListEntry entry = new FormListEntry(komplett, androidRadioButton);
		_teilnehmerList.add(entry);
		return androidRadioButton;
	    }

	    @Override
	    public void onFinish(final boolean hasItems) {
		_teilnehmerHeader.setVisible(hasItems);
	    }
	};
    }

    @Override
    public IListCreator<ITerminMitbringsel, Boolean> fillMitbringsel() {
	_mitbrinselList.clear();
	return new IListCreator<ITerminMitbringsel, Boolean>() {
	    @Override
	    public IListItem<Boolean> create(final ITerminMitbringsel terminMitbringsel) {
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
