package com.appspot.ssg.dmixed.client.views.components;

import java.util.List;

public interface HasCellSelectedHandler<T> {

    void render(List<T> termine);

    void addSelectionHandler(SelectionHandler<T> selectionHandler);

}
