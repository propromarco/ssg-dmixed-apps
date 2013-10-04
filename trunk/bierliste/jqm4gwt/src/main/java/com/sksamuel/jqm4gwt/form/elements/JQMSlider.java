package com.sksamuel.jqm4gwt.form.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.TextBox;
import com.sksamuel.jqm4gwt.form.JQMFieldContainer;
import com.sksamuel.jqm4gwt.html.FormLabel;

/**
 * @author Stephen K Samuel samspade79@gmail.com 10 May 2011 00:24:06
 * 
 */
public class JQMSlider extends JQMFieldContainer {

	private final FormLabel	label	= new FormLabel();
	private final TextBox	input	= new TextBox();

	/**
	 * Create a new {@link JQMSlider} with the given id and label and default values for range.
	 */
	public JQMSlider(String id, String text) {
		if (id == null)
			id = Document.get().createUniqueId();

		label.setFor(id);
		label.setText(text);

		input.getElement().setId(id);
		input.getElement().setAttribute("type", "range");
		input.getElement().setAttribute("value", "0");
		input.getElement().setAttribute("min", "0");
		input.getElement().setAttribute("max", "100");

		add(label);
		add(input);
	}

	public JQMSlider(String label, String name, int min, int max) {
		this(label, name);
		setMax(max);
		setMin(min);
	}

	public int getMax() {
		return Integer.parseInt(input.getElement().getAttribute("max"));
	}

	public int getMin() {
		return Integer.parseInt(input.getElement().getAttribute("min"));
	}

	public int getValue() {
		return Integer.parseInt(getValue(getId()));
	}

	private native String getValue(String name) /*-{
		return $wnd.$("#" + name).attr("value");
	}-*/;

	private native void refresh(String id, int value) /*-{
		$wnd.$("#" + name).val(value).slider("refresh");
	}-*/;

	public void setMax(int max) {
		input.getElement().setAttribute("max", String.valueOf(max));
	}

	public void setMin(int min) {
		input.getElement().setAttribute("min", String.valueOf(min));
	}

	public void setValue(int value) {
		getValue(input.getElement().getId());
		input.getElement().setAttribute("value", String.valueOf(value));
		refresh(getId(), value);
	}
}
