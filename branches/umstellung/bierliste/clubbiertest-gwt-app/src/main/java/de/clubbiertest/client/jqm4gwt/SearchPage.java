///* Copyright, (c) 2012 Suretec GmbH  */
//
//package de.clubbiertest.client.jqm4gwt;
//
//import com.google.gwt.user.client.Window;
//
//import de.clubbiertest.client.ClubbiertestTexte;
//import de.clubbiertest.client.StServerCommunicationUtil;
//import de.clubbiertest.liste.shared.AbstractListe.Async;
//import de.clubbiertest.liste.shared.ListeItems;
//
//public class SearchPage extends AbstractListePage
//{
//    public SearchPage( final Before before, final StServerCommunicationUtil util )
//    {
//        super(before, util);
//        this.header.setText(ClubbiertestTexte.TEXTE.suchergebnis());
//    }
//
//    /**
//     * Getter for property searchText.
//     * @return the value of property searchText
//     */
//    public String getSearchText()
//    {
//        return this.before.getName();
//    }
//
//    /**
//     * Setter for property searchText
//     * @param searchText the new value for property searchText to set.
//     */
//    public void setSearchText( final String searchText )
//    {
//        this.before.setName(searchText);
//    }
//
//    @Override protected void loadPage( final After after )
//    {
//        final Async<ListeItems> async = new Async<ListeItems>()
//        {
//            @Override public void onError( final Throwable exception )
//            {
//                Window.alert(exception.getMessage());
//            }
//
//            @Override public void afterCall( final ListeItems result )
//            {
//                fillList(result);
//                after.onComplete();
//            }
//        };
//        this.util.search(this.before.getName(), async);
//    }
//}
