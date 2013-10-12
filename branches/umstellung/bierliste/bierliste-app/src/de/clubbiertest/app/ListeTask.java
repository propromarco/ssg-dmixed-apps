/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;

import android.content.Context;

import android.os.AsyncTask;

import android.widget.ListView;

import de.clubbiertest.app.liste.JSONReader;

public class ListeTask extends AsyncTask<String, Object, List<ListeItem>>
{
    private final Context context;
    private final ListView listView;
    private final ProgressDialog progressDialog;

    public ListeTask( final Context context, final ListView listView )
    {
        super();
        this.progressDialog = new ProgressDialog(context);
        this.progressDialog.setMessage("Lade Daten. Bitte warten...");
        this.context = context;
        this.listView = listView;
    }

    @Override protected void onPreExecute()
    {
        this.progressDialog.show();
    }

    @Override protected void onPostExecute( final List<ListeItem> result )
    {
        this.listView.setAdapter(new ListeAdapter(this.context, result));
        this.progressDialog.cancel();
    }

    @Override protected List<ListeItem> doInBackground( final String... params )
    {
        final List<ListeItem> liste = new ArrayList<ListeItem>();
        try
        {
            final JSONReader reader = JSONReader.getInstance();
            final String uri = params[1];
            final String search = params[2];
            if ( isBlankOrNull(search) )
            {
                reader.parseUri(uri, liste);
            }
            else
            {
                reader.parseSearchListe(uri, search, liste);
            }
        }
        catch ( final Exception e )
        {
            e.printStackTrace();
        }
        return liste;
    }

    private boolean isBlankOrNull( final String search )
    {
        if ( search == null )
        {
            return true;
        }
        if ( search.length() == 0 )
        {
            return true;
        }
        if ( search.trim().length() == 0 )
        {
            return true;
        }
        return false;
    }
}
