package com.google.msc.framework.client.mvp.presenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;

public abstract class AEntryPoint<I extends IContext> implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final IClientFactory<I> factory = createFactory();
        final EventBus eventBus = factory.getEventBus();
        final PlaceController placeController = factory.getPlaceController();
        final PlaceHistoryMapper mapper = factory.getPlaceHistoryMapper();
        final AMainPresenter<?, I> mainPresenter = factory.createMainPresenter();
        final Place mainPlace = createDefaultPlace();
        // Now Init
        RootPanel.get().add(mainPresenter.getView());
        final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(mapper);
        historyHandler.register(placeController, eventBus, mainPlace);
        historyHandler.handleCurrentHistory();

    }

    protected abstract IClientFactory<I> createFactory();

    protected abstract Place createDefaultPlace();

}
