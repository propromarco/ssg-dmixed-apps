package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILoginData;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
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
        String url = _baseUrl + "rest/dmixed";
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url);
        requestBuilder.setHeader("Content-Type", APPLICATION_JSON);
        requestBuilder.setHeader("Accept", APPLICATION_JSON);
        String requestData = ((LoginData) data).toString();
        RequestCallback callback = new RequestCallback() {

            @Override
            public void onResponseReceived(Request request, Response response) {
                String text = response.getText();
                JSONValue parseStrict = JSONParser.parseStrict(text);
                JSONObject object = parseStrict.isObject();
                UserData userData = new UserData(object);
                answer.onSuccess(userData);
            }

            @Override
            public void onError(Request request, Throwable exception) {
                // TODO Auto-generated method stub
                exception.printStackTrace();
            }
        };
        try {
            requestBuilder.sendRequest(requestData, callback);
        }
        catch (RequestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void termine(Long userId, IAsync<ITermine> answer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void termin(Long userId, Long terminId, IAsync<ITerminDetails> answer) {
        // TODO Auto-generated method stub

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
