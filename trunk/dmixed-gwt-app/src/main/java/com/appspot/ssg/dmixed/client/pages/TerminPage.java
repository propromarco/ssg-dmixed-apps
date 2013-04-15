package com.appspot.ssg.dmixed.client.pages;

import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.sksamuel.jqm4gwt.JQMPage;

public class TerminPage extends JQMPage {

    private ITermin _termin;
    private IDMixedUsecase _service;
    private DMixedModel _model;

    public TerminPage(IDMixedUsecase service, DMixedModel model) {
        _service = service;
        _model = model;
    }

    public void setTermin(ITermin termin) {
        _termin = termin;
    }

    @Override
    protected void onPageBeforeShow() {
        super.onPageBeforeShow();
    }

}
