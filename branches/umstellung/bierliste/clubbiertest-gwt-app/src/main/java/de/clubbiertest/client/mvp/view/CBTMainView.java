package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.AView;
import com.google.msc.framework.client.mvp.Slot;

import de.clubbiertest.client.ClubbiertestCss;

public class CBTMainView extends AView {

    private final Slot sidebarSlot;
    private final Slot contentSlot;

    public CBTMainView(final ClubbiertestCss clubbiertestCss) {
        setStyleName(clubbiertestCss.main());
        sidebarSlot = createSlot("sidebar");
        add(sidebarSlot);
        contentSlot = createSlot("content");
        add(contentSlot);
    }

    public Slot getSidebarSlot() {
        return sidebarSlot;
    }

    public Slot getContentSlot() {
        return contentSlot;
    }

}
