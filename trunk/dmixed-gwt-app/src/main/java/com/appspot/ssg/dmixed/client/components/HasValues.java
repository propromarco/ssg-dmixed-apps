package com.appspot.ssg.dmixed.client.components;

import com.google.gwt.user.client.ui.HasValue;

public interface HasValues<T> extends HasValue<T> {
    void setValues(T... ts);
}
