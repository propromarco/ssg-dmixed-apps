package com.sksamuel.jqm4gwt.form.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.sksamuel.jqm4gwt.AbstractJQMWidget;
import com.sksamuel.jqm4gwt.DataIcon;
import com.sksamuel.jqm4gwt.HasNative;
import com.sksamuel.jqm4gwt.IconPos;
import com.sksamuel.jqm4gwt.button.HasIcon;
import com.sksamuel.jqm4gwt.form.AbstractJQMFormWidget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 5 May 2011 10:58:58
 * 
 */
public class JQMSelect extends AbstractJQMFormWidget implements HasNative, HasText,
		HasFocusHandlers, HasChangeHandlers, HasValue<String>, JQMFormWidget, HasIcon {

	class Select extends AbstractJQMWidget implements HasNative {

		Select(String id) {
			super(Document.get().createSelectElement(), null, null);
			setAttribute("name", id);
			getElement().setId(id);
		}

		public SelectElement getSelectElement() {
			return getElement().cast();
		}

		@Override
		public boolean isNative() {
			return false == "false".equals(getAttribute("data-native-menu"));
		}

		@Override
		public void setNative(boolean b) {
			setAttribute("data-native-menu", String.valueOf(b));
		}
	}

	private Select		select;

	private LabelElement	label;

	public JQMSelect(String id) {
		this(id, null);
	}

	public JQMSelect(String id, String text) {
		super(id);

		setStyleName("jqm4gwt-select");

		select = new Select(id);

		if (text != null) {
			label = Document.get().createLabelElement();
			label.setAttribute("for", id);
			label.setInnerText(text);
			getElement().appendChild(label);
		}

		getElement().appendChild(select.getElement());
	}

	@Override
	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return null;
	}

	@Override
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		return addDomHandler(handler, ChangeEvent.getType());
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	@Override
	public Label addErrorLabel() {
		return null;
	}

	@Override
	public HandlerRegistration addFocusHandler(FocusHandler handler) {
		return addDomHandler(handler, FocusEvent.getType());
	}

	public void addOption(String value) {
		addOption(value, value);
	}

	public void addOption(String value, String text) {
		OptionElement e = Document.get().createOptionElement();
		e.setText(text);
		if (value != null) // if null, it is the placeholder option
			e.setValue(value);
		getSelectElement().appendChild(e);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return null;
	}

	private int getIndexOf(String value) {
		Element e = getSelectElement().getFirstChildElement();
		int k = 0;
		while (e != null) {
			if (e.getAttribute("value").equals(value)) {
				return k;
			}
			e = e.getNextSiblingElement();
			k++;
		}
		return -1;
	}

	public int getSelectedIndex() {
		return getSelectedIndex(select.getId());
	}

	private native int getSelectedIndex(String id) /*-{
		var select = $wnd.$("select#" + id);
		return select[0].selectedIndex;
	}-*/;

	public String getSelectedValue() {
		return getValue();
	}

	private SelectElement getSelectElement() {
		return select.getSelectElement();
	}

	@Override
	public String getText() {
		return label.getInnerText();
	}

	/**
	 * Returns the currently selected value
	 */
	@Override
	public String getValue() {
		return getValue(getSelectedIndex());
	}

	/**
	 * Returns the value at the given index
	 */
	public String getValue(int index) {
		Element e = getSelectElement().getFirstChildElement();
		int k = 0;
		while (e != null) {
			if (k == index)
				return e.getAttribute("value");
			e = e.getNextSiblingElement();
			k++;
		}
		return null;
	}

	/**
	 * Returns true if the select is set to render in native mode.
	 */
	@Override
	public boolean isNative() {
		return select.isNative();
	}

	public void refresh() {
		refresh(select.getId());
	}

	private native void refresh(String id) /*-{
		var select = $wnd.$("select#" + id);
		select.selectmenu("refresh");
	}-*/;

	/**
	 * Remove the first option that matches the given value
	 */
	public void removeOption(String value) {
		int index = getIndexOf(value);
		if (index >= 0)
			getSelectElement().remove(index);
	}

	/**
	 * Sets the icon used by this button. See {@link DataIcon}.
	 */
	@Override
	public void setIcon(DataIcon icon) {
		if (icon == null)
			getElement().removeAttribute("data-icon");
		else
			getElement().setAttribute("data-icon", icon.getJqmValue());
	}

	/**
	 * Sets the position of the icon. If you desire an icon only button then
	 * set the position to {@link IconPos.NOTEXT}
	 */
	@Override
	public void setIconPos(IconPos pos) {
		if (pos == null)
			getElement().removeAttribute("data-iconpos");
		else
			getElement().setAttribute("data-iconpos", pos.getJqmValue());
	}

	@Override
	public void setNative(boolean b) {
		select.setNative(b);
	}

	public void setPlaceholder(String placeholder) {
		addOption(null, placeholder);
	}

	/**
	 * Change the selection to the option at the given index.
	 */
	public void setSelectedIndex(int index) {
		setSelectedIndex(select.getId(), index);
	}

	private native void setSelectedIndex(String id, int index) /*-{
		$wnd.$("#" + id).attr('selectedIndex', index);
		var select = $wnd.$("select#" + id);
		select.selectedIndex = index;
		select.selectmenu("refresh");
	}-*/;

	@Override
	public void setText(String text) {
		label.setInnerText(text);
	}

	@Override
	public void setValue(String value) {
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
	}

}
