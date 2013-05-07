package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public abstract class AbstractData {
    protected final JSONObject _jsonObject;

    public AbstractData() {
	_jsonObject = new JSONObject();
    }

    public AbstractData(final JSONObject jsonObject) {
	_jsonObject = jsonObject;
    }

    protected String getString(final String key) {
	final JSONValue jsonValue = _jsonObject.get(key);
	final JSONString string = jsonValue.isString();
	return string.stringValue();
    }

    protected Long getLong(final String key) {
	final JSONValue jsonValue = _jsonObject.get(key);
	final JSONNumber number = jsonValue.isNumber();
	if (number != null) {
	    final double doubleValue = number.doubleValue();
	    return (long) doubleValue;
	} else {
	    final JSONString string = jsonValue.isString();
	    final String s = string.stringValue();
	    return Long.valueOf(s);
	}
    }

    protected Date getDate(final String key) {
	final JSONValue jsonValue = _jsonObject.get(key);
	final JSONNumber number = jsonValue.isNumber();
	if (number != null) {
	    final long longValue = (long) number.doubleValue();
	    return new Date(longValue);
	} else {
	    final JSONString string = jsonValue.isString();
	    final String s = string.stringValue();
	    return new Date(Long.valueOf(s));
	}
    }

    protected JSONObject getObject(final String key) {
	final JSONValue jsonValue = _jsonObject.get(key);
	if (jsonValue == null)
	    return null;
	return jsonValue.isObject();
    }

    protected boolean getBoolean(final String key) {
	final JSONValue jsonValue = _jsonObject.get(key);
	if (jsonValue == null)
	    return false;
	final JSONBoolean jsonBoolean = jsonValue.isBoolean();
	if (jsonBoolean == null) {
	    final JSONString string = jsonValue.isString();
	    final String str = string.stringValue();
	    final Boolean b = Boolean.valueOf(str);
	    return b;
	}
	return jsonBoolean.booleanValue();
    }

    protected JSONArray getArray(final String key) {
	final JSONValue jsonValue = _jsonObject.get(key);
	if (jsonValue == null)
	    return null;
	JSONArray array = jsonValue.isArray();
	if (array == null) {
	    final JSONObject object = jsonValue.isObject();
	    array = new JSONArray();
	    array.set(0, object);
	}
	return array;
    }

    protected void setString(final String key, final String value) {
	_jsonObject.put(key, new JSONString(value));
    }

    protected void setLong(final String key, final Long value) {
	_jsonObject.put(key, new JSONString(value.toString()));
    }

    protected void setBoolean(final String key, final Boolean value) {
	_jsonObject.put(key, JSONBoolean.getInstance(value));
    }

    @Override
    public String toString() {
	return _jsonObject.toString();
    }

}
