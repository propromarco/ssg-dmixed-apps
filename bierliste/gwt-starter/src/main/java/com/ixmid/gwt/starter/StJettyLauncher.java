/* Copyright, (c) 2011 Suretec GmbH  */

package com.ixmid.gwt.starter;

import java.io.File;
import java.lang.reflect.Field;

import org.mortbay.jetty.webapp.WebAppContext;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.dev.shell.jetty.JettyLauncher;

public class StJettyLauncher extends JettyLauncher
{
    @Override protected WebAppContext createWebAppContext( final TreeLogger logger, final File appRootDir )
    {
        final WebAppContext webAppContext = super.createWebAppContext(logger, appRootDir);
        try
        {
            final Field declaredField = webAppContext.getClass().getDeclaredField("bootStrapOnlyClassLoader");
            if ( !declaredField.isAccessible() )
            {
                declaredField.setAccessible(true);
            }
            final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            declaredField.set(webAppContext, contextClassLoader);
        }
        catch ( final Exception e )
        {
            e.printStackTrace();
        }

        return webAppContext;
    }
}
