package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedCss;
import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.LoginActivity.LoginView;
import com.appspot.ssg.dmixed.client.activities.LoginActivity.WithTapHandlers;
import com.appspot.ssg.dmixed.client.views.components.ButtonWithWait;
import com.appspot.ssg.dmixed.client.views.components.CssTextBox;
import com.appspot.ssg.dmixed.client.views.components.FormListEntry;
import com.appspot.ssg.dmixed.client.views.components.WidgetList;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;

public class LoginViewImpl extends AbstractDmixedView implements LoginView {

    private final TextBox _vorname;
    private final TextBox _email;
    private final ButtonWithWait _loginButton;

    public LoginViewImpl(final IDMixedMessages messages, final IDMixedCss css, final boolean inititalData) {
	super(messages, css);
	_vorname = new CssTextBox(css);
	_email = new CssTextBox(css);
	if (inititalData) {
	    _vorname.setValue("Schwarz");
	    _email.setValue("silvana.schwarz@web.de");
	}
	final String login = messages.login();
	_loginButton = new ButtonWithWait(css, login);
	_layoutPanel.add(createEingabePanel());
	_layoutPanel.add(_loginButton);
    }

    private FlowPanel createEingabePanel() {
	final FlowPanel container = new FlowPanel();
	container.setStyleName(css.form());

	final HTML header = new HTML(_messages.loginData());

	container.add(header);

	final WidgetList widgetList = new WidgetList(css);

	// lets put in some widgets
	widgetList.add(new FormListEntry(css, _messages.nameOfChild(), _vorname));
	widgetList.add(new FormListEntry(css, _messages.emailAdress(), _email));

	container.add(widgetList);
	return container;
    }

    @Override
    public HasText getVorname() {
	return _vorname;
    }

    @Override
    public HasText getEmail() {
	return _email;
    }

    @Override
    public WithTapHandlers getLogin() {
	return _loginButton;
    }

}
