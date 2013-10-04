package com.sksamuel.jqm4gwt.button;

import com.google.gwt.dom.client.Document;
import com.sksamuel.jqm4gwt.panel.JQMControlGroup;

/**
 * @author Stephen K Samuel samspade79@gmail.com 5 May 2011 18:09:41
 * 
 *         Wraps a collection of {@link JQMButton} instances together
 * 
 */
public class JQMButtonGroup extends JQMControlGroup {

	public JQMButtonGroup() {
		super(Document.get().createDivElement(), "jqm4gwt-buttongroup");
	}

	public void setInline(boolean inline) {
		if (inline)
			getElement().setAttribute("data-inline", "true");
		else
			getElement().removeAttribute("data-inline");
	}

}
