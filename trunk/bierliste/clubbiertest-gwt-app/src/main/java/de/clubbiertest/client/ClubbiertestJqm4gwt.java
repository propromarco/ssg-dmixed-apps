/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.client;

import com.google.gwt.core.client.EntryPoint;

import com.sksamuel.jqm4gwt.JQMContext;

import de.clubbiertest.client.jqm4gwt.JQMWelcomePage;

public class ClubbiertestJqm4gwt implements EntryPoint
{
    @Override public void onModuleLoad()
    {
        final StServerCommunicationUtil util = new StServerCommunicationUtil();
        final JQMWelcomePage page = new JQMWelcomePage(util);
        JQMContext.changePage(page);
    }
}
