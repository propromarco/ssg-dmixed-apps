package com.sksamuel.jqm4gwt.form.elements;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;
import com.sksamuel.jqm4gwt.html.FormLabel;

/**
 * @author Stephen K Samuel samspade79@gmail.com 12 Jul 2011 15:42:39
 * 
 */
public class JQMCheckbox implements HasText, IsChecked {

	private final Element	input;
	private final FormLabel	label;

	JQMCheckbox(Element input, FormLabel label) {
		this.input = input;
		this.label = label;
	}

	@Override
	public String getText() {
		return label.getText();
	}

	@Override
	public boolean isSelected() {
		String style = label.getStyleName();
		return style != null && style.contains("ui-btn-active");
	}

	@Override
	public void setText(String text) {
		label.setText(text);
	}
}
