package com.appspot.ssg.dmixed.client.views.components;

public interface HasValues<T> {
    T getValue();

    void setValue(T t);

    void addItem(String description, T t);

    void clear();
}
