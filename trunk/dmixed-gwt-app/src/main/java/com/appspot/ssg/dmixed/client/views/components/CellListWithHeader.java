package com.appspot.ssg.dmixed.client.views.components;

import java.util.ArrayList;
import java.util.List;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.appspot.ssg.dmixed.client.views.SelectionEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

public class CellListWithHeader<T> extends FlowPanel {

    private final BasicCell<T> basicCell;

    public static abstract class BasicCell<T> extends FlowPanel implements HasCellSelectedHandler<T> {

	private final List<SelectionHandler<T>> selectionHandlers = new ArrayList<SelectionHandler<T>>();
	
	public BasicCell(final IDMixedCss css) {
	    setStyleName(css.basiccell());
	}

	public abstract String getDisplayString(final T termin);

	public abstract boolean canBeSelected(final T model);

	@Override
	public void render(final List<T> termine) {
	    clear();
	    for (final T t : termine) {
		final String displayString = getDisplayString(t);
		final Anchor w = new Anchor(displayString);
		w.addClickHandler(new ClickHandler() {

		    @Override
		    public void onClick(final ClickEvent event) {
			fireSelection(t);
		    }
		});
		add(w);
	    }
	}

	private void fireSelection(final T t) {
	    for (final SelectionHandler<T> handler : selectionHandlers) {
		handler.onSelect(new SelectionEvent<T>(t));
	    }
	}

	@Override
	public void addSelectionHandler(final SelectionHandler<T> selectionHandler) {
	    selectionHandlers.add(selectionHandler);
	}
    }

    public CellListWithHeader(final IDMixedCss css, final BasicCell<T> basicCell) {
	setStyleName(css.celllistwithheader());
	this.basicCell = basicCell;
	add(basicCell);
    }

    public HasCellSelectedHandler<T> getCellList() {
	return basicCell;
    }

}
