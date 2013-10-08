package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.presenter.AView;
import com.google.msc.framework.client.mvp.presenter.Slot;

public class CBTMainView extends AView {

    private final Slot sidebarSlot;

    public CBTMainView() {
        sidebarSlot = createSlot("sidebar");
        add(sidebarSlot);
    }

    public Slot getSidebarSlot() {
        return sidebarSlot;
    }

}
