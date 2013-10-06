package de.clubbiertest.client.mvp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.liste.shared.AbstractListe.Async;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;

public class ClubbiertestModel {
	public interface ICallback<Data> {
		void onSuccess(Data data);
	}

	private final StServerCommunicationUtil util;
	private List<ListItem> main = null;
	private ListeItems kontinente = null;
	private final Map<String, ListeItems> kontinent = new HashMap<String, ListeItems>();
	private final Map<String, ListeItems> laender = new HashMap<String, ListeItems>();
	private final Map<String, ListeItems> sorten = new HashMap<String, ListeItems>();

	public ClubbiertestModel(final StServerCommunicationUtil util) {
		super();
		this.util = util;
	}

	public void getMain(final ICallback<List<ListItem>> cb) {
		if (main != null) {
			cb.onSuccess(main);
		} else {
			final Async<List<ListItem>> async = new Async<List<ListItem>>() {

				@Override
				public void onError(final Throwable exception) {
					// TODO Global Error Handling
				}

				@Override
				public void afterCall(final List<ListItem> main) {
					ClubbiertestModel.this.main = main;
					cb.onSuccess(main);
				}
			};
			util.getMain(async);
		}
	}

	public void loadKontinente(final ICallback<ListeItems> cb) {
		if (this.kontinente != null) {
			cb.onSuccess(kontinente);
		} else {
			final Async<ListeItems> async = new Async<ListeItems>() {
				@Override
				public void onError(final Throwable exception) {
					// TODO Global Error Handling
				}

				@Override
				public void afterCall(final ListeItems kontinente) {
					ClubbiertestModel.this.kontinente = kontinente;
					cb.onSuccess(kontinente);
				}
			};
			util.getKontinente(async);
		}
	}

	public void loadKontinent(final ListItem item,
			final ICallback<ListeItems> cb) {
		final String id = item.getId();
		final ListeItems kontinent = this.kontinent.get(id);
		if (kontinent != null) {
			cb.onSuccess(kontinent);
		} else {
			final String url = item.getUri();
			final Async<ListeItems> async = new Async<ListeItems>() {

				@Override
				public void onError(final Throwable exception) {
					// TODO Global Error Handling
				}

				@Override
				public void afterCall(final ListeItems kontinent) {
					ClubbiertestModel.this.kontinent.put(id, kontinent);
					cb.onSuccess(kontinent);
				}
			};
			util.call(url, async);
		}
	}

	public void loadLand(final ListItem item, final ICallback<ListeItems> cb) {
		final String id = item.getId();
		final ListeItems land = this.laender.get(id);
		if (land != null) {
			cb.onSuccess(land);
		} else {
			final String url = item.getUri();
			final Async<ListeItems> async = new Async<ListeItems>() {

				@Override
				public void onError(final Throwable exception) {
					// TODO Global Error Handling
				}

				@Override
				public void afterCall(final ListeItems land) {
					ClubbiertestModel.this.laender.put(id, land);
					cb.onSuccess(land);
				}
			};
			util.call(url, async);
		}
	}

	public void loadSorte(final ListItem item, final ICallback<ListeItems> cb) {
		final String id = item.getId();
		final ListeItems sorte = this.sorten.get(id);
		if (sorte != null) {
			cb.onSuccess(sorte);
		} else {
			final String url = item.getUri();
			final Async<ListeItems> async = new Async<ListeItems>() {

				@Override
				public void onError(final Throwable exception) {
					// TODO Global Error Handling
				}

				@Override
				public void afterCall(final ListeItems sorte) {
					ClubbiertestModel.this.sorten.put(id, sorte);
					cb.onSuccess(sorte);
				}
			};
			util.call(url, async);
		}
	}

}
