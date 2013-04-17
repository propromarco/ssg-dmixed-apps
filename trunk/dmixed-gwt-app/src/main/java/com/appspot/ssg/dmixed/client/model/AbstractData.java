package com.appspot.ssg.dmixed.client.model;

import java.util.Date;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class AbstractData {
    protected final JSONObject _jsonObject;

    public AbstractData() {
        _jsonObject = new JSONObject();
    }

    public AbstractData(JSONObject jsonObject) {
        _jsonObject = jsonObject;
    }

    protected String getString(String key) {
        JSONValue jsonValue = _jsonObject.get(key);
        JSONString string = jsonValue.isString();
        return string.stringValue();
    }

    protected Long getLong(String key) {
        JSONValue jsonValue = _jsonObject.get(key);
        JSONNumber number = jsonValue.isNumber();
        if (number != null) {
            double doubleValue = number.doubleValue();
            return (long) doubleValue;
        }
        else {
            JSONString string = jsonValue.isString();
            String s = string.stringValue();
            return Long.valueOf(s);
        }
    }

    protected Date getDate(String key) {
        JSONValue jsonValue = _jsonObject.get(key);
        JSONNumber number = jsonValue.isNumber();
        if (number != null) {
            long longValue = (long) number.doubleValue();
            return new Date(longValue);
        }
        else {
            JSONString string = jsonValue.isString();
            String s = string.stringValue();
            return new Date(Long.valueOf(s));
        }
    }

    protected boolean getBoolean(String key) {
        JSONValue jsonValue = _jsonObject.get(key);
        JSONBoolean jsonBoolean = jsonValue.isBoolean();
        return jsonBoolean.booleanValue();
    }

    protected JSONArray getArray(String key) {
        JSONValue jsonValue = _jsonObject.get(key);
        JSONArray array = jsonValue.isArray();
        if(array == null){
            JSONObject object = jsonValue.isObject();
            array = new JSONArray();
            array.set(0, object);
        }
        return array;
    }

    protected void setString(String key, String value) {
        _jsonObject.put(key, new JSONString(value));
    }

    protected void setBoolean(String key, Boolean value) {
        _jsonObject.put(key, JSONBoolean.getInstance(value));
    }

    @Override
    public String toString() {
        return _jsonObject.toString();
    }

}