package com.sksamuel.jqm4gwt.layout;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.AbstractJQMWidget;
import com.sksamuel.jqm4gwt.JQMContext;

/**
 * @author Stephen K Samuel samspade79@gmail.com 9 May 2011 23:54:07
 * 
 *         This widget is a panel that allows child widgets to be laid out in a
 *         regular grid. The grid is regular in that there is no concept of cell
 *         spans as you can use in a normal HTML table.
 * 
 */
public class JQMTable extends AbstractJQMWidget {

	private final int	columns;

	/**
	 * Create a new table with the given number of columns. Tables must have
	 * at least 2 and at most 5 columns. They cannot be resized once created.
	 */
	public JQMTable(int columns) {
		super(Document.get().createDivElement(), null, "jqm4gwt-table");
		this.columns = columns;
		if (columns < 2)
			throw new IllegalArgumentException("Min column count is 2");
		if (columns > 5)
			throw new IllegalArgumentException("Max column count is 5");

		switch (columns) {
		case 2:
			getElement().setAttribute("class", "ui-grid-a");
			break;
		case 3:
			getElement().setAttribute("class", "ui-grid-b");
			break;
		case 4:
			getElement().setAttribute("class", "ui-grid-c");
			break;
		case 5:
			getElement().setAttribute("class", "ui-grid-d");
			break;
		}
	}

	/**
	 * Add the given {@link Widget} into the next available cell. This call
	 * will wrap to a new row if the existing row is already filled.
	 * 
	 * The given widget will be wrapped inside a div with the appropriate
	 * JQuery Mobile class name given (eg, "ui-block-a" for the first cell,
	 * etc)
	 */
	public void add(Widget widget) {
		int size = getElement().getChildCount();
		String klass = null;
		if (size % columns == 0)
			klass = "ui-block-a";
		else if (size % columns == 1)
			klass = "ui-block-b";
		else if (size % columns == 2)
			klass = "ui-block-c";
		else if (size % columns == 3)
			klass = "ui-block-d";
		else if (size % columns == 4)
			klass = "ui-block-e";

		Element div = Document.get().createDivElement();
		div.setAttribute("class", klass);
		div.appendChild(widget.getElement());
		div.setId("id" + JQMContext.getNextCounter());
		getElement().appendChild(div);
		render(div.getId());
	}

	public void clear() {

	}

	/**
	 * Removes the last cell
	 */
	public void removeLast() {
		int childCount = getElement().getChildCount();
		if (childCount > 0)
			getElement().removeChild(getElement().getChild(childCount - 1));
	}

	/**
	 * Ask JQuery Mobile to "render" the element with the given id.
	 */
	private native void render(String id) /*-{
		$wnd.$("#" + id).page();
	}-*/;

	/**
	 * Returns the number of cells
	 */
	public int size() {
		return getElement().getChildCount();
	}
}
