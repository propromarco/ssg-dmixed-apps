/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.app;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class ListeAdapter extends BaseAdapter implements SectionIndexer
{
    private final Context context;
    private final List<ListeItem> items;

    Map<String, Integer> alphaIndexer;
    String[] sections;

    public ListeAdapter( Context context, List<ListeItem> items )
    {
        this.context = context;
        this.items = items;

        alphaIndexer = new LinkedHashMap<String, Integer>();
        int size = items.size();

        for ( int x = 0; x < size; x++ )
        {
            ListeItem s = items.get(x);

            // get the first letter of the store
            String ch = s.getReplacedName().substring(0, 1);

            // convert to uppercase otherwise lowercase a -z will be sorted after upper A-Z
            ch = ch.toUpperCase();

            // HashMap will prevent duplicates
            if ( !alphaIndexer.containsKey(ch) )
            {
                alphaIndexer.put(ch, x);
            }
        }

        Set<String> sectionLetters = alphaIndexer.keySet();

        sections = new String[sectionLetters.size()];

        sectionLetters.toArray(sections);
    }

    public int getCount()
    {
        return items.size();
    }

    public Object getItem( int position )
    {
        return items.get(position);
    }

    public long getItemId( int position )
    {
        return items.get(position).getId();
    }

    public View getView( int position, View convertView, ViewGroup parent )
    {
        ListeItem item = items.get(position);
        final TextView textView;
        if ( convertView == null )
        {
            textView = new TextView(context);
            textView.setPadding(10, 10, 10, 10);
            textView.setTextSize(20f);
        }
        else
        {
            textView = (TextView) convertView;
        }
        String name = item.getName();
        Integer childSize = item.getChildSize();
        if ( childSize != null )
        {
            name += " (" + childSize + ")";
        }
        textView.setText(name);
        return textView;
    }

    public int getPositionForSection( int section )
    {
        String sectionString = sections[section];
        Integer position = alphaIndexer.get(sectionString);
        return position;
    }

    public int getSectionForPosition( int position )
    {
        ListeItem item = items.get(position);
        String ch = item.getReplacedName().substring(0, 1).toUpperCase();
        for ( int i = 0; i < sections.length; i++ )
        {
            String section = sections[i];
            if ( section.equals(ch) )
            {
                return i;
            }
        }
        return 1;
    }

    public Object[] getSections()
    {
        return sections;
    }
}
