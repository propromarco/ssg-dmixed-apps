package com.sksamuel.jqm4gwt.form.elements;

/**
 * @author Stephen K Samuel samspade79@gmail.com 18 May 2011 04:17:45
 * 
 *         Text element specialised for email
 * 
 */
public class JQMEmail extends JQMText {

	public JQMEmail() {
		this(null);
	}

	public JQMEmail(String id) {
		this(id, null);
	}

	public JQMEmail(String id, String labelText) {
		super(id, labelText);
		setType("email");
	}

}
