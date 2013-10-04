package com.sksamuel.jqm4gwt.panel;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.HasId;
import com.sksamuel.jqm4gwt.JQMContext;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 Jul 2011 22:13:36
 * 
 *         Superclass of all JQM widgets that are composed of multiple other
 *         "standard" widgets.
 * 
 */
public class JQMComplexPanel extends ComplexPanel implements HasId {

	protected JQMComplexPanel(Element element, String dataRole, String styleName) {
		setElement(element);
		if (styleName != null)
			setStyleName(styleName);
		if (dataRole != null)
			setDataRole(dataRole);
		setId();
	}

	@Override
	public void add(Widget w) {
		add(w, getElement());
	}

	@Override
	public void clear() {
		Node child = getElement().getFirstChild();
		while (child != null) {
			getElement().removeChild(child);
			child = getElement().getFirstChild();
		}
	}

	protected String getAttribute(String name) {
		return getElement().getAttribute(name);
	}

	@Override
	public String getId() {
		return getElement().getId();
	}

	public void hide() {
		hide(getId());
	}

	private native void hide(String id) /*-{
		$wnd.$("#" + id).hide();
	}-*/;

	public void insert(IsWidget w, int beforeIndex) {
		insert(asWidgetOrNull(w), beforeIndex);
	}

	public void insert(Widget w, int beforeIndex) {
		insert(w, getElement(), beforeIndex, true);
	}

	protected void removeAttribute(String name) {
		getElement().removeAttribute(name);
	}

	protected void setAttribute(String name, String value) {
		getElement().setAttribute(name, value);
	}

	/**
	 * Sets the data-role attribute to the given value.
	 */
	protected void setDataRole(String role) {
		setAttribute("data-role", role);
	}

	/**
	 * Assign an automatically generated id
	 */
	protected void setId() {
		setId("id" + JQMContext.getNextCounter());
	}

	@Override
	public final void setId(String id) {
		getElement().setId(id);
	}

	public void show() {
		show(getAttribute("id"));
	}

	private native void show(String id) /*-{
		$wnd.$("#" + id).show();
	}-*/;
}
