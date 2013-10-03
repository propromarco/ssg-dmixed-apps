/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.client.beans;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JSONUtils
{
    public static boolean getBoolean( final JSONValue value )
    {
        final JSONBoolean jsonBoolean = value.isBoolean();
        if ( jsonBoolean != null )
        {
            return jsonBoolean.booleanValue();
        }
        final JSONString jsonString = value.isString();
        return Boolean.parseBoolean(jsonString.stringValue());
    }

    public static String getString( final JSONValue value )
    {
        if ( value == null )
        {
            return null;
        }
        final JSONString jsonString = value.isString();
        return jsonString.stringValue();
    }

    public static Double getDouble( final JSONValue value )
    {
        if ( value == null )
        {
            return null;
        }
        final JSONNumber jsonNumber = value.isNumber();
        if ( jsonNumber != null )
        {
            return jsonNumber.doubleValue();
        }
        final JSONString jsonString = value.isString();
        return Double.parseDouble(jsonString.stringValue());
    }
}
