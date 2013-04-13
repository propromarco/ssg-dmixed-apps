package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.client.model.DMixedUsecaseConnector;
import com.appspot.ssg.dmixed.client.pages.LoginPage;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.google.gwt.core.client.EntryPoint;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.JQMPage;

public class DMixedApp implements EntryPoint {

    @Override
    public void onModuleLoad() {
        IDMixedUsecase service = new DMixedUsecaseConnector();
        JQMPage page = new LoginPage(service);
        JQMContext.changePage(page);
    }

}
