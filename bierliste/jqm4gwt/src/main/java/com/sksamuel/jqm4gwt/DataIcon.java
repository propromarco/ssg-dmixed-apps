package com.sksamuel.jqm4gwt;

/**
 * @author Stephen K Samuel samspade79@gmail.com 9 Jul 2011 14:23:25
 * 
 *         This enum represents all the built in button icon types.
 * 
 */
public enum DataIcon {

	GEAR("gear"), LEFT("arrow-l"), RIGHT("arrow-r"), UP("arrow-u"), DOWN("arrow-d"), DELETE(
			"delete"), PLUS("plus"), MINUS("minus"), CHECK("check"), REFRESH("refresh"), FORWARD(
			"forward"), BACK("back"), GRID("grid"), STAR("star"), ALERT("alert"), INFO("info"), HOME(
			"home"), SEARCH("search");

	private final String	jqmValue;

	private DataIcon(String jqmValue) {
		this.jqmValue = jqmValue;
	}

	/**
	 * Returns the string value that JQM expects
	 */
	public String getJqmValue() {
		return jqmValue;
	}

}
