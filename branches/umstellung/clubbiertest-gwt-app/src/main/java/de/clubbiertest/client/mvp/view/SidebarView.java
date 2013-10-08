package de.clubbiertest.client.mvp.view;

import com.google.msc.framework.client.mvp.ASidebarView;
import com.google.msc.framework.client.mvp.Slot;

import de.clubbiertest.client.ClubbiertestCss;

public class SidebarView extends ASidebarView {

    private final SidebarEntry kontinentEntry, landEntry, sorteEntry;

    public SidebarView(final ClubbiertestCss clubbiertestCss) {
        setStyleName(clubbiertestCss.sidebar());
        this.kontinentEntry = new SidebarEntry("kontinent");
        this.kontinentEntry.getHeader().setStyleName(clubbiertestCss.header());
        this.landEntry = new SidebarEntry("land");
        this.landEntry.getHeader().setStyleName(clubbiertestCss.header());
        this.sorteEntry = new SidebarEntry("sorte");
        this.sorteEntry.getHeader().setStyleName(clubbiertestCss.header());
    }

    public Slot getKontinentSlot() {
        add(kontinentEntry.getHeader());
        add(kontinentEntry.getSlot());
        return kontinentEntry.getSlot();
    }

    public Slot getLandSlot() {
        add(landEntry.getHeader());
        add(landEntry.getSlot());
        return landEntry.getSlot();
    }

    public Slot getSorteSlot() {
        add(sorteEntry.getHeader());
        add(sorteEntry.getSlot());
        return sorteEntry.getSlot();
    }

}
