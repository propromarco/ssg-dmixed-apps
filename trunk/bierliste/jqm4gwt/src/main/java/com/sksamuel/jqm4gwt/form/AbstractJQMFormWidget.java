package com.sksamuel.jqm4gwt.form;

import com.google.gwt.dom.client.Document;
import com.sksamuel.jqm4gwt.AbstractJQMWidget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 10 May 2011 00:23:59
 * 
 */
@Deprecated
public abstract class AbstractJQMFormWidget extends AbstractJQMWidget {

	protected AbstractJQMFormWidget(String id) {
		super(Document.get().createDivElement(), "fieldcontrol", "jqm4gwt-field");

		if (id == null)
			throw new RuntimeException("ID cannot be null");
		if (id.contains(" "))
			throw new RuntimeException("ID cannot contain space");

		setId(id + "-fieldcontain");
	}
}
