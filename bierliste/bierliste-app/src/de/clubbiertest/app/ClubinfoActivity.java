/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.app;

import android.app.Activity;

import android.os.Bundle;

import android.webkit.WebView;

public class ClubinfoActivity extends Activity
{
    @Override public void onCreate( final Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clubinfo);
        final WebView webView = (WebView) findViewById(R.id.clubinfoWebView);
        webView.loadUrl("http://bierliste.appspot.com/info.html");
//        webView.loadData(readTextFromResource(R.raw.info), "text/html", "utf-8");
    }

//    private String readTextFromResource( final int resourceID )
//    {
//        final InputStream raw = getResources().openRawResource(resourceID);
//        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        int i;
//        try
//        {
//            i = raw.read();
//            while ( i != -1 )
//            {
//                stream.write(i);
//                i = raw.read();
//            }
//            raw.close();
//        }
//        catch ( final IOException e )
//        {
//            e.printStackTrace();
//        }
//        return stream.toString();
//    }
}
