package de.clubbiertest.client.mvp.view;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HTML;
import com.google.msc.framework.client.mvp.AView;
import com.google.msc.framework.client.widgets.SearchField;
import com.google.msc.framework.client.widgets.SearchField.ISearchFieldDesign;

import de.clubbiertest.client.ClubbiertestCss;

public class CBTHeaderView extends AView {

    private final HTML navigationInfo;
    private final SearchField searchField;

    public CBTHeaderView(final ClubbiertestCss clubbiertestCss, final ISearchFieldDesign searchFieldDesign) {
        setStyleName(clubbiertestCss.mainheader());
        this.navigationInfo = new HTML();
        this.navigationInfo.setStyleName(clubbiertestCss.navigationinfo());
        add(navigationInfo);
        this.searchField = new SearchField(searchFieldDesign);
        add(searchField);
    }

    public void setNavigationText(final String text) {
        this.navigationInfo.setHTML(text);
    }

    public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
        return searchField.addChangeHandler(handler);
    }

    public String getSearchText() {
        return searchField.getSearchText();
    }

}
