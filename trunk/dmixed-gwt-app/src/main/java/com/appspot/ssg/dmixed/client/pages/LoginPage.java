package com.appspot.ssg.dmixed.client.pages;

import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.client.model.LoginData;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILoginData;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.button.JQMButton;
import com.sksamuel.jqm4gwt.form.elements.JQMEmail;
import com.sksamuel.jqm4gwt.form.elements.JQMText;

public class LoginPage extends JQMPage implements ClickHandler {
    private final JQMText nameOfChild;
    private final JQMEmail eMail;
    private final IDMixedUsecase _service;
    private DMixedModel _model;

    public LoginPage(IDMixedUsecase service, DMixedModel model) {
        _service = service;
        _model = model;
        this.nameOfChild = new JQMText("Name des Kindes");
        add(nameOfChild);
        this.eMail = new JQMEmail("EMail-Adresse");
        add(eMail);
        JQMButton loginButton = new JQMButton("Login");
        loginButton.addClickHandler(this);
        add(loginButton);
    }

    @Override
    public void onClick(ClickEvent event) {
        ILoginData data = new LoginData(nameOfChild.getValue(), eMail.getValue());
        IAsync<IUserData> answer = new IAsync<IUserData>() {
            @Override
            public void onSuccess(IUserData t) {
                if (t != null) {
                    _model.setUser(t);
                    TerminePage terminePage = new TerminePage(_service, _model);
                    JQMContext.changePage(terminePage);
                }
                else {
                    // TODO ERROR on Login
                }
            }
        };
        _service.login(data, answer);
    }
}
