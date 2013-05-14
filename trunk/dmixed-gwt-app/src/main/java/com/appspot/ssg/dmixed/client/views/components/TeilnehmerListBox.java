package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListItem;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.MListBox;

public class TeilnehmerListBox extends MListBox implements IListItem<ETeilnahmeStatus> {

    private final IDMixedMessages messages;
    private final boolean loggedUser;

    public TeilnehmerListBox(final IDMixedMessages messages, final boolean loggedUser) {
	this.messages = messages;
	this.loggedUser = loggedUser;
	final ETeilnahmeStatus[] values = ETeilnahmeStatus.values();
	for (final ETeilnahmeStatus teilnahmeStatus : values) {
	    addItem(getListText(teilnahmeStatus), teilnahmeStatus.name());
	}
    }

    private String getListText(final ETeilnahmeStatus status) {
	switch (status) {
	case NimmtTeil:
	    return this.messages.nimmtTeil();
	case NimmtNichtTeil:
	    return this.messages.nimmtNichtTeil();
	case Vielleicht:
	    return this.messages.vielleicht();
	case NichtEntschieden:
	default:
	    if (loggedUser)
		return this.messages.nichtEntschieden();
	    else
		return "";
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