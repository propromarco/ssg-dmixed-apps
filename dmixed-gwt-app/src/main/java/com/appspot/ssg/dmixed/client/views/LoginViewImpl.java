package com.appspot.ssg.dmixed.client.views;

import com.appspot.ssg.dmixed.client.IDMixedMessages;
import com.appspot.ssg.dmixed.client.activities.LoginActivity.LoginView;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MEmailTextBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class LoginViewImpl extends AbstractDmixedView implements LoginView {

    private final MTextBox _vorname;
    private final MEmailTextBox _email;
    private final Button _loginButton;

    public LoginViewImpl(final IDMixedMessages messages, final boolean inititalData) {
	super(messages);
	_vorname = new MTextBox();
	_email = new MEmailTextBox();
	if (inititalData) {
	    _vorname.setValue("Schwarz");
	    _email.setValue("silvana.schwarz@web.de");
	}
	final String login = messages.login();
	_loginButton = new Button(login);
	_layoutPanel.add(createEingabePanel());
	_layoutPanel.add(_loginButton);
    }

    private FlowPanel createEingabePanel() {
	final FlowPanel container = new FlowPanel();

	final HTML header = new HTML(_messages.loginData());
	header.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());

	container.add(header);

	final WidgetList widgetList = new WidgetList();
	widgetList.setRound(true);

	// lets put in some widgets
	widgetList.add(new FormListEntry(_messages.nameOfChild(), _vorname));
	widgetList.add(new FormListEntry(_messages.emailAdress(), _email));

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
    public HasTapHandlers getLogin() {
	return _loginButton;
    }

}
