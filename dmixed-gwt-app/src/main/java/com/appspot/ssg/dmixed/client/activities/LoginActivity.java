package com.appspot.ssg.dmixed.client.activities;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.model.LoginData;
import com.appspot.ssg.dmixed.client.places.TerminePlace;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILoginData;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasText;

public class LoginActivity extends AbstractActivity {

    public interface WithTapHandlers extends HasClickHandlers {
	void setProgress(boolean Progress);
    }

    public interface LoginView extends IDMixedView {

	HasText getVorname();

	HasText getEmail();

	WithTapHandlers getLogin();

    }

    private final ClientFactory _clientFactory;

    public LoginActivity(final ClientFactory clientFactory) {
	_clientFactory = clientFactory;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
	final LoginView loginView = _clientFactory.getLoginView();
	final IDMixedUsecase service = _clientFactory.getService();
	final IDMixedMessages messages = _clientFactory.getMessages();
	panel.setWidget(loginView);
	final WithTapHandlers login = loginView.getLogin();
	login.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(final ClickEvent event) {
		login.setProgress(true);
		final String vorname = loginView.getVorname().getText();
		final String email = loginView.getEmail().getText();
		final String vornameTrimmed = vorname.trim();
		final String emailTrimmed = email.trim();
		final ILoginData data = new LoginData(vornameTrimmed, emailTrimmed);
		final IAsync<IUserData> answer = new IAsync<IUserData>() {
		    @Override
		    public void onSuccess(final IUserData t) {
			if (t != null) {
			    final Long userId = t.getId();
			    final boolean admin = t.isAdmin();
			    _clientFactory.getPlaceController().goTo(new TerminePlace(userId, admin));
			} else {
			    loginView.showMessage(messages.errorOnLogin());
			}
			login.setProgress(false);
		    }

		    @Override
		    public void onError(final Throwable exception) {
			login.setProgress(false);
			loginView.showError(exception);
		    }
		};
		service.login(data, answer);
	    }
	});
    }

}
