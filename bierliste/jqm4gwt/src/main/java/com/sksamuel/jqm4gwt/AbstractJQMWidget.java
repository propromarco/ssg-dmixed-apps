package com.sksamuel.jqm4gwt;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 5 May 2011 10:59:48
 * 
 */
@Deprecated
public abstract class AbstractJQMWidget extends Widget {

	/**
	 * Creates a new widget which used the supplied dom element. The given
	 * stylename is applied.
	 */
	protected AbstractJQMWidget(Element element, String dataRole, String styleName) {
		element.setId("id" + JQMContext.getNextCounter());
		setElement(element);
		if (styleName != null)
			setStyleName(styleName);
		if (dataRole != null)
			setDataRole(dataRole);

	}

	protected String getAttribute(String name) {
		return getElement().getAttribute(name);
	}

	public String getId() {
		return getElement().getId();
	}

	public String getTheme() {
		return getElement().getAttribute("data-theme");
	}

	public void hide() {
		hide(getId());
	}

	private native void hide(String id) /*-{
		$wnd.$("#" + id).hide();
	}-*/;

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

	public final void setId(String id) {
		getElement().setId(id);
	}

	public AbstractJQMWidget setTheme(String themeName) {
		getElement().setAttribute("data-theme", themeName);
		return this;
	}

	public void show() {
		show(getAttribute("id"));
	}

	private native void show(String id) /*-{
		$wnd.$("#" + id).show();
	}-*/;

}
