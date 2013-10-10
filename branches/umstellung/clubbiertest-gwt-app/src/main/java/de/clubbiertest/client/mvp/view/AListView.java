package de.clubbiertest.client.mvp.view;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Anchor;
import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.liste.shared.ListItem;

public class AListView extends AView {

    protected final ClubbiertestCss _clubbiertestCss;

    public AListView(final ClubbiertestCss clubbiertestCss) {
        _clubbiertestCss = clubbiertestCss;
    }

    public void clearItems() {
        clear();
    }

    public void addItem(final ListItem listItem, final ClickHandler handler) {
        final String name = listItem.getName();
        final Anchor anchor = new Anchor();
        anchor.addClickHandler(handler);
        final Element span = DOM.createSpan();
        span.setInnerHTML(name);
        anchor.getElement().appendChild(span);
        add(anchor);
    }

}
