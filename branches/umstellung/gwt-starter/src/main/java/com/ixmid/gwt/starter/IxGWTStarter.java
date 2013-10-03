/* Copyright, (c) 2012 */

package com.ixmid.gwt.starter;

import java.io.File;

import java.lang.reflect.Method;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class IxGWTStarter
{
    public static void start( final String startupUrl, final String war, final String logdir, final String module )
    {
        start(startupUrl, war, logdir, module, false);
    }

    public static void start( final String startupUrl, final String war, final String logdir, final String module, final boolean headless )
    {
        start(startupUrl, war, logdir, module, "com.ixmid.gwt.starter.StJettyLauncher", headless);
    }

    public static void start(
            final String startupUrl,
            final String war,
            final String logdir,
            final String module,
            final String server,
            final boolean headless
    )
    {
        try
        {
            final List<URL> urls = createClasspathList();
            final ClassLoader parentCl = ClassLoader.getSystemClassLoader();//Thread.currentThread().getContextClassLoader();
			final ClassLoader classLoader = new URLClassLoader(urls.toArray(new URL[0]), parentCl);
            Thread.currentThread().setContextClassLoader(classLoader);
            final String mainClass = "com.google.gwt.dev.StDevModeWrapper";
            final Class<?> loadClass = classLoader.loadClass(mainClass);
            final Method method = loadClass.getMethod("startup", new Class[]
            {
                String[].class, Boolean.class
            });
            final Object args = new String[]
            {
                "-startupUrl", startupUrl, "-war", war, "-logdir", logdir, module, "-server", server
            };
            method.invoke(null, args, headless);
        }
        catch ( final Exception e )
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    protected static List<URL> createClasspathList()
            throws MalformedURLException
    {
        final File rootDir = new File("");
        final String absolutePath = rootDir.getAbsolutePath();
        final String classpath = System.getProperty("java.class.path");
        final String[] split = classpath.split(File.pathSeparatorChar + "");
        final List<URL> urls = new ArrayList<URL>();
        {
            // SCAN
            for ( final String classPathEntry: split )
            {
                final File classPathEntryFile = new File(classPathEntry);
                final URL url = classPathEntryFile.toURI().toURL();
                urls.add(url);
                final String[] split2 = url.toString().split("/");
                if ( split2[split2.length - 1].equals("classes") )
                {
                    final String ohne = classPathEntry.substring(0, classPathEntry.indexOf("target"));
                    {
                        // Check src/main/java
                        final File srcMainJava = new File(ohne, "src/main/java");
                        if ( srcMainJava.exists() && srcMainJava.isDirectory() )
                        {
                            urls.add(srcMainJava.toURI().toURL());
                        }
                    }
                    {
                        // Check src/main/resources
                        final File srcMainResources = new File(ohne, "src/main/resources");
                        if ( srcMainResources.exists() && srcMainResources.isDirectory() )
                        {
                            urls.add(srcMainResources.toURI().toURL());
                        }
                    }
                    {
                        // Check src/main/java
                        final File srcMainJava = new File(ohne, "src/test/java");
                        if ( srcMainJava.exists() && srcMainJava.isDirectory() && srcMainJava.getAbsolutePath().startsWith(absolutePath) )
                        {
                            urls.add(srcMainJava.toURI().toURL());
                        }
                    }
                    {
                        // Check src/main/resources
                        final File srcMainResources = new File(ohne, "src/test/resources");
                        if ( srcMainResources.exists() && srcMainResources.isDirectory()
                             && srcMainResources.getAbsolutePath().startsWith(absolutePath) )
                        {
                            urls.add(srcMainResources.toURI().toURL());
                        }
                    }
                    {
                        // Check target/generated-sources/gwt
                        final File targetGeneratedSourcesGwt = new File(ohne, "target/generated-sources/gwt");
                        if ( targetGeneratedSourcesGwt.exists() && targetGeneratedSourcesGwt.isDirectory() )
                        {
                            urls.add(targetGeneratedSourcesGwt.toURI().toURL());
                        }
                    }
                    {
                        // Check target/classes
                        final File targetClasses = new File(ohne, "target/classes");
                        if ( targetClasses.exists() && targetClasses.isDirectory() )
                        {
                            urls.add(targetClasses.toURI().toURL());
                        }
                    }
//                    {
//                    	// Check target/appengine-sdk
//                    	{
//                    		final File targetClasses = new File(ohne, "target/appengine-java-sdk/lib/impl/appengine-local-runtime.jar");
//                    		if ( targetClasses.exists() && !targetClasses.isDirectory() )
//                    		{
//                    			urls.add(targetClasses.toURI().toURL());
//                    			System.setProperty("appengine.sdk.root", ohne + "/target/appengine-java-sdk");
//                    		}
//                    	}
//                    	{
//                    		final File targetClasses = new File(ohne, "target/appengine-java-sdk/lib/agent/appengine-agent.jar");
//                    		if ( targetClasses.exists() && !targetClasses.isDirectory() )
//                    		{
//                    			urls.add(targetClasses.toURI().toURL());
//                    			System.setProperty("appengine.sdk.root", ohne + "/target/appengine-java-sdk");
//                    		}
//                    	}
//                    	{
//                    		final File targetClasses = new File(ohne, "target/appengine-java-sdk/lib/appengine-tools-api.jar");
//                    		if ( targetClasses.exists() && !targetClasses.isDirectory() )
//                    		{
//                    			urls.add(targetClasses.toURI().toURL());
//                    			System.setProperty("appengine.sdk.root", ohne + "/target/appengine-java-sdk");
//                    		}
//                    	}
//                    }
                }
            }
        }
        for ( final URL url: urls )
        {
            Logger.getLogger(IxGWTStarter.class.getName()).finest(url.toString());
        }
        return urls;
    }

    public static void stop()
    {
        try
        {
            final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            final String mainClass = "com.google.gwt.dev.StDevModeWrapper";
            final Class<?> loadClass = classLoader.loadClass(mainClass);
            final Method method = loadClass.getMethod("stop");
            method.invoke(null, null);
        }
        catch ( final Exception e )
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void compileForTest( final String war, final String module )
    {
        try
        {
            final List<URL> urls = createClasspathList();
            final ClassLoader classLoader = new URLClassLoader(urls.toArray(new URL[0]), Thread.currentThread().getContextClassLoader());
            Thread.currentThread().setContextClassLoader(classLoader);
            final String mainClass = "com.google.gwt.dev.StCompilerWrapper";
            final Class<?> loadClass = classLoader.loadClass(mainClass);
            final Method method = loadClass.getMethod("compile", new Class[] { String[].class });
            final Object args = new String[]
            {
                "-style", "PRETTY", "-war", war, "-logLevel", "WARN", module
            };
            method.invoke(null, args);
        }
        catch ( final Exception e )
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
