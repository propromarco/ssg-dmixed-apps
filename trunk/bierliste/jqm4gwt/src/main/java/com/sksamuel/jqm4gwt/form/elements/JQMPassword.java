package com.sksamuel.jqm4gwt.form.elements;

/**
 * @author Stephen K Samuel samspade79@gmail.com 18 May 2011 04:14:05
 * 
 *         An implementation of a standard HTML password input.
 * 
 */
public class JQMPassword extends JQMText {

	public JQMPassword() {
		this(null);
	}

	public JQMPassword(String id) {
		this(id, null);
	}

	public JQMPassword(String id, String labelText) {
		super(id, labelText);
		setType("password");
	}
}
