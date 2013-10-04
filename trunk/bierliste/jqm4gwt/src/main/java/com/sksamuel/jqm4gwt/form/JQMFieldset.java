package com.sksamuel.jqm4gwt.form;

import com.google.gwt.dom.client.Document;
import com.sksamuel.jqm4gwt.panel.JQMControlGroup;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 Jul 2011 22:27:23
 * 
 */
public class JQMFieldset extends JQMControlGroup {

	public JQMFieldset() {
		super(Document.get().createFieldSetElement(), "jqm4gwt-fieldset");
	}

}
