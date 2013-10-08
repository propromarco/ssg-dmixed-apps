package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.presenter.AView;
import com.google.msc.framework.client.mvp.presenter.Slot;

public class CBTMainView extends AView {

    private final Slot sidebarSlot;
    private final Slot contentSlot;

    public CBTMainView() {
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
