/* Copyright, (c) 2012 Suretec GmbH  */

package com.google.gwt.dev;

import java.util.concurrent.FutureTask;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.CompileTaskRunner.CompileTask;
import com.google.gwt.dev.shell.CheckForUpdates;
import com.google.gwt.dev.shell.CheckForUpdates.UpdateResult;
import com.google.gwt.dev.util.Memory;
import com.google.gwt.dev.util.log.speedtracer.SpeedTracerLogger;

public class StCompilerWrapper extends Compiler
{
    public StCompilerWrapper( final CompilerOptions options )
    {
        super(options);
    }

    public static void compile( final String[] args )
    {
        Memory.initialize();
        if ( System.getProperty("gwt.jjs.dumpAst") != null )
        {
            System.out.println("Will dump AST to: " + System.getProperty("gwt.jjs.dumpAst"));
        }

        SpeedTracerLogger.init();

        /*
         * NOTE: main always exits with a call to System.exit to terminate any
         * non-daemon threads that were started in Generators. Typically, this is to
         * shutdown AWT related threads, since the contract for their termination is
         * still implementation-dependent.
         */
        final CompilerOptions options = new CompilerOptionsImpl();
        if ( new ArgProcessor(options).processArgs(args) )
        {
            final CompileTask task = new CompileTask()
            {
                public boolean run( final TreeLogger logger )
                        throws UnableToCompleteException
                {
                    FutureTask<UpdateResult> updater = null;
                    if ( !options.isUpdateCheckDisabled() )
                    {
                        updater = CheckForUpdates.checkForUpdatesInBackgroundThread(logger, CheckForUpdates.ONE_DAY);
                    }
                    final boolean success = new Compiler(options).run(logger);
                    if ( success )
                    {
                        CheckForUpdates.logUpdateAvailable(logger, updater);
                    }
                    return success;
                }
            };
            if ( CompileTaskRunner.runWithAppropriateLogger(options, task) )
            {
            }
        }
    }
}
