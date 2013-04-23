package com.appspot.ssg.android.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.server.ServerRequestUtil;
import com.appspot.ssg.dmixed.shared.IUserData;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final long userId = AndroidConstants.getUserId(this);
		if (userId >= 0) {
			final Context applicationContext = getApplicationContext();
			Intent myIntent = new Intent(applicationContext,
					TerminUebersichtActrivity.class);
			startActivityForResult(myIntent, 0);

		} else {
			setContentView(R.layout.login);
			Button button = (Button) findViewById(R.id.LoginButton);
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View view) {
					final String mailString = getString(R.id.LoginMail);
					final String vornameString = getString(R.id.LoginVorname);
					final IUserData result = ServerRequestUtil.login(
							vornameString, mailString);
					if (result != null) {
						Intent myIntent = new Intent(view.getContext(),
								TerminUebersichtActrivity.class);
						final Long usrId = result.getId();
						AndroidConstants.setUserId(LoginActivity.this, usrId);
						AndroidConstants.setAdmin(LoginActivity.this,
								result.isAdmin());
						startActivityForResult(myIntent, 0);
					} else {
						reset(R.id.LoginMail);
						reset(R.id.LoginVorname);
						// TODO Fehlermeldung?!?
					}
				}

				private void reset(int loginmail) {
					final TextView view = (TextView) findViewById(loginmail);
					view.setText("");
				}

				private String getString(int id) {
					final String passwortString;
					final TextView passwort = (TextView) findViewById(id);
					passwortString = passwort.getText().toString();
					return passwortString;
				}
			});
		}
	}

}
