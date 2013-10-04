package com.sksamuel.jqm4gwt;

/**
 * @author Stephen K Samuel samspade79@gmail.com 9 May 2011 23:41:05
 * 
 *         Enum representing the different transitions methods available in JQM.
 * 
 */
public enum Transition {

	POP("pop"), SLIDE_UP("slideup"), SLIDE_DOWN("slidedown"), FLIP("flip"), FADE("fade"), SLIDE(
			"slide");

	private final String	jqmValue;

	private Transition(String jqmValue) {
		this.jqmValue = jqmValue;
	}

	/**
	 * Returns the string value that JQM expects
	 */
	public String getJQMValue() {
		return jqmValue;
	}

}
