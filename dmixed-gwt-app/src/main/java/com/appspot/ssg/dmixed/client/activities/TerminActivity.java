package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class TerminActivity extends MGWTAbstractActivity {

    public interface TerminView extends IsWidget {

        void setText(String title);

        void setTerminBeschreibung(String terminBeschreibung);

        void fillTeilnehmer(List<ITerminTeilnehmer> teilnehmer);

        void fillMitbringsel(List<ITerminMitbringsel> mitbringsel);
    }

    private final ClientFactory _clientFactory;
    private final Long _terminId;

    public TerminActivity(final ClientFactory clientFactory, final Long terminId) {
        _clientFactory = clientFactory;
        _terminId = terminId;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        final TerminView terminView = _clientFactory.getTerminView();
        final DMixedModel model = _clientFactory.getModel();
        final IDMixedUsecase service = _clientFactory.getService();
        panel.setWidget(terminView);
        final Long userId = model.getUser().getId();
        final IAsync<ITerminDetails> answer = new IAsync<ITerminDetails>() {
            @Override
            public void onSuccess(final ITerminDetails termin) {
                if (termin != null) {
                    final Date termineDatum = termin.getTermineDatum();
                    final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
                    final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
                    final String d = formatter.format(termineDatum);
                    final String title = terminKurzbeschreibung + " - " + d;
                    terminView.setText(title);
                    final String terminBeschreibung = termin.getTerminBeschreibung();
                    terminView.setTerminBeschreibung(terminBeschreibung);
                    terminView.fillTeilnehmer(termin.getTeilnehmer());
                    if (termin.getMitbringsel() != null) {
                        terminView.fillMitbringsel(termin.getMitbringsel());
                    }
                }
                else {
                    // TODO Error oder nicht erlaubt
                }
            }
        };
        service.termin(userId, _terminId, answer);
    }

}
