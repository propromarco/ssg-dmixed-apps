package com.sksamuel.jqm4gwt.list;

import java.util.Collection;
import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.sksamuel.jqm4gwt.HasInset;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.JQMWidget;
import com.sksamuel.jqm4gwt.html.ListWidget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 4 May 2011 21:21:13
 * 
 */
public class JQMList extends JQMWidget implements HasClickHandlers, HasInset {

	private ListWidget	list;
	private int			clickIndex;

	/**
	 * Create a new unordered {@link JQMList} with an automatically assigned
	 * id.
	 */
	public JQMList() {
		this(false);
	}

	/**
	 * Create a new @param ordered {@link JQMList} with an automatically
	 * assigned id.
	 */
	public JQMList(boolean ordered) {
		this(Document.get().createUniqueId(), ordered);
	}

	/**
	 * Create a new unordered {@link JQMList} with the given id.
	 */
	public JQMList(String id) {
		this(id, false);
	}

	/**
	 * Create a new @param ordered {@link JQMList} with the given id.
	 */
	public JQMList(String id, boolean ordered) {
		super();

		list = new ListWidget(ordered);
		initWidget(list);

		setStyleName("jqm4gwt-list");
		setDataRole("listview");
		setId(id);
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		// for (int k = 0; k < list.getWidgetCount(); k++) {
		// Widget widget = list.getWidget(k);
		// widget.addDomHandler(handler, ClickEvent.getType());
		// }
		// return null;
		return super.addDomHandler(handler, ClickEvent.getType());
	}

	void addDivider(JQMListDivider d) {
		getElement().appendChild(d.getElement());
	}

	/**
	 * Add a new divider with the given text and an automatically assigned id
	 */
	public JQMListDivider addDivider(String text) {
		JQMListDivider d = new JQMListDivider(text);
		addDivider(d);
		return d;
	}

	void addItem(final JQMListItem item) {
		list.add(item);
		item.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				setClickIndex(list.getWidgetIndex(item));
			}
		}, ClickEvent.getType());
	}

	/**
	 * Add a new read only item
	 */
	public JQMListItem addItem(String text) {
		return addItem(text, (String) null);
	}

	/**
	 * Add an item that links to the given page
	 */
	public JQMListItem addItem(String text, JQMPage page) {
		return addItem(text, "#" + page.getId());
	}

	/**
	 * Add an item that links to the given URL
	 */
	public JQMListItem addItem(String text, String url) {
		JQMListItem item = new JQMListItem(text, url);
		addItem(item);
		return item;
	}

	/**
	 * Add a collection of read only items
	 */
	public void addItems(Collection<String> items) {
		for (String item : items)
			addItem(item);
	}

	/**
	 * Remove all items
	 */
	public void clear() {
		Element e;
		while ((e = getElement().getFirstChildElement()) != null) {
			getElement().removeChild(e);
		}
	}

	public int getClickIndex() {
		return clickIndex;
	}

	public String getDividerTheme() {
		return getAttribute("data-dividertheme");
	}

	public String getLastClicked() {
		return null;
	}

	@Override
	public boolean isInset() {
		return "true".equals(getElement().getAttribute("inset"));
	}

	public void refresh() {
		refresh(getId());
	}

	private native void refresh(String id) /*-{
		$wnd.$("#" + id).listview('refresh');
	}-*/;

	/**
	 * Remove the divider with the given text
	 */
	public void removeDivider(String text) {
	}

	public void removeItem(JQMListItem item) {
		// have to traverse list of items to find this one
		// for (int k = 0; k < getElement().getChildCount(); k++) {
		// Node node = getElement().getChild(k);
		// if (node.equals()) {
		getElement().removeChild(item.getElement());
		// }
		// }
	}

	public void removeItems(List<JQMListItem> items) {
		for (JQMListItem item : items)
			removeItem(item);
	}

	/**
	 * 
	 */
	protected void setClickIndex(int clickIndex) {
		this.clickIndex = clickIndex;
	}

	public void setDividerTheme(String theme) {
		setAttribute("data-dividertheme", theme);
	}

	@Override
	public void setInset(boolean inset) {
		if (inset)
			getElement().setAttribute("data-inset", "true");
		else
			getElement().removeAttribute("data-inset");
	}
}
