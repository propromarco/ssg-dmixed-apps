package de.clubbiertest.client.mvp.view;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.liste.shared.ListItem;

public class AListView extends AView {

    public interface IClick {
        void onClick(int absoluteTop, int absoluteLeft);
    }

    private static class ClickableAnchor implements EventListener {
        private final Element _element;
        private final IClick _click;

        public ClickableAnchor(final IClick click) {
            _click = click;
            _element = DOM.createAnchor();
            DOM.sinkEvents(_element, Event.ONCLICK);
            DOM.setEventListener(_element, this);
        }

        @Override
        public void onBrowserEvent(final Event event) {
            event.stopPropagation();
            final int absoluteLeft = _element.getAbsoluteLeft();
            final int absoluteTop = _element.getAbsoluteTop();
            _click.onClick(absoluteTop, absoluteLeft);
        }
    }

    protected final ClubbiertestCss _clubbiertestCss;

    public AListView(final ClubbiertestCss clubbiertestCss) {
        _clubbiertestCss = clubbiertestCss;
    }

    public void clearItems() {
        clear();
    }

    public void addItem(final ListItem listItem, final IClick click) {
        final String name = listItem.getName();
        final ClickableAnchor anchor = new ClickableAnchor(click);
        anchor._element.setInnerHTML(name);
        getElement().appendChild(anchor._element);
    }

}
