package com.appspot.ssg.dmixed.client.views;

public class SelectionEvent<T> {

    private final T selected;

    public SelectionEvent(final T selected) {
	this.selected = selected;
    }

    public T getSelected() {
	return selected;
    }

}
