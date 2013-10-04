package com.sksamuel.jqm4gwt.form.elements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextArea;
import com.sksamuel.jqm4gwt.HasGridDimensions;
import com.sksamuel.jqm4gwt.form.JQMFieldContainer;
import com.sksamuel.jqm4gwt.html.FormLabel;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 May 2011 13:49:09
 * 
 *         An implementation of a standard HTML Textarea
 * 
 */
public class JQMTextArea extends JQMFieldContainer implements HasGridDimensions, HasText {

	private final FormLabel	label	= new FormLabel();
	private final TextArea	input	= new TextArea();

	/**
	 * Create a new {@link JQMTextArea} with an automatically assigned id and
	 * no label text
	 */
	public JQMTextArea() {
		this(Document.get().createUniqueId());
	}

	/**
	 * Create a new {@link JQMTextArea} with the given id and no label text.
	 */
	public JQMTextArea(String id) {
		this(id, null);
	}

	/**
	 * Create a new {@link JQMTextArea} with the given id and label text and
	 * with the default size
	 */
	public JQMTextArea(String id, String text) {
		this(id, text, 40, 5);
	}

	/**
	 * Create a new {@link JQMTextArea} with the given id and label text and
	 * with the specified number of columns and rows.
	 */
	public JQMTextArea(String id, String text, int cols, int rows) {

		setText(text);
		label.setFor(id);

		input.getElement().setId(id);
		input.setName(id);

		setColumns(cols);
		setRows(rows);

		add(label);
		add(input);
	}

	@Override
	public int getColumns() {
		return Integer.parseInt(input.getElement().getAttribute("cols"));
	}

	@Override
	public int getRows() {
		return Integer.parseInt(input.getElement().getAttribute("rows"));
	}

	@Override
	public String getText() {
		return label.getText();
	}

	@Override
	public void setColumns(int cols) {
		input.getElement().setAttribute("cols", String.valueOf(cols));
	}

	@Override
	public void setRows(int rows) {
		input.getElement().setAttribute("rows", String.valueOf(rows));
	}

	@Override
	public void setText(String text) {
		label.setText(text);
	}

}
