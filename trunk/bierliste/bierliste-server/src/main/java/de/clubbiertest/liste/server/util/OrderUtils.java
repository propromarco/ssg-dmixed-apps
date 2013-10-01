/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.server.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.clubbiertest.liste.shared.SortType;
import de.clubbiertest.liste.shared.SortUtil;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class OrderUtils
{
    public static class BierComparator implements Comparator<Element>
    {
        private final SortType sortType;

        public BierComparator( final SortType sortType )
        {
            this.sortType = sortType;
        }

        @Override public int compare( final Element bier1, final Element bier2 )
        {
            final String name1 = SortUtil.replace(bier1.getAttribute("name"));
            final String name2 = SortUtil.replace(bier2.getAttribute("name"));
            final int nameCompare = name1.compareTo(name2);
            final Double note1 = Double.valueOf(bier1.getAttribute("note").replace(',', '.'));
            final Double note2 = Double.valueOf(bier2.getAttribute("note").replace(',', '.'));
            final int noteCompare = note1.compareTo(note2);
            final Double design1 = Double.valueOf(bier1.getAttribute("design").replace(',', '.'));
            final Double design2 = Double.valueOf(bier2.getAttribute("design").replace(',', '.'));
            final int designCompare = design1.compareTo(design2);
            switch (this.sortType)
            {
            case sortByNameUp:
                if ( nameCompare != 0 )
                {
                    return nameCompare;
                }
                else if ( noteCompare != 0 )
                {
                    return noteCompare;
                }
                else
                {
                    return designCompare;
                }
            case sortByNameDown:
                if ( nameCompare != 0 )
                {
                    return -nameCompare;
                }
                else if ( noteCompare != 0 )
                {
                    return -noteCompare;
                }
                else
                {
                    return -designCompare;
                }
            case sortByNoteUp:
                if ( noteCompare != 0 )
                {
                    return noteCompare;
                }
                else if ( nameCompare != 0 )
                {
                    return nameCompare;
                }
                else
                {
                    return designCompare;
                }
            case sortByNoteDown:
                if ( noteCompare != 0 )
                {
                    return -noteCompare;
                }
                else if ( nameCompare != 0 )
                {
                    return -nameCompare;
                }
                else
                {
                    return -designCompare;
                }
            case sortByDesignUp:
                if ( designCompare != 0 )
                {
                    return designCompare;
                }
                else if ( nameCompare != 0 )
                {
                    return nameCompare;
                }
                else
                {
                    return noteCompare;
                }
            case sortByDesignDown:
                if ( designCompare != 0 )
                {
                    return -designCompare;
                }
                else if ( nameCompare != 0 )
                {
                    return -nameCompare;
                }
                else
                {
                    return -noteCompare;
                }
            }
            return 0;
        }

    }

    public static List<Element> order( final NodeList list, final SortType type )
    {
        final List<Element> liste = new ArrayList<Element>();
        for ( int i = 0; i < list.getLength(); i++ )
        {
            final Element item = (Element) list.item(i);
            liste.add(item);
        }
        Collections.sort(liste, new BierComparator(type));
        return liste;
    }
}
