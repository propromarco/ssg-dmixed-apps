/* Copyright, (c) 2013 Suretec GmbH  */

package com.appspot.ssg.dmixed.client.views;

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

public class LoginViewImpl extends AbstractDmixedView implements LoginView
{
    private final TextBox _vorname;
    private final TextBox _email;
    private final ButtonWithWait _loginButton;

    public LoginViewImpl( final IDMixedMessages messages, final boolean inititalData )
    {
        super(messages);
        _vorname = new CssTextBox();
        _email = new CssTextBox();
        if ( inititalData )
        {
            _vorname.setValue("Schwarz");
            _email.setValue("123@456.com");
        }
        final String login = messages.login();
        _loginButton = new ButtonWithWait(login);
        _layoutPanel.add(createEingabePanel());
        _layoutPanel.add(_loginButton);
        //versuch für spezifische names
        _layoutPanel.setStyleName("layoutpanel login_page");
    }

    private FlowPanel createEingabePanel()
    {
        final FlowPanel container = new FlowPanel();
        container.setStyleName("form");

        final HTML header = new HTML(_messages.loginData());

        container.add(header);

        final WidgetList widgetList = new WidgetList();

        // lets put in some widgets
        widgetList.add(new FormListEntry(_messages.nameOfChild(), _vorname));
        widgetList.add(new FormListEntry(_messages.emailAdress(), _email));

        container.add(widgetList);
        return container;
    }

    @Override public HasText getVorname()
    {
        return _vorname;
    }

    @Override public HasText getEmail()
    {
        return _email;
    }

    @Override public WithTapHandlers getLogin()
    {
        return _loginButton;
    }
}
