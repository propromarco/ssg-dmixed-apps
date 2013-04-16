package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILoginData;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class DMixedUsecaseConnector implements IDMixedUsecase {

    private final static String APPLICATION_JSON = "application/json";
    private final String _baseUrl;

    public DMixedUsecaseConnector(String baseUrl) {
        _baseUrl = baseUrl;
    }

    @Override
    public void login(ILoginData data, final IAsync<IUserData> answer) {
        String url = getServiceUrl();
        RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.POST);
        String requestData = data.toString();
        RequestCallback callback = new RequestCallback() {
            @Override
            public void onResponseReceived(Request request, Response response) {
                JSONObject object = toObject(response.getText());
                UserData userData = new UserData(object);
                answer.onSuccess(userData);
            }

            @Override
            public void onError(Request request, Throwable exception) {
                exception.printStackTrace();
            }
        };
        try {
            requestBuilder.sendRequest(requestData, callback);
        }
        catch (RequestException e) {
            e.printStackTrace();
        }
    }

    protected String getServiceUrl() {
        String url = _baseUrl + "rest/dmixed";
        return url;
    }

    protected RequestBuilder createRequestBuilder(String url, Method method) {
        RequestBuilder requestBuilder = new RequestBuilder(method, url);
        requestBuilder.setHeader("Content-Type", APPLICATION_JSON);
        requestBuilder.setHeader("Accept", APPLICATION_JSON);
        return requestBuilder;
    }

    protected JSONObject toObject(String text) {
        JSONValue parseStrict = JSONParser.parseStrict(text);
        JSONObject object = parseStrict.isObject();
        return object;
    }

    @Override
    public void termine(Long userId, final IAsync<ITermine> answer) {
        String url = getServiceUrl() + "/termine/" + userId;
        RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.GET);
        RequestCallback callback = new RequestCallback() {

            @Override
            public void onResponseReceived(Request request, Response response) {
                JSONObject object = toObject(response.getText());
                Termine userData = new Termine(object);
                answer.onSuccess(userData);
            }

            @Override
            public void onError(Request request, Throwable exception) {
                exception.printStackTrace();
            }
        };
        requestBuilder.setCallback(callback);
        try {
            requestBuilder.send();
        }
        catch (RequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void termin(Long userId, Long terminId, final IAsync<ITerminDetails> answer) {
        String url = getServiceUrl() + "termin/" + userId + "/" + terminId;
        RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.GET);
        RequestCallback callback = new RequestCallback() {

            @Override
            public void onResponseReceived(Request request, Response response) {
                JSONObject object = toObject(response.getText());
                TerminDetails userData = new TerminDetails(object);
                answer.onSuccess(userData);
            }

            @Override
            public void onError(Request request, Throwable exception) {
                exception.printStackTrace();
            }
        };
        requestBuilder.setCallback(callback);
        try {
            requestBuilder.send();
        }
        catch (RequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void teilname(Long userId, Long terminId, Boolean teilnahme, IAsync<ITerminDetails> answer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mitringen(Long userId, Long terminId, Long mitbringId, Boolean mitbringen, IAsync<ITerminDetails> answer) {
        // TODO Auto-generated method stub

    }

}
