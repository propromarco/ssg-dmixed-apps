package com.sksamuel.jqm4gwt.layout;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.JQMWidget;
import com.sksamuel.jqm4gwt.html.Hn;

/**
 * @author Stephen K Samuel samspade79@gmail.com 10 May 2011 00:04:18
 * 
 *         A {@link JQMCollapsible} is a panel that shows a header and can
 *         reveal content once the header is expanded. This is similar to the
 *         GWT {@link DisclosurePanel}.
 * 
 */
public class JQMCollapsible extends JQMWidget implements HasText {

	/**
	 * The container for the elements of the collapsible
	 */
	private FlowPanel	flow;

	private Hn		header;

	/**
	 * Creates a new collapsible with the given header text and preset to
	 * collapsed.
	 */
	public JQMCollapsible(String text) {
		this(text, true);
	}

	public JQMCollapsible(String text, boolean collapsed) {
		flow = new FlowPanel();
		header = new Hn(3);
		flow.add(header);
		initWidget(flow);

		setDataRole("collapsible");
		setCollapsed(collapsed);
		setText(text);
	}

	/**
	 * Add a widget to the content part of this {@link JQMCollapsible}
	 */
	public void add(Widget widget) {
		flow.add(widget);
	}

	/**
	 * Returns the text on the header element
	 */
	@Override
	public String getText() {
		return header.getText();
	}

	public boolean isCollapsed() {
		return "true".equals(getElement().getAttribute("data-collapsed"));
	}

	public void setCollapsed(boolean collapsed) {
		if (collapsed)
			getElement().setAttribute("data-collapsed", "true");
		else
			getElement().removeAttribute("data-collapsed");
	}

	/**
	 * Sets the text on the header elements
	 */
	@Override
	public void setText(String text) {
		header.setText(text);
	}

}
