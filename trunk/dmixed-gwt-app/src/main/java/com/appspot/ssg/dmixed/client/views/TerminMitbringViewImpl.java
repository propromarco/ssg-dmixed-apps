package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TerminMitbringActivity.TerminView;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.MRadioButton;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class TerminMitbringViewImpl extends AbstractDmixedView implements TerminView {

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

    private final WidgetList _mitbrinselList;
    private final HTML _mitbringerHeader;

    public TerminMitbringViewImpl(final IDMixedMessages messages) {
	super(messages);

	_mitbringerHeader = new HTML(messages.mitbringen());
	_mitbringerHeader.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
	_layoutPanel.add(_mitbringerHeader);

	_mitbrinselList = new WidgetList();
	final ScrollPanel mitbringselScrollPanel = new ScrollPanel();
	mitbringselScrollPanel.setWidget(_mitbrinselList);
	mitbringselScrollPanel.setScrollingEnabledX(false);
	_layoutPanel.add(mitbringselScrollPanel);
    }

    @Override
    public IListCreator<ITerminMitbringsel> fillMitbringsel() {
	_mitbrinselList.clear();
	return new IListCreator<ITerminMitbringsel>() {
	    @Override
	    public IListItem create(final ITerminMitbringsel terminMitbringsel) {
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
