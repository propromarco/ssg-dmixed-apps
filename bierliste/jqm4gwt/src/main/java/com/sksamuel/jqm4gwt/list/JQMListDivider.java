package com.sksamuel.jqm4gwt.list;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 10 Jul 2011 14:36:20
 * 
 */
public class JQMListDivider extends Widget implements HasText {

	JQMListDivider(String text) {
		setElement(Document.get().createLIElement());
		getElement().setAttribute("data-role", "list-divider");
		getElement().setId(Document.get().createUniqueId());
		setText(text);
	}

	@Override
	public String getText() {
		return getElement().getInnerText();
	}

	@Override
	public void setText(String text) {
		getElement().setInnerText(text);
	}

}
