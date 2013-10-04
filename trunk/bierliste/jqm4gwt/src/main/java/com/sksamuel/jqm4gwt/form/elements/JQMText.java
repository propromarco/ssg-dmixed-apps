package com.sksamuel.jqm4gwt.form.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.sksamuel.jqm4gwt.form.JQMFieldContainer;
import com.sksamuel.jqm4gwt.html.FormLabel;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 May 2011 13:49:09
 * 
 *         An implementation of a standard HTML text input.
 * 
 */
public class JQMText extends JQMFieldContainer implements HasText, HasFocusHandlers, HasClickHandlers,
		HasChangeHandlers, HasValue<String>, JQMFormWidget {

	private final FormLabel	label	= new FormLabel();
	private final TextBox	input	= new TextBox();

	/**
	 * Create a new {@link JQMText} element with an automatically generated id
	 * and no label.
	 */
	public JQMText() {
		this(null);
	}

	/**
	 * Create a new {@link JQMText} element with the given id and with no
	 * label.
	 */
	public JQMText(String id) {
		this(id, null);
	}

	/**
	 * Create a new {@link JQMText} element with the given id and given label.
	 */
	public JQMText(String id, String labelText) {
		if (id == null)
			id = Document.get().createUniqueId();

		setText(labelText);
		label.setFor(id);

		input.getElement().setId(id);
		input.setName(id);

		add(label);
		add(input);

	}

	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return input.addBlurHandler(handler);
	}

	@Override
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		return input.addChangeHandler(handler);
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	@Override
	public Label addErrorLabel() {
		return null;
	}

	@Override
	public HandlerRegistration addFocusHandler(FocusHandler handler) {
		return input.addFocusHandler(handler);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return null;
	}

	@Override
	public String getId() {
		return input.getElement().getId();
	}

	/**
	 * Returns the text of the label
	 */
	@Override
	public String getText() {
		return label == null ? null : label.getText();
	}

	@Override
	public String getValue() {
		return input.getValue();
	}

	/**
	 * Set the text of the label to the given @param text
	 */
	@Override
	public void setText(String text) {
		label.setText(text);
	}

	protected void setType(String type) {
		input.getElement().setAttribute("type", type);
	}

	@Override
	public void setValue(String value) {
		setValue(value, false);
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
		input.setValue(value, fireEvents);
	}
}
