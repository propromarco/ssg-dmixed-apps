package com.sksamuel.jqm4gwt;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 Jul 2011 17:02:40
 * 
 *         An extension of the standard GWT {@link Widget} that adds
 *         functionality common to all JQM elements, as well as convenience
 *         methods used by subclasses.
 * 
 *         The {@link JQMWidget} is an extension of composite because
 *         {@link JQMWidget}s do not typically add new functionality (in terms
 *         of new elements), they are mostly compositions of existing HTML
 *         elements.
 * 
 *         This abstract superclass does not define the nature of the
 *         composition in use. Implementating subclasses must decide how to
 *         compose and thus call initWidget() themselves.
 * 
 */
public abstract class JQMWidget extends Composite implements HasTheme, HasId {

	protected JQMWidget() {
	}

	/**
	 * Returns the value of the attribute with the given name
	 */
	protected String getAttribute(String name) {
		return getElement().getAttribute(name);
	}

	/**
	 * Returns the ID set on the main element
	 */
	@Override
	public String getId() {
		return getElement().getId();
	}

	@Override
	public String getTheme() {
		return getAttribute("data-theme");
	}

	/**
	 * Removes the attribute with the given name
	 */
	protected void removeAttribute(String name) {
		getElement().removeAttribute(name);
	}

	/**
	 * Sets the value of the attribute with the given name to the given value.
	 * 
	 */
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

	@Override
	public JQMWidget setTheme(String themeName) {
		setAttribute("data-theme", themeName);
		return this;
	}

}
