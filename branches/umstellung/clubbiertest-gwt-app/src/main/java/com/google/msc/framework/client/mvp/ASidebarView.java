package com.google.msc.framework.client.mvp;

import com.google.gwt.user.client.ui.HTML;

public class ASidebarView extends AView {

    public class SidebarEntry {

        private final Slot slot;
        private final HTML header;

        public SidebarEntry(final String id) {
            this.header = new HTML();
            this.slot = createSlot(id);
        }

        public Slot getSlot() {
            return slot;
        }

        public HTML getHeader() {
            return header;
        }

    }

    public ASidebarView() {
    }

}
