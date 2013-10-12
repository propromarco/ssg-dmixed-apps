package com.google.msc.framework.client.mvp;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface IContext {

    EventBus getEventBus();

    PlaceController getPlaceController();

}
