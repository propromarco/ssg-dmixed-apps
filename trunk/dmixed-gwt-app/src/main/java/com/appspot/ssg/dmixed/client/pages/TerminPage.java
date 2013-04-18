package com.appspot.ssg.dmixed.client.pages;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.list.JQMList;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

public class TerminPage extends JQMPage {

    private ITermin _termin;
    private final IDMixedUsecase _service;
    private final DMixedModel _model;
    private final JQMHeader _header;
    private final HTML _text;
    private final JQMList _fieldSet;

    public TerminPage(final IDMixedUsecase service, final DMixedModel model) {
        _service = service;
        _model = model;
        _header = new JQMHeader("&nbsp;");
        setHeader(_header);
        _text = new HTML();
        add(_text);
        _fieldSet = new JQMList();
        add(_fieldSet);
    }

    public void setTermin(final ITermin termin) {
        _termin = termin;
    }

    @Override
    protected void onPageBeforeShow() {
        super.onPageBeforeShow();
        final Long userId = _model.getUser().getId();
        final Long terminId = _termin.getTerminId();
        final IAsync<ITerminDetails> answer = new IAsync<ITerminDetails>() {
            @Override
            public void onSuccess(final ITerminDetails termin) {
                if (termin != null) {
                    final Date termineDatum = termin.getTermineDatum();
                    final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
                    final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
                    final String d = formatter.format(termineDatum);
                    final String title = terminKurzbeschreibung + " - " + d;
                    _header.setText(title);
                    final String terminBeschreibung = termin.getTerminBeschreibung();
                    _text.setHTML(terminBeschreibung);
                    _fieldSet.clear();
                    fillTeilnehmer(termin.getTeilnehmer());
                    fillMitbringsel(termin.getMitbringsel());
                }
                else {
                    // TODO Error oder nicht erlaubt
                }
            }
        };
        _service.termin(userId, terminId, answer);
    }

    protected void fillTeilnehmer(final List<ITerminTeilnehmer> teilnehmer) {
        _fieldSet.addDivider("Teilnehmer");
        for (final ITerminTeilnehmer iTerminTeilnehmer : teilnehmer) {
            final String vorname = iTerminTeilnehmer.getVorname();
            final String name = iTerminTeilnehmer.getName();
            _fieldSet.addItem(vorname + " " + name);
        }
    }

    protected void fillMitbringsel(final List<ITerminMitbringsel> mitbringsel) {
        if (mitbringsel == null)
            return;
        _fieldSet.addDivider("Mitzubringen");
        for (final ITerminMitbringsel terminMitbringsel : mitbringsel) {
            _fieldSet.addItem(terminMitbringsel.getBeschreibung());
        }
    }

}
