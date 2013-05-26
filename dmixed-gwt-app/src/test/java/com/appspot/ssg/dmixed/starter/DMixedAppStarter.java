package com.appspot.ssg.dmixed.starter;

import com.appspot.ssg.dmixed.server.DMixedUsecaseService;
import com.appspot.ssg.dmixed.server.jpa.FakeAdapter;
import com.ixmid.gwt.starter.IxGWTStarter;

public class DMixedAppStarter {

    public static void main(final String[] args) {
	System.setProperty(DMixedUsecaseService.JPA_ADAPTER, FakeAdapter.class.getName());
	IxGWTStarter.start("index.html", "target/dmixed", "target", "com.appspot.ssg.dmixed.DMixed");
    }

}
