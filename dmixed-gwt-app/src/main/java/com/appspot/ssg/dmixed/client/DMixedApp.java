/* Copyright, (c) 2013 Suretec GmbH  */

package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.places.LoginPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class DMixedApp implements EntryPoint
{
    @Override public void onModuleLoad()
    {
        final ClientFactory clientFactory = new ClientFactoryImpl();
        final IDMixedCss styles = clientFactory.getStyles();

        // instanciate your activitymapper
        final PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);

        // setup an activitymanager for the display
        final ActivityManager activityManager = new ActivityManager(appActivityMapper, clientFactory.getEventBus());

        // pass the display to the activity manager
        final SimplePanel display = new SimplePanel();
        display.setStyleName(styles.main());
        activityManager.setDisplay(display);

        // add the display to the DOM
        final RootPanel rootPanel = RootPanel.get();
        rootPanel.setStyleName(styles.body());
        rootPanel.add(display);
        final int clientHeight = Window.getClientHeight();
        final int clientWidth = Window.getClientWidth();
        rootPanel.setPixelSize(clientWidth, clientHeight);

        final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

        final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);

        final Place startPlace = new LoginPlace();

        historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), startPlace);
        historyHandler.handleCurrentHistory();

    }

    public static int getHeigth( final int offset )
    {
        return Window.getClientHeight() - offset - 18;
    }
}
