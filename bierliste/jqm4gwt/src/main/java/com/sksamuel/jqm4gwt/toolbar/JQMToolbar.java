package com.sksamuel.jqm4gwt.toolbar;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.JQMWidget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 10 Jul 2011 13:27:36
 * 
 *         Superclass for toolbars - {@link JQMHeader} and {@link JQMFooter}
 * 
 */
public abstract class JQMToolbar extends JQMWidget implements HasText, HasFixedPosition {

	private FlowPanel	flow	= new FlowPanel();

	/**
	 * Creates a new toolbar with a header element for the given text
	 */
	protected JQMToolbar(String dataRole, String styleName, String text) {

		initWidget(flow);

		setDataRole(dataRole);
		setStyleName(styleName);

		if (text != null) {
			Element h1 = Document.get().createHElement(1);
			h1.setInnerText(text);
			getElement().appendChild(h1);
		}
	}

	public void add(Widget w) {
		flow.add(w);
	}

	@Override
	public String getText() {
		// first elem is always the h1
		Element h1 = getElement().getFirstChildElement();
		return h1 == null ? null : h1.getInnerText();
	}

	@Override
	public boolean isFixed() {
		return "fixed".equals(getAttribute("data-position"));
	}

	public void remove(Widget w) {
		flow.remove(w);
	}

	@Override
	public void setFixed(boolean fixed) {
		if (fixed)
			setAttribute("data-position", "fixed");
		else
			removeAttribute("data-position");
	}

	@Override
	public void setText(String text) {
		// first elem is always the h1
		getElement().getFirstChildElement().setInnerText(text);
	}
}
