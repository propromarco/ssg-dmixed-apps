package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.model.DMixedUsecaseConnector;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.google.gwt.core.client.EntryPoint;

public class DMixedApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        IDMixedUsecase service = new DMixedUsecaseConnector();
        // TODO Auto-generated method stub

    }

}
