package com.appspot.ssg.dmixed.client.views.components;

import java.util.HashMap;
import java.util.Map;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.google.gwt.user.client.ui.ListBox;

public class CssListBox extends ListBox implements HasValues<ILiga> {

    private final Map<Integer, ILiga> positionsToItem = new HashMap<Integer, ILiga>();

    public CssListBox(final IDMixedCss css) {
	setStyleName(css.listbox());
    }

    @Override
    public ILiga getValue() {
	final int selectedIndex = getSelectedIndex();
	final ILiga item = positionsToItem.get(selectedIndex);
	return item;
    }

    @Override
    public void setValue(final ILiga t) {
	for (final int key : positionsToItem.keySet()) {
	    final ILiga iLiga = positionsToItem.get(key);
	    if (iLiga.getId().equals(t.getId())) {
		setSelectedIndex(key);
	    }
	}
    }

    @Override
    public void addItem(final String description, final ILiga t) {
	final int position = getItemCount();
	super.addItem(description, t.getId().toString());
	positionsToItem.put(position, t);
    }

}
