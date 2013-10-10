/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import de.clubbiertest.client.beans.JSONBier;
import de.clubbiertest.client.beans.JSONItem;
import de.clubbiertest.client.beans.JSONItems;
import de.clubbiertest.liste.shared.AbstractListe;
import de.clubbiertest.liste.shared.Bier;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;
import de.clubbiertest.liste.shared.Uris;

public class StServerCommunicationUtil implements AbstractListe, Uris {
    public static final String TYPE_APPLICATION_JSON = "application/json", CONTENT_TYPE_HEADER = "Content-Type", ACCEPT_HEADER = "Accept";
    public static final String JERSEY = "services";

    private static RequestBuilder createRequestBuilder(final Method method, final String url) {
        final RequestBuilder requestBuilder = new RequestBuilder(method, url);
        requestBuilder.setHeader(ACCEPT_HEADER, TYPE_APPLICATION_JSON);
        requestBuilder.setHeader(CONTENT_TYPE_HEADER, TYPE_APPLICATION_JSON);
        return requestBuilder;
    }

    @Override
    public void getMain(final Async<List<ListItem>> async) {
        final String baseUrl = GWT.getHostPageBaseURL();
        final String url = baseUrl + JERSEY + "/" + LISTE_PATH;
        final RequestBuilder builder = createRequestBuilder(RequestBuilder.GET, url);

        final RequestCallback callback = new RequestCallback() {
            @Override
            public void onError(final Request request, final Throwable exception) {
                async.onError(exception);
            }

            @Override
            public void onResponseReceived(final Request request, final Response response) {
                final String jsonString = response.getText();
                final JSONValue jsonValue = JSONParser.parseStrict(jsonString);
                final JSONObject obj = jsonValue.isObject();
                final JSONArray koo = obj.get("childs").isArray();
                final List<ListItem> application = new ArrayList<ListItem>();
                for (int i = 0; i < koo.size(); i++) {
                    final JSONObject object = koo.get(i).isObject();
                    application.add(new JSONItem(object));
                }
                async.afterCall(application);
            }
        };
        builder.setCallback(callback);
        try {
            builder.send();
        }
        catch (final RequestException e) {
            async.onError(e);
        }
    }

    @Override
    public void call(final String url, final Async<ListeItems> async) {
        final RequestBuilder builder = createRequestBuilder(RequestBuilder.GET, url);

        final RequestCallback callback = new RequestCallback() {
            @Override
            public void onError(final Request request, final Throwable exception) {
                async.onError(exception);
            }

            @Override
            public void onResponseReceived(final Request request, final Response response) {
                final String jsonString = response.getText();
                final JSONValue jsonValue = JSONParser.parseStrict(jsonString);
                final JSONObject obj = jsonValue.isObject();
                final JSONItems items = new JSONItems(obj);
                async.afterCall(items);
            }
        };
        builder.setCallback(callback);
        try {
            builder.send();
        }
        catch (final RequestException e) {
            async.onError(e);
        }
    }

    public void getKontinente(final Async<ListeItems> async) {
        final String baseUrl = GWT.getHostPageBaseURL();
        final String url = baseUrl + JERSEY + "/" + LISTE_PATH + "/" + KONTINENTE_PATH;
        final RequestBuilder builder = createRequestBuilder(RequestBuilder.GET, url);

        final RequestCallback callback = new RequestCallback() {
            @Override
            public void onError(final Request request, final Throwable exception) {
                async.onError(exception);
            }

            @Override
            public void onResponseReceived(final Request request, final Response response) {
                final String jsonString = response.getText();
                final JSONValue jsonValue = JSONParser.parseStrict(jsonString);
                final JSONObject obj = jsonValue.isObject();
                final JSONItems application = new JSONItems(obj);
                async.afterCall(application);
            }
        };
        builder.setCallback(callback);
        try {
            builder.send();
        }
        catch (final RequestException e) {
            async.onError(e);
        }
    }

    @Override
    public void getBier(final String uri, final Async<Bier> async) {
        final RequestBuilder builder = createRequestBuilder(RequestBuilder.GET, uri);

        final RequestCallback callback = new RequestCallback() {
            @Override
            public void onError(final Request request, final Throwable exception) {
                async.onError(exception);
            }

            @Override
            public void onResponseReceived(final Request request, final Response response) {
                final String jsonString = response.getText();
                final JSONValue jsonValue = JSONParser.parseStrict(jsonString);
                final JSONObject obj = jsonValue.isObject();
                async.afterCall(new JSONBier(obj));
            }
        };
        builder.setCallback(callback);
        try {
            builder.send();
        }
        catch (final RequestException e) {
            async.onError(e);
        }
    }

    @Override
    public void search(final String uri, final Async<ListeItems> async) {
        final String baseUrl = GWT.getHostPageBaseURL();
        final String url = baseUrl + JERSEY + "/" + LISTE_PATH + "/" + SEARCH_PATH + "/" + uri;
        final RequestBuilder builder = createRequestBuilder(RequestBuilder.GET, url);

        final RequestCallback callback = new RequestCallback() {
            @Override
            public void onError(final Request request, final Throwable exception) {
                async.onError(exception);
            }

            @Override
            public void onResponseReceived(final Request request, final Response response) {
                final String jsonString = response.getText();
                final JSONValue jsonValue = JSONParser.parseStrict(jsonString);
                final JSONObject obj = jsonValue.isObject();
                final JSONItems application = new JSONItems(obj);
                async.afterCall(application);
            }
        };
        builder.setCallback(callback);
        try {
            builder.send();
        }
        catch (final RequestException e) {
            async.onError(e);
        }
    }
}
