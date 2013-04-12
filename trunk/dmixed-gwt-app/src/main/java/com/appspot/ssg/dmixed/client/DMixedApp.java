package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.model.DMixedUsecaseServiceConnector;
import com.appspot.ssg.dmixed.shared.IDMixedUsecaseService;
import com.google.gwt.core.client.EntryPoint;

public class DMixedApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        IDMixedUsecaseService service = new DMixedUsecaseServiceConnector();
        // TODO Auto-generated method stub

    }

}
