/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import de.clubbiertest.liste.shared.Uris;

public class WelcomeActivity extends Activity implements OnClickListener
{
    private static final String bierserver = "http://bierliste.appspot.com/services/";

    /** Called when the activity is first created. */
    @Override public void onCreate( final Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        {
            // die Bestenliste
            final Button button = (Button) findViewById(R.id.dieBesten);
            button.setOnClickListener(this);
        }
        {
            // komplette Liste
            final Button button = (Button) findViewById(R.id.kompletteListe);
            button.setOnClickListener(this);
        }
        {
            // About
            final Button button = (Button) findViewById(R.id.about);
            button.setOnClickListener(this);
        }
        {
            // About
            final EditText editText = (EditText) findViewById(R.id.searchText);
            editText.setOnEditorActionListener(new OnEditorActionListener()
            {
                public boolean onEditorAction( final TextView v, final int actionId, final KeyEvent event )
                {
                    if ( EditorInfo.IME_ACTION_DONE == actionId )
                    {
                        final Intent intent = new Intent(WelcomeActivity.this, ListenActivity.class);
                        final ListeItem item = new ListeItem(getString(R.string.suchErgebnis));
                        item.setUri(getSearchUri());
                        item.setSearch(editText.getText().toString());
                        intent.putExtra(ListenActivity.PARAMETER, item);
                        startActivity(intent);
                    }
                    return false;
                }

            });
        }
    }

    public void onClick( final View view )
    {
        final int id = view.getId();
        Intent intent = null;
        if ( id == R.id.dieBesten )
        {
            intent = new Intent(WelcomeActivity.this, ListenActivity.class);
            final ListeItem item = new ListeItem(getString(R.string.bestenListe));
            item.setUri(getBestenlisteUri());
            intent.putExtra(ListenActivity.PARAMETER, item);
        }
        else if ( id == R.id.kompletteListe )
        {
            intent = new Intent(WelcomeActivity.this, ListenActivity.class);
            final ListeItem item = new ListeItem(getString(R.string.kontinente));
            item.setUri(getKontinenteUri());
            intent.putExtra(ListenActivity.PARAMETER, item);
        }
        else if ( id == R.id.about )
        {
            intent = new Intent(WelcomeActivity.this, ClubinfoActivity.class);
        }
        startActivity(intent);
    }

    private String getBestenlisteUri()
    {
        return bierserver + Uris.LISTE_PATH + "/" + Uris.BESTENLISTE_PATH;
    }

    private String getKontinenteUri()
    {
        return bierserver + Uris.LISTE_PATH + "/" + Uris.KONTINENTE_PATH;
    }

    private String getSearchUri()
    {
        return bierserver + Uris.LISTE_PATH + "/" + Uris.SEARCH_PATH + "/";
    }
}
