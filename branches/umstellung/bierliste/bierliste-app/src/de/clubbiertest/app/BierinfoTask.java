/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app;

import android.app.ProgressDialog;

import android.os.AsyncTask;

import de.clubbiertest.app.liste.JSONReader;

public class BierinfoTask extends AsyncTask<String, Object, ListeItem>
{
    private final BierinfoActivity bierinfoActivity;
    private final ProgressDialog progressDialog;

    public BierinfoTask( final BierinfoActivity bierinfoActivity )
    {
        this.progressDialog = new ProgressDialog(bierinfoActivity);
        this.progressDialog.setMessage("Lade Daten. Bitte warten...");
        this.bierinfoActivity = bierinfoActivity;
    }

    @Override protected void onPreExecute()
    {
        this.progressDialog.show();
    }

    @Override protected void onPostExecute( final ListeItem result )
    {
        this.bierinfoActivity.setInfo(result);
        this.progressDialog.cancel();
    }

    @Override protected ListeItem doInBackground( final String... params )
    {
        final ListeItem item = JSONReader.getInstance().parseBier(params[0]);
        return item;
    }
}
