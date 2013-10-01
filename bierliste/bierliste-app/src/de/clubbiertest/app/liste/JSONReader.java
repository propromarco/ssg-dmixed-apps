/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app.liste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URLEncoder;

import java.util.List;

import android.util.Log;

import de.clubbiertest.app.ListeItem;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONReader
{
    private static JSONReader instance;

    private JSONReader()
            throws IOException, JSONException
    {
    }

    public static JSONReader getInstance()
    {
        if ( instance == null )
        {
            try
            {
                instance = new JSONReader();
            }
            catch ( final Exception e )
            {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private String readJSON( final String url )
    {
        final StringBuilder builder = new StringBuilder();
        final HttpClient client = new DefaultHttpClient();
        final String replaceAll = url.replaceAll("\\+", "%20");
        final HttpGet httpGet = new HttpGet(replaceAll);
        try
        {
            final HttpResponse response = client.execute(httpGet);
            final StatusLine statusLine = response.getStatusLine();
            final int statusCode = statusLine.getStatusCode();
            if ( statusCode == 200 )
            {
                final HttpEntity entity = response.getEntity();
                final InputStream content = entity.getContent();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while (( line = reader.readLine() ) != null )
                {
                    builder.append(line);
                }
            }
        }
        catch ( final ClientProtocolException e )
        {
            e.printStackTrace();
        }
        catch ( final IOException e )
        {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public ListeItem parseBier( final String targetName )
    {
        try
        {
            final String json = readJSON("http://bierliste.appspot.com/services/bierliste/bier/" + URLEncoder.encode(targetName, "utf-8"));
            final JSONObject jsonBier = new JSONObject(json);
            final ListeItem item = new ListeItem(jsonBier.getString("name"));
            item.setNote(jsonBier.getDouble("note"));
            item.setDesign(jsonBier.getDouble("design"));
            item.setLand(jsonBier.getString("land"));
            if ( jsonBier.has("sorte") )
            {
                item.setSorte(jsonBier.getString("sorte"));
            }
            return item;
        }
        catch ( final Exception e1 )
        {
            Log.e(JSONReader.class.getName(), e1.getMessage(), e1);
            return null;
        }

    }

    public void parseSearchListe( final String uri, final String searchString, final List<ListeItem> liste )
    {
        final String json = readJSON(uri + URLEncoder.encode(searchString));
        try
        {
            final JSONObject bestenliste = new JSONObject(json);
            if ( bestenliste.has("childs") )
            {
                final JSONArray bestof = bestenliste.getJSONArray("childs");
                final int length = bestof.length();
                for ( int index = 0; index < length; index++ )
                {
                    final JSONObject bier = bestof.getJSONObject(index);
                    final ListeItem item = new ListeItem(bier.getString("name"));
                    item.setUri(bier.getString("uri"));
                    item.setBier(bier.getBoolean("bier"));
                    liste.add(item);
                }
            }
        }
        catch ( final JSONException e1 )
        {
            Log.e(JSONReader.class.getName(), e1.getMessage(), e1);
        }
    }

    public void parseUri( final String uri, final List<ListeItem> liste )
    {
        try
        {
            final String json = readJSON(uri);
            final JSONObject bestenliste = new JSONObject(json);
            final JSONArray bestof = bestenliste.getJSONArray("childs");
            final int length = bestof.length();
            for ( int index = 0; index < length; index++ )
            {
                final JSONObject bier = bestof.getJSONObject(index);
                final ListeItem item = new ListeItem(bier.getString("name"));
                item.setBier(bier.getBoolean("bier"));
                item.setUri(bier.getString("uri"));
                liste.add(item);
            }
        }
        catch ( final JSONException e1 )
        {
            Log.e(JSONReader.class.getName(), e1.getMessage(), e1);
        }

    }
}
