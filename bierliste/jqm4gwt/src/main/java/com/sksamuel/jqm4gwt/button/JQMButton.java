package com.sksamuel.jqm4gwt.button;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasText;
import com.sksamuel.jqm4gwt.DataIcon;
import com.sksamuel.jqm4gwt.HasTransition;
import com.sksamuel.jqm4gwt.IconPos;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.JQMWidget;
import com.sksamuel.jqm4gwt.Transition;

/**
 * @author Stephen K Samuel samspade79@gmail.com 5 May 2011 14:02:24
 * 
 *         An implementation of a Jquery mobile button
 * 
 */
public class JQMButton extends JQMWidget implements HasText, HasRel, HasTransition, HasClickHandlers, HasInline,
		HasIcon {

	private final Anchor	a;

	/**
	 * Create a {@link JQMButton} that does not link to anything.
	 */
	public JQMButton(String text) {

		a = new Anchor(text);
		initWidget(a);

		setStyleName("jqm4gwt-button");
		setDataRole("button");
	}

	/**
	 * Convenience constructor that creates a button that shows the given
	 * {@link JQMPage} when clicked. Note that the page param is an already
	 * instantiated page and thus will be immediately inserted into the DOM.
	 * Do not use this constructor when you want to lazily add the page.
	 */
	public JQMButton(String text, final JQMPage page) {
		this(text, page, Transition.POP);
	}

	/**
	 * Convenience constructor that creates a button that shows the given
	 * {@link JQMPage} when clicked. Note that the page param is an already
	 * instantiated page and thus will be immediately inserted into the DOM.
	 * Do not use this constructor when you want to lazily add the page.
	 */
	public JQMButton(String text, final JQMPage page, final Transition t) {
		this(text, "#" + page.getId());
		setTransition(t);
	}

	/**
	 * Create a JQMButton that links to an external page specified by url.
	 */
	public JQMButton(String text, String url) {
		this(text);
		setAttribute("href", url);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	@Override
	public String getRel() {
		return getElement().getAttribute("rel");
	}

	@Override
	public String getText() {
		String innerText = getElement().getInnerText();
		return innerText;
	}

	public Transition getTransition() {
		String attr = getElement().getAttribute("data-transition");
		if (attr == null)
			return null;
		return Transition.valueOf(attr);
	}

	/**
	 * Returns true if this button is set to load the linked page as a dialog
	 * page
	 */
	public boolean isDialog() {
		return "true".equals(getAttribute("data-rel"));
	}

	@Override
	public boolean isInline() {
		return "true".equals(getAttribute("data-line"));
	}

	/**
	 * Sets this buttom to be a back button. This will override any URL set on
	 * the button.
	 */
	public void setBack(boolean back) {
		if (back)
			getElement().setAttribute("data-rel", "back");
		else
			getElement().removeAttribute("data-rel");
	}

	/**
	 * Sets this buttom to be a dialog button. This changes the look and feel
	 * of the page that is loaded as a consequence of clicking on this button.
	 */
	public void setDialog(boolean dialog) {
		if (dialog)
			setAttribute("data-rel", "dialog");
		else
			removeAttribute("data-rel");
	}

	/**
	 * Short cut for setRel("external");
	 */
	public void setExternal() {
		setRel("external");
	}

	/**
	 * Sets the icon used by this button. See {@link DataIcon}.
	 */
	@Override
	public void setIcon(DataIcon icon) {
		if (icon == null)
			getElement().removeAttribute("data-icon");
		else
			getElement().setAttribute("data-icon", icon.getJqmValue());
	}

	/**
	 * Sets the position of the icon. If you desire an icon only button then
	 * set the position to {@link IconPos.NOTEXT}
	 */
	@Override
	public void setIconPos(IconPos pos) {
		if (pos == null)
			getElement().removeAttribute("data-iconpos");
		else
			getElement().setAttribute("data-iconpos", pos.getJqmValue());
	}

	@Override
	public void setInline() {
		setAttribute("data-line", "true");
	}

	@Override
	public void setRel(String rel) {
		if (rel == null)
			getElement().removeAttribute("rel");
		else
			getElement().setAttribute("rel", rel);
	}

	@Override
	public void setText(String text) {
		// if the button has already been rendered then we need to go down
		// deep until we get the
		// final span
		Element e = getElement();
		while (e.getFirstChildElement() != null) {
			e = e.getFirstChildElement();
		}
		e.setInnerText(text);
	}

	/**
	 * Sets the transition to be used by this button when loading the URL.
	 */
	public void setTransition(Transition transition) {
		getElement().setAttribute("data-transition", transition.getJQMValue());
	}

}
