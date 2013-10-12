/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.shared;

import java.util.List;

public interface AbstractListe
{
    public interface Async<T>
    {
        void onError( Throwable exception );

        void afterCall( final T result );
    }

    void getMain( Async<List<ListItem>> async );

    void getBier( String bier, Async<Bier> async );

    void call( String uri, Async<ListeItems> async );

    void search( String uri, Async<ListeItems> async );
}
