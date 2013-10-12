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
        final Element el = anchor._element;
        el.setInnerHTML(name);
        getElement().appendChild(el);
        el.setId(name);
    }

    public void select(final String name) {
        final int childCount = getElement().getChildCount();
        for (int index = 0; index < childCount; index++) {
            final Element child = (Element) getElement().getChild(index);
            final String id = child.getId();
            if (id.equals(name)) {
                child.addClassName(_clubbiertestCss.selected());
            }
            else {
                child.removeClassName(_clubbiertestCss.selected());
            }
        }
    }

}
