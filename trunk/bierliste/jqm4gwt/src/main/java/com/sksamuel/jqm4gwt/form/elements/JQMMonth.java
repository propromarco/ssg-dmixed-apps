package com.sksamuel.jqm4gwt.form.elements;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 Jul 2011 16:42:27
 * 
 *         A convenience implementation of a select input that contains the 12
 *         months of the Gregorian calender.
 */
public class JQMMonth extends JQMSelect {

	public JQMMonth(String id) {
		this(id, null);
	}

	public JQMMonth(String id, String text) {
		super(id, text);

		addOption("01", "January");
		addOption("02", "February");
		addOption("03", "March");
		addOption("04", "April");
		addOption("05", "May");
		addOption("06", "June");
		addOption("07", "July");
		addOption("08", "August");
		addOption("09", "September");
		addOption("10", "October");
		addOption("11", "November");
		addOption("12", "December");

	}
}
