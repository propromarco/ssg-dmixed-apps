/* Copyright, (c) 2012 Suretec GmbH  */

package com.google.gwt.dev;

public class StDevModeWrapper extends DevMode
{
    private static DevMode hostedMode;

    public static void startup( final String[] args, final Boolean headless )
    {
        try
        {
            hostedMode = new DevMode();
            hostedMode.setHeadless(headless);
            if ( new ArgProcessor(hostedMode.options).processArgs(args) )
            {
                hostedMode.run();
            }
        }
        finally
        {
            if (( hostedMode != null ) && !hostedMode.isHeadless() )
            {
                hostedMode.shutDown();
            }
        }
    }

    public static void stop()
    {
        if ( (hostedMode != null) && hostedMode.isHeadless() )
        {
            hostedMode.shutDown();
        }
    }
}
