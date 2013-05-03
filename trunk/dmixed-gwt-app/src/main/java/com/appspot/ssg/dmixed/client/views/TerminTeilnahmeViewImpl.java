package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TerminTeilnahmeActivity.TerminView;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
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
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class TerminTeilnahmeViewImpl extends AbstractDmixedView implements TerminView {

    public class InternalListBox extends MListBox implements IListItem {

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

    private final WidgetList _teilnehmerList;
    private final HTML _teilnehmerHeader;

    public TerminTeilnahmeViewImpl(final IDMixedMessages messages) {
	super(messages);
	_teilnehmerHeader = new HTML(messages.teilnehmer());
	_teilnehmerHeader.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
	_layoutPanel.add(_teilnehmerHeader);

	_teilnehmerList = new WidgetList();
	final ScrollPanel teilnehmerScrollPanel = new ScrollPanel();
	teilnehmerScrollPanel.setWidget(_teilnehmerList);
	teilnehmerScrollPanel.setScrollingEnabledX(false);
	_layoutPanel.add(teilnehmerScrollPanel);

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

}
