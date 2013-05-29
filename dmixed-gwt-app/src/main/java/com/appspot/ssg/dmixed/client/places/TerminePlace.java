/* Copyright, (c) 2013 Suretec GmbH  */

package com.appspot.ssg.dmixed.client.places;

import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class TerminePlace extends Place
{
    private final Long userId;
    private final boolean admin;

    @Prefix( "Termine" )
    public static class TerminePlaceTokenizer implements PlaceTokenizer<TerminePlace>
    {
        @Override public TerminePlace getPlace( final String token )
        {
            final List<Long> list = PLaceStringEncoderDecoder.decode(token);
            final Long userId = list.get(0);
            final boolean admin = PLaceStringEncoderDecoder.toBoolean(list.get(1));
            return new TerminePlace(userId, admin);
        }

        @Override public String getToken( final TerminePlace place )
        {
            final Long userId = place.getUserId();
            final boolean admin = place.isAdmin();
            return PLaceStringEncoderDecoder.encode(userId, PLaceStringEncoderDecoder.toLong(admin));
        }

    }

    public TerminePlace( final Long userId, final boolean admin )
    {
        this.userId = userId;
        this.admin = admin;
    }

    public boolean isAdmin()
    {
        return admin;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override public int hashCode()
    {
        return 4;
    }

    @Override public boolean equals( final Object other )
    {
        if ( other == this )
        {
            return true;
        }
        if ( other == null )
        {
            return false;
        }

        if ( other instanceof TerminePlace )
        {
            return true;
        }
        return false;
    }
}
