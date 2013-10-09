package de.clubbiertest.client.mvp.view;

import java.util.HashMap;
import java.util.Map;

import com.google.msc.framework.client.mvp.ASidebarView;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.ClubbiertestTexte;

public class CBTSidebarView extends ASidebarView {

	public enum Stacks {
		KONTINENT, LAND, SORTE
	}

	private final ClubbiertestCss clubbiertestCss;
	private final ClubbiertestTexte texte;
	private final Map<Stacks, SidebarEntry> stacks = new HashMap<Stacks, SidebarEntry>();

	public CBTSidebarView(final ClubbiertestCss clubbiertestCss,
			final ClubbiertestTexte texte) {
		this.clubbiertestCss = clubbiertestCss;
		this.texte = texte;
		setStyleName(clubbiertestCss.sidebar());
	}

	public SidebarEntry createSlot(final Stacks stack) {
		final String text;
		switch (stack) {
		case KONTINENT:
			text = texte.kontinent();
			break;
		case LAND:
			text = texte.land();
			break;
		case SORTE:
			text = texte.sorte();
			break;
		default:
			text = null;
		}
		final SidebarEntry entry = new SidebarEntry("sorte", text);
		entry.getHeader().setStyleName(clubbiertestCss.header());
		entry.getContent().setStyleName(clubbiertestCss.content());
		add(entry.getHeader());
		add(entry.getContent());
		stacks.put(stack, entry);
		return entry;
	}

	public void selectStack(final Stacks stack) {
		for (final SidebarEntry sidebarStack : stacks.values()) {
			sidebarStack.disable();
		}
		final SidebarEntry sidebarStack = stacks.get(stack);
		sidebarStack.enable();
	}

}
