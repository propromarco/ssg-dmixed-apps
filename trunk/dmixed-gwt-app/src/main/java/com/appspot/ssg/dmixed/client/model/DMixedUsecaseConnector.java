package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILoginData;
import com.appspot.ssg.dmixed.shared.IMitbringData;
import com.appspot.ssg.dmixed.shared.ITeilnahmeData;
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

    public DMixedUsecaseConnector(final String baseUrl) {
        _baseUrl = baseUrl;
    }

    @Override
    public void login(final ILoginData data, final IAsync<IUserData> answer) {
        final String url = getServiceUrl();
        final RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.POST);
        final String requestData = data.toString();
        final IAsync<JSONObject> newAnswer = new IAsync<JSONObject>() {
            @Override
            public void onSuccess(final JSONObject object) {
                final UserData userData = new UserData(object);
                answer.onSuccess(userData);
            }
        };
        executePost(requestBuilder, requestData, newAnswer);
    }

    @Override
    public void getTermine(final Long userId, final IAsync<ITermine> answer) {
        final String url = getServiceUrl() + "/termine/" + userId;
        final RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.GET);
        final IAsync<JSONObject> newAnswer = new IAsync<JSONObject>() {
            @Override
            public void onSuccess(final JSONObject object) {
                final Termine userData = new Termine(object);
                answer.onSuccess(userData);
            }
        };
        executeGet(requestBuilder, newAnswer);
    }

    @Override
    public void getTermin(final Long userId, final Long terminId, final IAsync<ITerminDetails> answer) {
        final String url = getServiceUrl() + "/termin/" + userId + "/" + terminId;
        final RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.GET);
        final IAsync<JSONObject> newAnswer = new IAsync<JSONObject>() {
            @Override
            public void onSuccess(final JSONObject object) {
                final TerminDetails userData = new TerminDetails(object);
                answer.onSuccess(userData);
            }
        };
        executeGet(requestBuilder, newAnswer);
    }

    @Override
    public void onTeilnahme(final ITeilnahmeData data, final IAsync<Void> answer) {
        final String url = getServiceUrl() + "/teilnahme";
        final RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.PUT);
        final String requestData = data.toString();
        executePut(requestBuilder, requestData, answer);
    }

    @Override
    public void onMitringen(final IMitbringData data, final IAsync<Void> answer) {
        final String url = getServiceUrl() + "/mitbringen";
        final RequestBuilder requestBuilder = createRequestBuilder(url, RequestBuilder.PUT);
        final String requestData = data.toString();
        executePut(requestBuilder, requestData, answer);
    }

    protected String getServiceUrl() {
        final String url = _baseUrl + "rest/dmixed";
        return url;
    }

    protected RequestBuilder createRequestBuilder(final String url, final Method method) {
        final RequestBuilder requestBuilder = new RequestBuilder(method, url);
        requestBuilder.setHeader("Content-Type", APPLICATION_JSON);
        requestBuilder.setHeader("Accept", APPLICATION_JSON);
        return requestBuilder;
    }

    protected JSONObject toObject(final String text) {
        try {
            final JSONValue parseStrict = JSONParser.parseStrict(text);
            final JSONObject object = parseStrict.isObject();
            return object;
        }
        catch (final Exception e) {
            return null;
        }
    }

    protected void executePost(final RequestBuilder requestBuilder, final String requestData, final IAsync<JSONObject> answer) {
        // Mobile.showLoadingDialog("Loading...");
        final RequestCallback callback = new RequestCallback() {
            @Override
            public void onResponseReceived(final Request request, final Response response) {
                final JSONObject object = toObject(response.getText());
                answer.onSuccess(object);
                // Mobile.hideLoadingDialog();
            }

            @Override
            public void onError(final Request request, final Throwable exception) {
                exception.printStackTrace();
                // Mobile.hideLoadingDialog();
            }
        };
        try {
            requestBuilder.sendRequest(requestData, callback);
        }
        catch (final RequestException e) {
            e.printStackTrace();
        }
    }

    protected void executePut(final RequestBuilder requestBuilder, final String requestData, final IAsync<Void> answer) {
        // Mobile.showLoadingDialog("Loading...");
        final RequestCallback callback = new RequestCallback() {
            @Override
            public void onResponseReceived(final Request request, final Response response) {
                answer.onSuccess(null);
                // Mobile.hideLoadingDialog();
            }

            @Override
            public void onError(final Request request, final Throwable exception) {
                exception.printStackTrace();
                // Mobile.hideLoadingDialog();
            }
        };
        try {
            requestBuilder.sendRequest(requestData, callback);
        }
        catch (final RequestException e) {
            e.printStackTrace();
        }
    }

    public void executeGet(final RequestBuilder requestBuilder, final IAsync<JSONObject> answer) {
        // Mobile.showLoadingDialog("Loading...");
        final RequestCallback callback = new RequestCallback() {

            @Override
            public void onResponseReceived(final Request request, final Response response) {
                final JSONObject object = toObject(response.getText());
                answer.onSuccess(object);
                // Mobile.hideLoadingDialog();
            }

            @Override
            public void onError(final Request request, final Throwable exception) {
                exception.printStackTrace();
                // Mobile.hideLoadingDialog();
            }
        };
        requestBuilder.setCallback(callback);
        try {
            requestBuilder.send();
        }
        catch (final RequestException e) {
            e.printStackTrace();
        }
    }

}
