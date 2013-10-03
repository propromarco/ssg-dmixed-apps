package de.clubbiertest.client.mvp;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.web.bindery.event.shared.HandlerRegistration;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.mvp.ClubbiertestDataHandler.Sidebars;

public class SidebarHeader extends FlowPanel {

	private Anchor link;
	private Sidebars type;

	public SidebarHeader(ClubbiertestDataHandler dataHandler, String text, Sidebars type) {
		this.type = type;
		ClubbiertestCss css = dataHandler.getCss();
		setStyleName(css.header());
		link = new Anchor();
		add(link);
		Element textSpan = DOM.createSpan();
		link.getElement().appendChild(textSpan);
		textSpan.setInnerHTML(text);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return link.addClickHandler(handler);
	}

}
