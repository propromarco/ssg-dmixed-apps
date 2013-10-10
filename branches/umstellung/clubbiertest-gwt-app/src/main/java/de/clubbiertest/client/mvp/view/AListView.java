package de.clubbiertest.client.mvp.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Anchor;
import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.liste.shared.ListItem;

public class AListView extends AView implements ClickHandler {

    protected final ClubbiertestCss _clubbiertestCss;
    private HandlerRegistration registry;

    public AListView(final ClubbiertestCss clubbiertestCss) {
        _clubbiertestCss = clubbiertestCss;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        registry = addDomHandler(this, ClickEvent.getType());
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        registry.removeHandler();
    }

    public void clearItems() {
        clear();
    }

    public void addItem(final ListItem listItem) {
        final String name = listItem.getName();
        final Anchor anchor = new Anchor();
        final Element span = DOM.createSpan();
        span.setInnerHTML(name);
        anchor.getElement().appendChild(span);
        add(anchor);
    }

    @Override
    public void onClick(final ClickEvent event) {
        final Object source = event.getSource();
        // TODO Auto-generated method stub
        System.out.println();
    }

}
