package com.sksamuel.jqm4gwt;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Stephen K Samuel samspade79@gmail.com 9 Jul 2011 12:57:43
 * 
 *         The {@link JQMContent} is the singleton object that enables
 *         interaction between GWT, JQM and the DOM.
 * 
 */
public class JQMContext {

	private static int	counter	= 1;

	/**
	 * Appends the given {@link JQMPage} to the DOM so that JQueryMobile is
	 * able to manipulate it and render it. This should only be done once per
	 * page, otherwise duplicate HTML would be added to the DOM and this would
	 * result in elements with overlapping IDs.
	 * 
	 */
	static void appendPage(JQMPage page) {
		RootPanel.get().add(page);
		render(page.getId());
	}

	/**
	 * Programatically change the displayed page to the given {@link JQMPage}
	 * instance. This uses the default transition which is Transition.POP
	 */
	public static void changePage(JQMPage page) {
		changePage(page, Transition.POP);
	}

	/**
	 * Change the displayed page to the given {@link JQMPage} instance using
	 * the supplied transition.
	 */
	public static void changePage(JQMPage page, Transition transition) {
		Mobile.changePage("#" + page.getId(), transition, false, true);
	}

	public static int getNextCounter() {
		return counter++;
	}

	/**
	 * Ask JQuery Mobile to "render" the element with the given id.
	 */
	private static native void render(String id) /*-{
		$wnd.$("#" + id).page();
	}-*/;

}
