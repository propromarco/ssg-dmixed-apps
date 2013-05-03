package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.ui.client.widget.Button;

public class TerminViewImpl extends AbstractDmixedView implements TerminView {

    public class InternalButton extends Button implements Navigate {

	public InternalButton(final String text) {
	    super(text);
	}

    }

    private final HTML _beschreibung;
    private final InternalButton _mitkommenButton;
    private final InternalButton _mitbringenButton;

    public TerminViewImpl(final IDMixedMessages messages) {
	super(messages);
	_beschreibung = new HTML();
	_beschreibung.setStyleName("terminBeschreibung");
	_layoutPanel.add(_beschreibung);
	final String mitkommen = messages.mitkommen();
	_mitkommenButton = new InternalButton(mitkommen);
	_layoutPanel.add(_mitkommenButton);
	final String mitbringen = messages.mitbringen();
	_mitbringenButton = new InternalButton(mitbringen);
	_layoutPanel.add(_mitbringenButton);
    }

    @Override
    public void setTerminBeschreibung(final String terminBeschreibung) {
	_beschreibung.setHTML(terminBeschreibung);
    }

    @Override
    public Navigate getMitkommen() {
	return _mitkommenButton;
    }

    @Override
    public Navigate getMitbringen() {
	return _mitbringenButton;
    }

}
