/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListenActivity extends Activity
{
    public static final String PARAMETER = "ListenParameter";

    private ListView listView;

    /** Called when the activity is first created. */
    @Override public void onCreate( final Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste);
        final ListeItem item = (ListeItem) getIntent().getSerializableExtra(PARAMETER);
        final String title = item.getName();
        setTitle(title);
        final String search = item.getSearch();
        this.listView = (ListView) findViewById(R.id.liste);
        this.listView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick( final AdapterView<?> adapterView, final View view, final int position, final long id )
            {
                final ListeItem item = (ListeItem) adapterView.getItemAtPosition(position);
                if ( item.isBier() )
                {
                    final Intent intent = new Intent(ListenActivity.this, BierinfoActivity.class);
                    intent.putExtra(BierinfoActivity.PARAMETER, item.getName());
                    startActivity(intent);
                }
                else
                {
                    final Intent intent = new Intent(ListenActivity.this, ListenActivity.class);
                    intent.putExtra(ListenActivity.PARAMETER, item);
                    startActivity(intent);
                }
            }
        });
        loadListe(PARAMETER, item.getUri(), search);
    }

    private void loadListe( final String... objects )
    {
        final ListeTask task = new ListeTask(this, this.listView);
        task.execute(objects);
    }
}
