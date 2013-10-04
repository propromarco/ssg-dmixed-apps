package com.sksamuel.jqm4gwt.list;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Stephen K Samuel samspade79@gmail.com 5 May 2011 11:21:29
 * 
 */
public class JQMListItem extends Widget implements HasText, HasHTML {

	/**
	 * Add a count bubble
	 */
	private Element	countElem;

	/**
	 * Add a count bubble
	 */
	private Element	imageElem;

	/**
	 * 
	 */
	private Element	anchor;

	/**
	 * 
	 */
	private Element	htmlElem;

	/**
	 * Create a read only {@link JQMList}
	 */
	JQMListItem(String text) {
		if (text == null)
			throw new RuntimeException("Cannot create list item with null text");

		setElement(Document.get().createLIElement());
		setStyleName("jqm4gwt-listitem");
		setText(text);
		setId();
	}

	/**
	 * Create a linking {@link JQMList}
	 */
	JQMListItem(String text, String url) {
		this(text);
		if (url != null)
			setUrl(url);
	}

	private void attachChild(Element elem) {
		if (anchor == null)
			getElement().appendChild(elem);
		else
			anchor.appendChild(elem);
	}

	public Integer getCount() {
		if (countElem == null)
			return null;
		return Integer.parseInt(countElem.getInnerText());
	}

	@Override
	public String getHTML() {
		return htmlElem == null ? null : htmlElem.getInnerHTML();
	}

	@Override
	public String getText() {
		return getHTML();
	}

	public String getUrl() {
		return null;
	}

	private void moveAnchorChildrenToThis() {
		for (int k = 0; k < anchor.getChildCount(); k++) {
			Node node = anchor.getChild(k);
			anchor.removeChild(node);
			getElement().appendChild(node);
		}
	}

	private void moveThisChildrenToAnchor() {
		for (int k = 0; k < getElement().getChildCount(); k++) {
			Node node = getElement().getChild(k);
			getElement().removeChild(node);
			anchor.appendChild(node);
		}
	}

	public void removeCount() {
		if (countElem != null) {
			getElement().removeChild(countElem);
			countElem = null;
		}
	}

	public void removeImage() {
		if (imageElem != null) {
			getElement().removeChild(imageElem);
			imageElem = null;
		}
	}

	/**
	 * Remove the url from this list item changing the item into a read only
	 * item
	 */
	public void removeUrl() {
		if (anchor == null)
			return;
		moveAnchorChildrenToThis();
		getElement().removeChild(anchor);
		anchor = null;
	}

	public JQMListItem setCount(Integer count) {
		if (count == null)
			throw new RuntimeException(
					"Cannot set count to null. Call removeCount() if you wanted to remove the bubble");

		if (countElem == null) {
			countElem = Document.get().createSpanElement();
			countElem.setClassName("ui-li-count");
			attachChild(countElem);
		}
		countElem.setInnerText(count.toString());

		return this;
	}

	@Override
	public void setHTML(String html) {
		if (html == null)
			throw new RuntimeException(
					"Cannot set html to null. Call removehtml() if you wanted to remove the html");

		if (htmlElem == null) {
			htmlElem = Document.get().createSpanElement();
			attachChild(htmlElem);
		}
		htmlElem.setInnerHTML(html);
	}

	public void setIcon(String src) {
		setImage(src, true);
	}

	private void setId() {
		getElement().setId(Document.get().createUniqueId());
	}

	/**
	 * Sets the image on this
	 */
	public void setImage(String src, boolean icon) {
		if (src == null)
			throw new RuntimeException(
					"Cannot set image to null. Call removeImage() if you wanted to remove the image");

		if (imageElem == null) {
			imageElem = Document.get().createImageElement();
			attachChild(imageElem);
		}
		imageElem.setAttribute("src", src);

		if (icon)
			imageElem.setAttribute("class", "ui-li-icon");
		else
			imageElem.removeAttribute("class");
	}

	@Override
	public void setText(String text) {
		setHTML(text);
	}

	public void setThumbnail(String src) {
		setImage(src, false);
	}

	/**
	 * Sets the url to link to for this item. If this item was a read only
	 * item it automatically becomes linkable.
	 */
	public void setUrl(String url) {
		if (url == null)
			throw new RuntimeException("Cannot set URL to null. Call removeUrl() if you wanted to remove the URL");
		if (anchor == null) {
			// need to make anchor and move children to it
			anchor = Document.get().createAnchorElement();
			moveThisChildrenToAnchor();
			getElement().appendChild(anchor);
		}
		anchor.setAttribute("href", url);

	}

}
