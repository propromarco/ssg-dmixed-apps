package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.AView;
import com.google.msc.framework.client.mvp.Slot;

import de.clubbiertest.client.ClubbiertestCss;

public class CBTMainView extends AView {

    private final Slot sidebarSlot;
    private final Slot contentSlot;
    private final Slot bierSlot;
    private final Slot headerSlot;

    public CBTMainView(final ClubbiertestCss clubbiertestCss) {
        setStyleName(clubbiertestCss.main());
        headerSlot = createSlot("header");
        add(headerSlot);
        sidebarSlot = createSlot("sidebar");
        add(sidebarSlot);
        contentSlot = createSlot("content");
        add(contentSlot);
        bierSlot = createSlot("bier");
        add(bierSlot);
    }

    public Slot getSidebarSlot() {
        return sidebarSlot;
    }

    public Slot getContentSlot() {
        return contentSlot;
    }

    public Slot getBierSlot() {
        return bierSlot;
    }

    public Slot getHeaderSlot() {
        return headerSlot;
    }

}
