//package com.appspot.ssg.dmixed.client.pages;
//
//import java.util.Date;
//import java.util.List;
//
//import com.appspot.ssg.dmixed.client.DMixedModel;
//import com.appspot.ssg.dmixed.client.IDMixedMessages;
//import com.appspot.ssg.dmixed.shared.IAsync;
//import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
//import com.appspot.ssg.dmixed.shared.ITermin;
//import com.appspot.ssg.dmixed.shared.ITermine;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.i18n.client.DateTimeFormat;
//import com.sksamuel.jqm4gwt.JQMContext;
//import com.sksamuel.jqm4gwt.JQMPage;
//import com.sksamuel.jqm4gwt.list.JQMList;
//import com.sksamuel.jqm4gwt.list.JQMListItem;
//import com.sksamuel.jqm4gwt.toolbar.JQMHeader;
//
//public class TerminePage extends JQMPage {
//
//    private final IDMixedUsecase _service;
//    private final DMixedModel _model;
//    private final JQMHeader _header;
//    private final JQMList _liste;
//
//    public TerminePage(final IDMixedUsecase service, final DMixedModel model) {
//        _service = service;
//        _model = model;
//        final IDMixedMessages messages = model.getMessages();
//        _header = new JQMHeader(messages.termine());
//        setHeader(_header);
//        _liste = new JQMList();
//        _liste.setInset(true);
//        add(_liste);
//    }
//
//    @Override
//    protected void onPageBeforeShow() {
//        super.onPageBeforeShow();
//        if (_model.getTermine() == null) {
//            final Long userId = _model.getUser().getId();
//            final IAsync<ITermine> answer = new IAsync<ITermine>() {
//
//                @Override
//                public void onSuccess(final ITermine t) {
//                    if (t != null) {
//                        _model.setTermine(t);
//                        loadTermine();
//                    }
//                    else {
//                        // TODO Error oder Nicht erlaubt
//                    }
//                }
//            };
//            _service.termine(userId, answer);
//        }
//        else {
//            loadTermine();
//        }
//    }
//
//    private void loadTermine() {
//        _liste.clear();
//        final ITermine termine = _model.getTermine();
//        final List<ITermin> all = termine.getAll();
//        final TerminPage jqmPage = new TerminPage(_service, _model);
//        for (final ITermin termin : all) {
//            final Date termineDatum = termin.getTermineDatum();
//            final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
//            final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
//            final String d = formatter.format(termineDatum);
//            final String title = terminKurzbeschreibung + " - " + d;
//            final JQMListItem item = _liste.addItem(title, jqmPage);
//            item.addClickHandler(new ClickHandler() {
//                @Override
//                public void onClick(final ClickEvent event) {
//                    jqmPage.setTermin(termin);
//                    JQMContext.changePage(jqmPage);
//                }
//            });
//        }
//    }
//
//}
