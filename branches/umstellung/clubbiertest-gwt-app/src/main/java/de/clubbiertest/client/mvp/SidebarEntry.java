package de.clubbiertest.client.mvp;

import de.clubbiertest.client.mvp.ClubbiertestDataHandler.Sidebars;

public class SidebarEntry {

    private final SidebarHeader header;
    private final SidebarContent content;

    public SidebarEntry(ClubbiertestDataHandler dataHandler, String headerString, Sidebars type) {
        header = new SidebarHeader(dataHandler, headerString, type);
        content = new SidebarContent(dataHandler, type);
        content.setVisible(false);
    }

    public SidebarHeader getHeader() {
        return header;
    }

    public SidebarContent getContent() {
        return content;
    }

    public void open(boolean open) {
        content.setVisible(open);
    }

}
