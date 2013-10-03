/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.liste.server;

import de.clubbiertest.liste.server.util.ListeParserTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( Suite.class ) @SuiteClasses( { BierlisteServiceTest.class, ListeParserTest.class } )
public class AllTests
{
}
