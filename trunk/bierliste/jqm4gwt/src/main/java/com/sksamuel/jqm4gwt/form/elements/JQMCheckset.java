package com.sksamuel.jqm4gwt.form.elements;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.sksamuel.jqm4gwt.button.HasOrientation;
import com.sksamuel.jqm4gwt.form.JQMFieldContainer;
import com.sksamuel.jqm4gwt.form.JQMFieldset;
import com.sksamuel.jqm4gwt.html.FormLabel;
import com.sksamuel.jqm4gwt.html.Legend;

/**
 * @author Stephen K Samuel samspade79@gmail.com 24 May 2011 08:17:31
 * 
 *         A widget that is composed of 1 or more checkboxes. In JQuery Button
 *         all check boxes are contained in a fieldset element and this
 *         {@link JQMCheckbox} models that. The child checkboxes are grouped
 *         together and can be set to be vertical or horizontal.
 * 
 */
public class JQMCheckset extends JQMFieldContainer implements HasText, HasSelectionHandlers<String>, HasOrientation,
		JQMFormWidget {

	private JQMFieldset	fieldset	= new JQMFieldset();
	private Legend		legend	= new Legend();
	private List<TextBox>	checks	= new ArrayList();

	/**
	 * Creates a new {@link JQMCheckset} with the legend set to the given
	 * text.
	 */
	public JQMCheckset(String text) {
		setText(text);
		fieldset.add(legend);
		add(fieldset);
	}

	/**
	 * no-op implementation required for {@link JQMFormWidget}
	 */
	@Override
	public HandlerRegistration addBlurHandler(final BlurHandler handler) {
		for (TextBox check : checks) {
			check.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					handler.onBlur(null);
				}
			});
		}
		return null;
	}

	/**
	 * Add a new check option to the checkset.
	 */
	public JQMCheckbox addCheck(String id, String text) {

		TextBox input = new TextBox();
		input.setName(id);
		input.getElement().setId(id);
		input.getElement().setAttribute("type", "checkbox");
		checks.add(input);

		FormLabel label = new FormLabel();
		label.setFor(id);
		label.setText(text);

		fieldset.add(input);
		fieldset.add(label);

		return new JQMCheckbox(input.getElement(), label);
	}

	@Override
	public Label addErrorLabel() {
		return null;
	}

	@Override
	public HandlerRegistration addSelectionHandler(SelectionHandler<String> handler) {
		return null;
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return null;
	}

	/**
	 * Returns the value of the legend text
	 */
	@Override
	public String getText() {
		return legend.getText();
	}

	/**
	 * Returns the first value of any checkbox that is checked
	 */
	@Override
	public String getValue() {
		return getValue(fieldset.getElement().getFirstChildElement());
	}

	private String getValue(Element element) {
		while (element != null) {
			if ("label".equalsIgnoreCase(element.getTagName()) && element.getAttribute("class") != null
					&& element.getAttribute("class").contains("ui-btn-active"))
				return element.getAttribute("for");
			String value = getValue(element.getFirstChildElement());
			if (value != null)
				return value;
			element = element.getNextSiblingElement();
		}
		return null;
	}

	@Override
	public boolean isHorizontal() {
		return fieldset.isHorizontal();
	}

	@Override
	public boolean isVertical() {
		return fieldset.isVertical();
	}

	public void removeCheck(String id, String label) {
		// TODO traverse all elements removing anything that has a "for" for
		// this id or actually has this id
	}

	@Override
	public void setHorizontal() {
		fieldset.setHorizontal();
	}

	/**
	 * Sets the value of the legend text.
	 */
	@Override
	public void setText(String text) {
		legend.setText(text);
	}

	@Override
	public void setValue(String value) {
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
	}

	@Override
	public void setVertical() {
		fieldset.setVertical();
	}

}
