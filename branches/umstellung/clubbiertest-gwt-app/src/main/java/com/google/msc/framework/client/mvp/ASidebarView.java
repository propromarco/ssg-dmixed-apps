package com.google.msc.framework.client.mvp;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

public class ASidebarView extends AView {

    public class SidebarEntry {

        private final Slot slot;
        private final FlowPanel header;

        public SidebarEntry(final String id, final String header) {
            this.header = new FlowPanel();
            final Anchor w = new Anchor();
            w.getElement().setInnerHTML(header);
            this.header.add(w);
            this.slot = createSlot(id);
        }

        public Slot getSlot() {
            return slot;
        }

        public FlowPanel getHeader() {
            return header;
        }

    }

    public ASidebarView() {
    }

}
