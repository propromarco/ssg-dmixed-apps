package com.sksamuel.jqm4gwt.form.elements;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.button.HasOrientation;
import com.sksamuel.jqm4gwt.form.JQMFieldContainer;
import com.sksamuel.jqm4gwt.form.JQMFieldset;
import com.sksamuel.jqm4gwt.html.FormLabel;
import com.sksamuel.jqm4gwt.html.Legend;

/**
 * @author Stephen K Samuel samspade79@gmail.com 24 May 2011 08:17:31
 * 
 *         A Collection of radio buttons
 * 
 */
public class JQMRadioset extends JQMFieldContainer implements HasText,
		HasSelectionHandlers<String>, HasOrientation, HasValue<String>, JQMFormWidget {

	private JQMFieldset	fieldset	= new JQMFieldset();
	private Legend		legend	= new Legend();
	private List<TextBox>	radios	= new ArrayList();

	public JQMRadioset(String id, String text) {
		legend.setText(text);
		fieldset.add(legend);
		add(fieldset);
	}

	/**
	 * no-op implementation required for {@link JQMFormWidget}
	 */
	@Override
	public HandlerRegistration addBlurHandler(final BlurHandler handler) {
		for (TextBox radio : radios) {
			radio.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					handler.onBlur(null);
				}
			});
		}
		return null;
	}

	@Override
	public Label addErrorLabel() {
		return null;
	}

	public void addRadio(String value, String text) {

		String id = Document.get().createUniqueId();

		TextBox input = new TextBox();
		input.setName(getId());
		input.setValue(value);
		input.getElement().setId(id);
		input.getElement().setAttribute("type", "radio");
		radios.add(input);

		FormLabel label = new FormLabel();
		label.setFor(id);
		label.setText(text);

		fieldset.add(input);
		fieldset.add(label);
	}

	@Override
	public HandlerRegistration addSelectionHandler(SelectionHandler<String> handler) {
		return null;
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return null;
	}

	@Override
	public String getText() {
		return legend.getText();
	}

	/**
	 * Returns the value of the currently selected radio button
	 */
	@Override
	public String getValue() {
		for (int k = 0; k < fieldset.getWidgetCount(); k++) {
			Widget widget = fieldset.getWidget(k);
			Element element = widget.getElement();
			if (element.getAttribute("class") != null
					&& element.getAttribute("class").contains("ui-btn-active")) {
				return getValueForId(element.getAttribute("for"));
			}
		}
		return null;
	}

	/**
	 * 
	 */
	private String getValueForId(String id) {
		for (int k = 0; k < fieldset.getWidgetCount(); k++) {
			Widget widget = fieldset.getWidget(k);
			if (id.equals(widget.getElement().getAttribute("id")))
				return widget.getElement().getAttribute("value");
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

	public void removeRadio(String id, String label) {
		// TODO traverse all elements removing anything that has a "for" for
		// this id or actually has this id
	}

	@Override
	public void setHorizontal() {
		fieldset.setHorizontal();
	}

	public void setSelected(String string) {
		setValue(string);
	}

	@Override
	public void setText(String text) {
		legend.setText(text);
	}

	@Override
	public void setValue(String value) {
		setValue(value, false);
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
		Element element = getElement().getFirstChildElement();
		while (element != null) {
			if (value.equals(element.getId())) {
				element.setAttribute("checked", "true");
				element.setAttribute("selected", "true");
			} else {
				element.removeAttribute("selected");
				element.removeAttribute("checked");
			}
			element = element.getNextSiblingElement();
		}
	}

	@Override
	public void setVertical() {
		fieldset.setVertical();
	}
}
