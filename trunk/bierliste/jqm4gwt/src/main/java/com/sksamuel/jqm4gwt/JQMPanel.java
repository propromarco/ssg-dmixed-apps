package com.sksamuel.jqm4gwt;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 12 May 2011 23:20:30
 * 
 *         A JQM Panel is simply a container for other JQM widgets
 * 
 */
public class JQMPanel extends ComplexPanel {

	public JQMPanel() {
		this("id" + JQMContext.getNextCounter());
	}

	public JQMPanel(String id) {
		setElement(DOM.createDiv());
		getElement().setId(id);
	}

	/**
	 * Adds a new child widget to the panel, attaching its Element to the specified container
	 * Element.
	 * 
	 * @param child
	 *              the child widget to be added
	 * @param container
	 *              the element within which the child will be contained
	 */
	public void add(Widget child) {
		if (child == null)
			throw new IllegalArgumentException("child cannot be null");
		super.add(child, getElement());
	}

	public void hide() {
		hide(getElement().getId());
	}

	private native void hide(String id) /*-{
		$wnd.$("#" + id).hide();
	}-*/;

	public void show() {
		show(getElement().getId());
	}

	private native void show(String id) /*-{
		$wnd.$("#" + id).show();
	}-*/;
}
