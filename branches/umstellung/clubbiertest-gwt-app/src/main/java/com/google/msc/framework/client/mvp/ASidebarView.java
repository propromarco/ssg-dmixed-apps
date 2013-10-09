package com.google.msc.framework.client.mvp;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;

public class ASidebarView extends AView {

	public class SidebarEntry {

		private final Slot slot;
		private final FlowPanel header;
		private final FlowPanel content;
		private final Anchor w;

		public SidebarEntry(final String id, final String header) {
			this.header = new FlowPanel();
			w = new Anchor();
			w.getElement().setInnerHTML(header);
			this.header.add(w);
			this.content = new FlowPanel();
			this.slot = createSlot(id);
			this.content.add(slot);
		}

		public HandlerRegistration addClickHandler(final ClickHandler handler) {
			return w.addClickHandler(handler);
		}

		public Slot getSlot() {
			return slot;
		}

		public FlowPanel getHeader() {
			return header;
		}

		public FlowPanel getContent() {
			return content;
		}

		public void disable() {
			content.setVisible(false);
		}

		public void enable() {
			content.setVisible(true);
		}

	}

	public ASidebarView() {
	}

}
