package com.sksamuel.jqm4gwt.form;

import com.google.gwt.dom.client.Document;
import com.sksamuel.jqm4gwt.panel.JQMComplexPanel;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 Jul 2011 17:39:04
 * 
 *         An implementation of a div container that has data-role set to
 *         fieldcontain. This is convenience class intended to be used by form
 *         elements.
 * 
 */
public class JQMFieldContainer extends JQMComplexPanel {

	protected JQMFieldContainer() {
		super(Document.get().createDivElement(), "fieldcontain", "jqm4gwt-fieldcontain");
	}

}
