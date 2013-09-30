package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListItem;
import com.google.gwt.user.client.ui.RadioButton;

public class MitbringRadioButton extends RadioButton implements IListItem<Boolean> {

    private final String _text;

    public MitbringRadioButton(final String name) {
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