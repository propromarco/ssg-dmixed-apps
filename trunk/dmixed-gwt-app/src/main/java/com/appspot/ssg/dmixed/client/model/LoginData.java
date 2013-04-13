package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ILoginData;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class LoginData implements ILoginData {

    private static final long serialVersionUID = 7042074774688530376L;
    
    private final JSONObject _jsonObject;

    public LoginData() {
        _jsonObject = new JSONObject();
    }

    public LoginData(String username, String password) {
        _jsonObject = new JSONObject();
        _jsonObject.put("username", new JSONString(username));
        _jsonObject.put("password", new JSONString(password));
    }

    @Override
    public String getUsername() {
        JSONValue jsonValue = _jsonObject.get("username");
        JSONString string = jsonValue.isString();
        return string.stringValue();
    }

    @Override
    public String getPassword() {
        JSONValue jsonValue = _jsonObject.get("password");
        JSONString string = jsonValue.isString();
        return string.stringValue();
    }

}
