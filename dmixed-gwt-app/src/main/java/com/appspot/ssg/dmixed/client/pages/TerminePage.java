package com.appspot.ssg.dmixed.client.pages;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.list.JQMList;
import com.sksamuel.jqm4gwt.list.JQMListItem;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

public class TerminePage extends JQMPage {

    private final IDMixedUsecase _service;
    private final DMixedModel _model;
    private final JQMHeader _header;
    private final JQMList _liste;

    public TerminePage(IDMixedUsecase service, DMixedModel model) {
        _service = service;
        _model = model;
        IDMixedMessages messages = model.getMessages();
        _header = new JQMHeader(messages.termine());
        setHeader(_header);
        _liste = new JQMList();
        _liste.setInset(true);
        add(_liste);
    }

    @Override
    protected void onPageBeforeShow() {
        super.onPageBeforeShow();
        if (_model.getTermine() == null) {
            Long userId = _model.getUser().getId();
            IAsync<ITermine> answer = new IAsync<ITermine>() {

                @Override
                public void onSuccess(ITermine t) {
                    if (t != null) {
                        _model.setTermine(t);
                        loadTermine();
                    } else {
                        // TODO Error oder Nicht erlaubt
                    }
                }
            };
            _service.termine(userId, answer);
        }
        else {
            loadTermine();
        }
    }

    private void loadTermine() {
        _liste.clear();
        ITermine termine = _model.getTermine();
        List<ITermin> all = termine.getAll();
        final TerminPage jqmPage = new TerminPage(_service, _model);
        for (final ITermin termin : all) {
            Date termineDatum = termin.getTermineDatum();
            String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
            DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
            String d = formatter.format(termineDatum);
            String title = terminKurzbeschreibung + " - " + d;
            JQMListItem item = _liste.addItem(title, jqmPage);
            item.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    jqmPage.setTermin(termin);
                    JQMContext.changePage(jqmPage);
                }
            });
        }
    }

}
