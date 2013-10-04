package com.sksamuel.jqm4gwt;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.toolbar.JQMFooter;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

/**
 * @author Stephen K Samuel samspade79@gmail.com 4 May 2011 23:55:27
 * 
 *         A {@link JQMPage} is the base container for a single page. Any JQM
 *         widgets can be added to the page. You can consider a JQMPage as like
 *         a GWT "view" in the MVP paradigm.
 * 
 */
public class JQMPage extends ComplexPanel {

	private final String	id;

	/**
	 * The primary content div
	 */
	private JQMContent	content;

	/**
	 * Create a new JQMPage with an automatically assigned page id.
	 */
	public JQMPage() {
		this("page" + JQMContext.getNextCounter());
	}

	/**
	 * Creates an AbsolutePanel with the given element. This is protected so
	 * that it can be used by {@link RootPanel} or a subclass that wants to
	 * substitute another element. The element is presumed to be a
	 * &lt;div&gt;.
	 */
	public JQMPage(String id) {
		this.id = id;
		if (id == null)
			throw new RuntimeException("id for page cannot be null");
		if (id.contains(" "))
			throw new RuntimeException("id for page cannot contain space");

		setElement(Document.get().createDivElement());
		// getElement().setId(id);
		getElement().setAttribute("data-role", "page");
		getElement().setAttribute("data-url", id);

		content = new JQMContent();
		add(content, getElement());

		JQMContext.appendPage(this);
		bindLifecycleEvents(this, getId());
		// Window.alert(getId());
	}

	/**
	 * Create a new JQMPage with an automatically assigned page id, and then
	 * add the given widgets serially to the page layout.
	 */
	public JQMPage(Widget... widgets) {
		this();
		if (widgets != null)
			add(widgets);
	}

	/**
	 * Sets the footer of the page. Alias for setFooter(). Any existing footer
	 * will be replaced.
	 */
	public void add(JQMFooter footer) {
		setFooter(footer);
	}

	/**
	 * Sets the header of the page. Alias for setHeader(). Any existing header
	 * will be replaced.
	 */
	public void add(JQMHeader header) {
		setHeader(header);
	}

	/**
	 * Adds a widget to the primary content div of the container
	 */
	public void add(Widget widget) {
		content.add(widget);
	}

	/**
	 * Adds all the given widgets. A convience method.
	 */
	public void add(Widget[] widgets) {
		for (Widget widget : widgets)
			add(widget);
	}

	private native void bindLifecycleEvents(JQMPage p, String id) /*-{
		$wnd.$('div[data-url="' + id + '"]').bind("pageshow",
				function(event, ui) {
					p.@com.sksamuel.jqm4gwt.JQMPage::onPageShow()();
				});
		$wnd.$('div[data-url="' + id + '"]').bind("pagehide",
				function(event, ui) {
					p.@com.sksamuel.jqm4gwt.JQMPage::onPageHide()();
				});
	}-*/;

	/**
	 * Returns the primary content div
	 */
	public JQMContent getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public String getTheme() {
		return null;
	}

	public boolean isBackButton() {
		return "true".equals(getElement().getAttribute("data-add-back-btn"));
	}

	/**
	 * Triggered on the page being hidden, before its transition begins.
	 */
	protected void onPageBeforeHide() {
	}

	/**
	 * Triggered on the page being shown, before its transition begins.
	 */
	protected void onPageBeforeShow() {
	}

	/**
	 * Triggered on the page being hidden, after its transition completes.
	 */
	protected void onPageHide() {

	}

	/**
	 * Triggered on the page being shown, after its transition completes.
	 */
	protected void onPageShow() {

	}

	public void removeFooter() {
		Element element = getElement().getFirstChildElement();
		while (element != null) {
			if ("footer".equals(element.getAttribute("data-role"))) {
				getElement().removeChild(element);
				return;
			}
			element = element.getNextSiblingElement();
		}
	}

	public void removeHeader() {
		Element element = getElement().getFirstChildElement();
		while (element != null) {
			if ("header".equals(element.getAttribute("data-role"))) {
				getElement().removeChild(element);
				return;
			}
			element = element.getNextSiblingElement();
		}
	}

	/**
	 * Sets whether or not this page should have an auto generated back
	 * button. If so, it will be placed in the left slot and override any left
	 * button already there.
	 * 
	 * If you want a back button in the right, then programatically create a
	 * button, set it to back, and call setRightButton() with it as the param.
	 */
	public void setBackButton(boolean backButton) {
		if (backButton) {
			getElement().setAttribute("data-add-back-btn", "true");
		} else {
			getElement().removeAttribute("data-add-back-btn");
		}
	}

	/**
	 * Sets the footer element, overriding an existing footer if any.
	 */
	public void setFooter(JQMFooter footer) {
		removeFooter();
		getElement().appendChild(footer.getElement());
	}

	/**
	 * Sets the header element, overriding an existing header if any.
	 */
	public void setHeader(JQMHeader header) {
		removeHeader();
		getElement().insertBefore(header.getElement(), getElement().getFirstChild());
	}

	public JQMPage setTheme(String themeName) {
		getElement().setAttribute("data-theme", themeName);
		return this;
	}

	public void setTitle(String title) {
		getElement().setAttribute("data-title", title);
	}

}
