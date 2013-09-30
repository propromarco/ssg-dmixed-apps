package com.appspot.ssg.dmixed.client.activities;

import com.google.gwt.user.client.ui.IsWidget;

public interface IDMixedView extends IsWidget {

    void setHeaderText(String headerText);

    void setProgress(boolean visible);

    void showError(Throwable exception);

    void showMessage(String message);

}
