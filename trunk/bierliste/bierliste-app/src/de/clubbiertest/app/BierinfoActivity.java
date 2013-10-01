/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app;

import android.app.Activity;

import android.graphics.Color;
import android.graphics.Typeface;

import android.os.Bundle;

import android.view.ViewGroup.LayoutParams;

import android.widget.LinearLayout;
import android.widget.TextView;

public class BierinfoActivity extends Activity
{
    protected static final String PARAMETER = "BIERINFOPARAMETER";
    private LinearLayout bierinfoLayout;

    @Override public void onCreate( final Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bierinfo);
        final String bier = getIntent().getStringExtra(PARAMETER);
        this.bierinfoLayout = (LinearLayout) findViewById(R.id.bierinfoLayout);
        final BierinfoTask bierinfoTask = new BierinfoTask(this);
        bierinfoTask.execute(bier);
    }

    public void setInfo( final ListeItem result )
    {
        final String name = result.getName();
        final String land = result.getLand();
        final String sorte = result.getSorte();
        final Double note = result.getNote();
        final Double design = result.getDesign();
        // Infos gelesen
        setTitle(name);
        {
            final LinearLayout lcontainer = createContainer(R.string.bierland, land);
            this.bierinfoLayout.addView(lcontainer);
        }
        if ( sorte != null )
        {
            final LinearLayout container = createContainer(R.string.biersorte, sorte);
            this.bierinfoLayout.addView(container);
        }
        {
            final LinearLayout container = createContainer(R.string.biername, name);
            this.bierinfoLayout.addView(container);
        }
        if ( note > 0 )
        {
            final LinearLayout container = createContainer(R.string.biernote, note.toString());
            this.bierinfoLayout.addView(container);
        }
        if ( design > 0 )
        {
            final LinearLayout container = createContainer(R.string.bierdesign, design.toString());
            this.bierinfoLayout.addView(container);
        }
        if (( design <= 0 ) && ( note <= 0 ))
        {
            final LinearLayout container = createContainer(R.string.biernichtgetestet, null);
            this.bierinfoLayout.addView(container);
        }
    }

    private LinearLayout createContainer( final int resid, final CharSequence text )
    {
        final LinearLayout container = new LinearLayout(this);
        final int padding = 3;
        container.setPadding(padding, padding, 0, padding);
        if ( text != null )
        {
            final TextView desc = new TextView(this);
            {
                final LayoutParams layoutParams = new LayoutParams(100, LayoutParams.WRAP_CONTENT);
                desc.setLayoutParams(layoutParams);
            }
            desc.setTypeface(null, Typeface.BOLD);
            desc.setText(resid);
            container.addView(desc);
        }
        if ( text != null )
        {
            final TextView desc = new TextView(this);
            desc.setText(text);
            container.addView(desc);
        }
        if ( text == null )
        {
            final TextView desc = new TextView(this);
            desc.setTextColor(Color.rgb(0, 153, 218));
            desc.setTypeface(null, Typeface.BOLD);
            desc.setText(resid);
            desc.setPadding(20, 3, 3, 3);
            container.addView(desc);
        }
        return container;
    }
}
