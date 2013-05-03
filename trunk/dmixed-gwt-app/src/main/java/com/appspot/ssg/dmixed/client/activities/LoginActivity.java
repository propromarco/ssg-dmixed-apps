package com.appspot.ssg.dmixed.client.activities;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.model.LoginData;
import com.appspot.ssg.dmixed.client.places.TerminePlace;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILoginData;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasText;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class LoginActivity extends MGWTAbstractActivity {

    public interface LoginView extends IDMixedView {

	HasText getVorname();

	HasText getEmail();

	HasTapHandlers getLogin();

    }

    private final ClientFactory _clientFactory;

    public LoginActivity(final ClientFactory clientFactory) {
	_clientFactory = clientFactory;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
	final LoginView loginView = _clientFactory.getLoginView();
	final IDMixedUsecase service = _clientFactory.getService();
	final DMixedModel model = _clientFactory.getModel();
	final IDMixedMessages messages = model.getMessages();
	panel.setWidget(loginView);
	addHandlerRegistration(loginView.getLogin().addTapHandler(new TapHandler() {
	    @Override
	    public void onTap(final TapEvent event) {
		loginView.setProgress(true);
		final String vorname = loginView.getVorname().getText();
		final String email = loginView.getEmail().getText();
		final ILoginData data = new LoginData(vorname, email);
		final IAsync<IUserData> answer = new IAsync<IUserData>() {
		    @Override
		    public void onSuccess(final IUserData t) {
			if (t != null) {
			    model.setUser(t);
			    _clientFactory.getPlaceController().goTo(new TerminePlace(t.getId()));
			} else {
			    loginView.showMessage(messages.errorOnLogin());
			}
			loginView.setProgress(false);
		    }

		    @Override
		    public void onError(final Throwable exception) {
			loginView.showError(exception);
		    }
		};
		service.login(data, answer);
	    }
	}));
    }

}
