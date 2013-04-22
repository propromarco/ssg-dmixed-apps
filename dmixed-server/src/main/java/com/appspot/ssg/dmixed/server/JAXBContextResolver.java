package com.appspot.ssg.dmixed.server;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

    private JSONConfiguration _conf;

    public JAXBContextResolver() {
	_conf = JSONConfiguration.natural().build();
    }

    @Override
    public JAXBContext getContext(Class<?> type) {
	try {
	    return new JSONJAXBContext(_conf, type);
	} catch (JAXBException e) {
	    e.printStackTrace();
	    return null;
	}
    }

}
