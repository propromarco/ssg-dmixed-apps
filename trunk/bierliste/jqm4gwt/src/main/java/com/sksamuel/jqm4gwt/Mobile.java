package com.sksamuel.jqm4gwt;

/**
 * @author Stephen K Samuel samspade79@gmail.com 13 May 2011 11:14:24
 * 
 *         Utility methods. The static methods in this class map through to the
 *         equivilent JQM method in $.mobile
 * 
 */
public class Mobile {

	private static final String	DIALOG_DEFAULT	= "Loading";

	/**
	 * Invokes the $.mobile.changePage method
	 */
	private static native void changePage(String url, String t, boolean r, boolean ch) /*-{
		$wnd.$.mobile.changePage(url);
	}-*/;

	/**
	 * Invokes the $.mobile.changePage method
	 */
	static void changePage(final String url, final Transition t, final boolean reverse, final boolean changeHash) {
		changePage(url, t.getJQMValue(), reverse, changeHash);
	}

	/**
	 * Hide the page loading dialog and set the global loading message back to
	 * the default "Loading"
	 */
	public static void hideLoadingDialog() {
		hideLoadingDialog(DIALOG_DEFAULT);
	}

	/**
	 * Hide the page loading dialog and set the global loading message back to
	 * the default "Loading"
	 */
	private static native void hideLoadingDialog(String s) /*-{
		$wnd.$.mobile.hidePageLoadingMsg();
		$wnd.$.mobile.loadingMessage = s;
	}-*/;

	/**
	 * Ask JQuery Mobile to "render" the element with the given id.
	 */
	static native void render(String id) /*-{
		$wnd.$("#" + id).page();
	}-*/;

	/**
	 * 
	 */
	public static native void showLoadingDialog(String msg) /*-{
		$wnd.$.mobile.loadingMessage = msg;
		$wnd.$.mobile.showPageLoadingMsg();
	}-*/;
}
