package com.sksamuel.jqm4gwt.toolbar;

import com.google.gwt.user.client.ui.Widget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 4 May 2011 21:21:13
 * 
 *         This class models a JQM Footer element. It can contain an arbitary
 *         number of other widgets.
 * 
 * 
 */
public class JQMFooter extends JQMToolbar {

	/**
	 * Create a new empty footer. Useful for adding buttons or other widgets
	 * later.
	 */
	public JQMFooter() {
		this((String) null);
	}

	/**
	 * Creates a new footer with the given text as a H1 element
	 */
	public JQMFooter(String text) {
		super("footer", "jpm4gwt-footer", text);
	}

	/**
	 * Create a new footer containing the given array of widgets.
	 */
	public JQMFooter(Widget... widgets) {
		this((String) null);
		for (Widget widget : widgets)
			add(widget);
	}

}
