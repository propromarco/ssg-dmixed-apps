package de.clubbiertest.client.mvp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;

import de.clubbiertest.client.StServerCommunicationUtil;
import de.clubbiertest.liste.shared.AbstractListe.Async;
import de.clubbiertest.liste.shared.ListItem;
import de.clubbiertest.liste.shared.ListeItems;
import de.clubbiertest.liste.shared.UriUtils;

public class CBTModel {
    public interface ICallback<Data> {
        void onSuccess(Data data);
    }

    private final StServerCommunicationUtil util;
    private List<ListItem> main = null;
    private ListeItems kontinente = null;
    private final Map<String, ListeItems> kontinenteMap = new HashMap<String, ListeItems>();
    private final Map<String, ListeItems> laender = new HashMap<String, ListeItems>();
    private final Map<String, ListeItems> sorten = new HashMap<String, ListeItems>();
    private String kontinentId = null;
    private String landId = null;
    private String _sorteId;

    public CBTModel(final StServerCommunicationUtil util) {
        super();
        this.util = util;
    }

    public void getMain(final ICallback<List<ListItem>> cb) {
        if (main != null) {
            cb.onSuccess(main);
        }
        else {
            final Async<List<ListItem>> async = new Async<List<ListItem>>() {

                @Override
                public void onError(final Throwable exception) {
                    // TODO Global Error Handling
                }

                @Override
                public void afterCall(final List<ListItem> main) {
                    CBTModel.this.main = main;
                    cb.onSuccess(main);
                }
            };
            util.getMain(async);
        }
    }

    public void loadKontinente(final ICallback<ListeItems> cb) {
        if (this.kontinente != null) {
            cb.onSuccess(kontinente);
        }
        else {
            final Async<ListeItems> async = new Async<ListeItems>() {
                @Override
                public void onError(final Throwable exception) {
                    // TODO Global Error Handling
                }

                @Override
                public void afterCall(final ListeItems kontinente) {
                    CBTModel.this.kontinente = kontinente;
                    cb.onSuccess(kontinente);
                }
            };
            util.getKontinente(async);
        }
    }

    public void loadKontinent(final String kontinentId, final ICallback<ListeItems> cb) {
        final ListeItems kontinent = this.kontinenteMap.get(kontinentId);
        if (kontinent != null) {
            cb.onSuccess(kontinent);
        }
        else {
            final String hostPageBaseURL = GWT.getHostPageBaseURL() + StServerCommunicationUtil.JERSEY + "/";
            final String kontinentPath = UriUtils.getKontinentPath(hostPageBaseURL, kontinentId);
            final Async<ListeItems> async = new Async<ListeItems>() {

                @Override
                public void onError(final Throwable exception) {
                    // TODO Global Error Handling
                }

                @Override
                public void afterCall(final ListeItems kontinent) {
                    CBTModel.this.kontinenteMap.put(kontinentId, kontinent);
                    cb.onSuccess(kontinent);
                }
            };
            util.call(kontinentPath, async);
        }
    }

    public void loadLand(final String landId, final ICallback<ListeItems> cb) {
        final ListeItems land = this.laender.get(landId);
        if (land != null) {
            cb.onSuccess(land);
        }
        else {
            final String hostPageBaseURL = GWT.getHostPageBaseURL() + StServerCommunicationUtil.JERSEY + "/";
            final String landPath = UriUtils.getLandPath(hostPageBaseURL, landId);
            final Async<ListeItems> async = new Async<ListeItems>() {

                @Override
                public void onError(final Throwable exception) {
                    // TODO Global Error Handling
                }

                @Override
                public void afterCall(final ListeItems land) {
                    CBTModel.this.laender.put(landId, land);
                    cb.onSuccess(land);
                }
            };
            util.call(landPath, async);
        }
    }

    public void loadSorte(final String sorteId, final ICallback<ListeItems> cb) {
        final ListeItems sorte = this.sorten.get(sorteId);
        if (sorte != null) {
            cb.onSuccess(sorte);
        }
        else {
            final String hostPageBaseURL = GWT.getHostPageBaseURL() + StServerCommunicationUtil.JERSEY + "/";
            final String sortePath = UriUtils.getSortePath(hostPageBaseURL, sorteId);
            final Async<ListeItems> async = new Async<ListeItems>() {

                @Override
                public void onError(final Throwable exception) {
                    // TODO Global Error Handling
                }

                @Override
                public void afterCall(final ListeItems sorte) {
                    CBTModel.this.sorten.put(sorteId, sorte);
                    cb.onSuccess(sorte);
                }
            };
            util.call(sortePath, async);
        }
    }

    public String getActiveLand() {
        return landId;
    }

    public void setActiveLand(final String landId) {
        this.landId = landId;
    }

    public String getActiveKontinent() {
        return kontinentId;
    }

    public void setActiveKontinent(final String kontinentId) {
        this.kontinentId = kontinentId;
    }

    public void setActiveSorte(final String sorteId) {
        _sorteId = sorteId;
    }

    public String getActiveSorte() {
        return _sorteId;
    }

}
