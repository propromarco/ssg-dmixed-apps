package com.sksamuel.jqm4gwt.form.elements;

/**
 * @author Stephen K Samuel samspade79@gmail.com 18 May 2011 04:17:45
 * 
 *         Text element specialised for email
 * 
 */
public class JQMSearch extends JQMText {

	public JQMSearch() {
		this(null);
	}

	public JQMSearch(String id) {
		this(id, null);
	}

	public JQMSearch(String id, String labelText) {
		super(id, labelText);
		setType("search");
	}

}
