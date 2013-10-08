package com.google.msc.framework.client.mvp.presenter;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class Slot extends FlowPanel {

    private APresenter<?, ?> presenter;

    Slot(final String id) {
        getElement().setId(id);
    }

    void setPresenter(final APresenter<?, ?> presenter) {
        final Widget oldWidget;
        if (this.presenter != null) {
            oldWidget = this.presenter.getView();
        }
        else {
            oldWidget = this;
        }
        final Widget newWidget = presenter.getView();
        replaceWidget(oldWidget, newWidget);
        this.presenter = presenter;
    }

    APresenter<?, ?> getPresenter() {
        return presenter;
    }

    static void replaceWidget(final Widget oldWidget, final Widget newWidget) {
        final FlowPanel parent = (FlowPanel) oldWidget.getParent();
        if (parent == null) {
            return;
        }
        final int widgetIndex = parent.getWidgetIndex(oldWidget);
        parent.insert(newWidget, widgetIndex);
        oldWidget.removeFromParent();
    }

}
