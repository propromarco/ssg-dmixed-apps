package com.appspot.ssg.dmixed.client.pages;

import java.util.Date;

import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

public class TerminPage extends JQMPage {

    private ITermin _termin;
    private IDMixedUsecase _service;
    private DMixedModel _model;
    private JQMHeader _header;

    public TerminPage(IDMixedUsecase service, DMixedModel model) {
        _service = service;
        _model = model;
        _header = new JQMHeader("&nbsp;");
        setHeader(_header);
    }

    public void setTermin(ITermin termin) {
        _termin = termin;
    }

    @Override
    protected void onPageBeforeShow() {
        super.onPageBeforeShow();
        Long userId = _model.getUser().getId();
        Long terminId = _termin.getTerminId();
        IAsync<ITerminDetails> answer = new IAsync<ITerminDetails>() {
            @Override
            public void onSuccess(ITerminDetails termin) {
                if (termin != null) {
                    Date termineDatum = termin.getTermineDatum();
                    String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
                    DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
                    String d = formatter.format(termineDatum);
                    String title = terminKurzbeschreibung + " - " + d;
                    _header.setText(title);
                    //
                }
                else {
                    // TODO Error oder nicht erlaubt
                }
            }
        };
        _service.termin(userId, terminId, answer);
    }

}
