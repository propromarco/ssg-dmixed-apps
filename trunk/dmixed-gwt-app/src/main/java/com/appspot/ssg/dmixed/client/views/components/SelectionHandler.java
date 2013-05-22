package com.appspot.ssg.dmixed.client.views.components;

import com.appspot.ssg.dmixed.client.views.SelectionEvent;

public interface SelectionHandler<T> {
    void onSelect(SelectionEvent<T> event);
}