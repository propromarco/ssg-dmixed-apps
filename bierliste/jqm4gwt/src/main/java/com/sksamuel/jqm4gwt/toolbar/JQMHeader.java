package com.sksamuel.jqm4gwt.toolbar;

import com.sksamuel.jqm4gwt.DataIcon;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.button.JQMButton;

/**
 * @author Stephen K Samuel samspade79@gmail.com 4 May 2011 21:21:13
 * 
 *         This class models a Jquery Mobile header element. It can contain
 *         text, and two optional buttons, one left and one right.
 * 
 */
public class JQMHeader extends JQMToolbar {

	/**
	 * Left button, keep reference so we can replace
	 */
	private JQMButton	left;

	/**
	 * Right button, keep reference so we can replace
	 */
	private JQMButton	right;

	/**
	 * Create a new {@link JQMHeader} with the given text and no automatic
	 * back button.
	 */
	public JQMHeader(String text) {
		this(text, false);
	}

	/**
	 * Create a new {@link JQMHeader}. If back is true then an automatic back
	 * button will be created.
	 */
	public JQMHeader(String text, boolean back) {
		super("header", "jpm4gwt-header", text);
	}

	/**
	 * Create a new {@link JQMHeader} with the given text and left and right
	 * buttons
	 */
	public JQMHeader(String text, JQMButton left, JQMButton right) {
		this(text, false);
		setLeftButton(left);
		setRightButton(right);
	}

	private JQMButton createButton(String text, JQMPage back, DataIcon icon) {
		return null;
	}

	private JQMButton createButton(String text, String url, DataIcon icon) {
		JQMButton button = new JQMButton(text, url);
		button.setIcon(icon);
		setLeftButton(button);
		return button;
	}

	/**
	 * Sets a new back button in the left position overriding whatever button
	 * was there previously (if any).
	 */
	public void setBackButton(JQMButton button) {
		button.setRel("back");
		setLeftButton(button);
	}

	public JQMButton setBackButton(String text) {
		JQMButton button = new JQMButton(text);
		button.setIcon(DataIcon.LEFT);
		button.setBack(true);
		setBackButton(button);
		return button;
	}

	public void setBackButton(String text, JQMPage parent) {
		setBackButton(text);
	}

	public JQMButton setLeftButton(JQMButton button) {
		if (left != null)
			remove(left);
		button.setStyleName("ui-btn-left");

		left = button;
		add(left);
		return button;
	}

	public JQMButton setLeftButton(String text, JQMPage page) {
		return setLeftButton(text, page, null);
	}

	public JQMButton setLeftButton(String text, JQMPage page, DataIcon icon) {
		JQMButton button = new JQMButton(text, page);
		button.setIcon(icon);
		return setLeftButton(button);
	}

	/**
	 * Convenience method for creating a new {@link JQMButton} and adding it
	 * as the left button
	 */
	public JQMButton setLeftButton(String text, String url) {
		return setLeftButton(text, url, null);
	}

	/**
	 * Convenience method for creating a new {@link JQMButton} and adding it
	 * as the left button
	 */
	public JQMButton setLeftButton(String text, String url, DataIcon icon) {
		return setLeftButton(createButton(text, url, icon));
	}

	public JQMButton setRightButton(JQMButton button) {
		if (right != null)
			remove(right);
		button.setStyleName("ui-btn-right");

		right = button;
		add(right);
		return button;
	}

	public JQMButton setRightButton(String text, DataIcon icon) {
		return setRightButton(createButton(text, (String) null, icon));
	}

	public JQMButton setRightButton(String text, String url) {
		return setRightButton(text, url, null);
	}

	public JQMButton setRightButton(String text, String url, DataIcon icon) {
		return setRightButton(createButton(text, url, icon));
	}
}
