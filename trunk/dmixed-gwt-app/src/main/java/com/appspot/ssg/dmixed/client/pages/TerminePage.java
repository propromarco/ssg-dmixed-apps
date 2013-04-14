package com.appspot.ssg.dmixed.client.pages;

import java.util.List;

import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
        _header = new JQMHeader("Termine");
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
        for (ITermin termin : all) {
            JQMListItem item = _liste.addItem(termin.getTerminKurzbeschreibung(), "");
            item.addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    // TODO Auto-generated method stub

                }
            });
        }
    }

}
