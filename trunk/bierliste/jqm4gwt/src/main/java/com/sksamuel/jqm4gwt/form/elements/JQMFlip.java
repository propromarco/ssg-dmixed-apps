package com.sksamuel.jqm4gwt.form.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;
import com.sksamuel.jqm4gwt.form.JQMFieldContainer;
import com.sksamuel.jqm4gwt.html.FormLabel;

/**
 * @author Stephen K Samuel samspade79@gmail.com 18 May 2011 04:21:09
 * 
 *         Implementation of a JQuery Model Flip element. This is like a two
 *         element {@link JQMRadioset} that is rendered like a "toggle" on an
 *         iphone.
 * 
 */
public class JQMFlip extends JQMFieldContainer implements HasText, HasValue<String> {

	private final FormLabel	label		= new FormLabel();
	private final ListBox	select	= new ListBox();

	/**
	 * Creates a new flip widget with the legend text set to @param text, and
	 * sets the values of the two options to @param value1 and @param value2
	 */
	public JQMFlip(String id, String text, String value1, String value2) {
		if (id == null)
			id = Document.get().createUniqueId();

		label.setFor(id);
		setText(text);

		select.setName(id);
		select.getElement().setId(id);
		select.getElement().setAttribute("data-role", "slider");
		select.addItem(value1);
		select.addItem(value2);

		add(label);
		add(select);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return null;
	}

	/**
	 * Returns the value of the legend text.
	 */
	@Override
	public String getText() {
		return label.getText();
	}

	/**
	 * Returns the currently selected value.
	 */
	@Override
	public String getValue() {
		throw new UnsupportedOperationException("todo");
	}

	public void refresh() {
	}

	/**
	 * Sets the value of the legend text.
	 */
	@Override
	public void setText(String text) {
		label.setText(text);
	}

	/**
	 * Sets the currently selected value
	 */
	@Override
	public void setValue(String value) {
	}

	/**
	 * Sets the currently selected value
	 */
	@Override
	public void setValue(String value, boolean fireEvents) {
	}
}
