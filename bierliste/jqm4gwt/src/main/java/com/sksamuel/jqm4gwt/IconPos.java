package com.sksamuel.jqm4gwt;

/**
 * @author Stephen K Samuel samspade79@gmail.com 12 Jul 2011 18:22:17
 * 
 *         Enum for the position of an in a widget
 * 
 */
public enum IconPos {

	NOTEXT("notext"), BOTTOM("bottom"), TOP("top"), RIGHT("right"), LEFT("left");

	private final String	jqmPos;

	private IconPos(String jqmPos) {
		this.jqmPos = jqmPos;
	}

	/**
	 * Returns the string value that JQM expects
	 */
	public String getJqmValue() {
		return jqmPos;
	}

}
