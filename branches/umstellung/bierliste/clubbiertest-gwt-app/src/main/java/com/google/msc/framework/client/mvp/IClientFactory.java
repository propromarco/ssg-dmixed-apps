package com.google.msc.framework.client.mvp;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;

public interface IClientFactory<I extends IContext> {

    EventBus getEventBus();

    PlaceController getPlaceController();

    PlaceHistoryMapper getPlaceHistoryMapper();

    AMainPresenter<?, I> createMainPresenter();

}
