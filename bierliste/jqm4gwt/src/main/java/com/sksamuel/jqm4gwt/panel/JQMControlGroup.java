package com.sksamuel.jqm4gwt.panel;

import com.google.gwt.dom.client.Element;
import com.sksamuel.jqm4gwt.button.HasOrientation;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 Jul 2011 22:09:41
 * 
 */
public class JQMControlGroup extends JQMComplexPanel implements HasOrientation {

	protected JQMControlGroup(Element element, String styleName) {
		super(element, "controlgroup", styleName);
	}

	@Override
	public boolean isHorizontal() {
		return "true".equals(getAttribute("data-type"));
	}

	public boolean isInline() {
		return "true".equals(getElement().getAttribute("data-inline"));
	}

	@Override
	public boolean isVertical() {
		return !isHorizontal();
	}

	@Override
	public void setHorizontal() {
		setAttribute("data-type", "horizontal");
	}

	@Override
	public void setVertical() {
		removeAttribute("data-type");
	}
}
