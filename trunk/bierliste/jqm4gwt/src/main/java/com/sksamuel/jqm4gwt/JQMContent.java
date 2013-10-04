package com.sksamuel.jqm4gwt;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 4 May 2011 23:55:27
 * 
 *         A panel that is used for all the main content widgets. This maps to
 *         the <div data-role="content"> element in the page.
 * 
 */
public class JQMContent extends ComplexPanel {

	JQMContent() {
		setElement(DOM.createDiv());
		getElement().setAttribute("data-role", "content");
	}

	/**
	 * Adds a new child widget to the panel, attaching its Element to the
	 * specified container Element.
	 * 
	 * @param widget
	 *              the child widget to be added
	 * @param container
	 *              the element within which the child will be contained
	 */
	public void add(Widget widget) {
		super.add(widget, getElement());
	}

	public String getTheme() {
		return getElement().getAttribute("data-theme");
	}

	public JQMContent setTheme(String themeName) {
		getElement().setAttribute("data-theme", themeName);
		return this;
	}

}
