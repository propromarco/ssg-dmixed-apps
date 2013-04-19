//package com.appspot.ssg.dmixed.client.pages;
//
//import com.appspot.ssg.dmixed.client.DMixedModel;
//import com.appspot.ssg.dmixed.client.IDMixedMessages;
//import com.appspot.ssg.dmixed.client.model.LoginData;
//import com.appspot.ssg.dmixed.shared.IAsync;
//import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
//import com.appspot.ssg.dmixed.shared.ILoginData;
//import com.appspot.ssg.dmixed.shared.IUserData;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.sksamuel.jqm4gwt.JQMContext;
//import com.sksamuel.jqm4gwt.JQMPage;
//import com.sksamuel.jqm4gwt.button.JQMButton;
//import com.sksamuel.jqm4gwt.form.elements.JQMEmail;
//import com.sksamuel.jqm4gwt.form.elements.JQMText;
//
//public class LoginPage extends JQMPage implements ClickHandler {
//    private final JQMText nameOfChild;
//    private final JQMEmail eMail;
//    private final IDMixedUsecase _service;
//    private final DMixedModel _model;
//
//    public LoginPage(final IDMixedUsecase service, final DMixedModel model) {
//        _service = service;
//        _model = model;
//        final IDMixedMessages messages = model.getMessages();
//        this.nameOfChild = new JQMText(messages.nameOfChild());
//        add(nameOfChild);
//        this.eMail = new JQMEmail(messages.emailAdress());
//        add(eMail);
//        final JQMButton loginButton = new JQMButton(messages.login());
//        loginButton.addClickHandler(this);
//        add(loginButton);
//    }
//
//    @Override
//    public void onClick(final ClickEvent event) {
//        final ILoginData data = new LoginData(nameOfChild.getValue(), eMail.getValue());
//        final IAsync<IUserData> answer = new IAsync<IUserData>() {
//            @Override
//            public void onSuccess(final IUserData t) {
//                if (t != null) {
//                    _model.setUser(t);
//                    final TerminePage terminePage = new TerminePage(_service, _model);
//                    JQMContext.changePage(terminePage);
//                }
//                else {
//                    // TODO ERROR on Login
//                }
//            }
//        };
//        _service.login(data, answer);
//    }
//}
