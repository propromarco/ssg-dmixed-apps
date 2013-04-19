package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.places.LoginPlace;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.history.HistoryObserver;
import com.googlecode.mgwt.mvp.client.history.MGWTPlaceHistoryHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;

public class DMixedApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        // set viewport and other settings for mobile
        MGWT.applySettings(MGWTSettings.getAppSetting());
        // create an instance of AnimatableDisplay
        final AnimatableDisplay display = GWT.create(AnimatableDisplay.class);

        final ClientFactory clientFactory = new ClientFactoryImpl();

        // instanciate your activitymapper
        final PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);

        // instanciate your animationMapper
        final PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();

        // setup an activitymanager for the display
        final AnimatingActivityManager activityManager = new AnimatingActivityManager(appActivityMapper, appAnimationMapper,
                clientFactory.getEventBus());

        // pass the display to the activity manager
        activityManager.setDisplay(display);

        // add the display to the DOM
        RootPanel.get().add(display);

        final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

        final HistoryObserver historyObserver = new AppHistoryObserver();

        final MGWTPlaceHistoryHandler historyHandler = new MGWTPlaceHistoryHandler(historyMapper, historyObserver);

        historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new LoginPlace());
        historyHandler.handleCurrentHistory();

        //
        // // build animation helper and attach it
        // final AnimationHelper animationHelper = new AnimationHelper();
        // RootPanel.get().add(animationHelper);
        //
        // // build some UI
        // final LayoutPanel layoutPanel = new LayoutPanel();
        // final Button button = new Button("anmelden");
        // layoutPanel.add(create());
        // layoutPanel.add(button);
        //
        // // animate
        // animationHelper.goTo(layoutPanel, Animation.SLIDE);
        //
        // final IDMixedMessages messages = GWT.create(IDMixedMessages.class);
        // final String baseUrl = GWT.getHostPageBaseURL();
        // final IDMixedUsecase service = new DMixedUsecaseConnector(baseUrl);
        // final DMixedModel model = new DMixedModel(messages);
        // // final JQMPage page = new LoginPage(service, model);
        // // JQMContext.changePage(page);
    }

}