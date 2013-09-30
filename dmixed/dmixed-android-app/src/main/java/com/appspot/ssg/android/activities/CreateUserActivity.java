package com.appspot.ssg.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.server.ServerRequestException;
import com.appspot.ssg.android.server.ServerRequestUtil;

public class CreateUserActivity extends Activity {
	private final ServerRequestUtil sru = new ServerRequestUtil();

	@Override
	public void onBackPressed() {
		final Intent intent = new Intent(getApplicationContext(),
				LoginActivity.class);
		startActivity(intent);
		this.finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_user);
	}

	@Override
	protected void onResume() {
		super.onResume();
		final View button = findViewById(R.id.CreateUserButton);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sendRequest();
			}
		});
	}

	private String getValueById(int id) {
		final TextView textView = (TextView) findViewById(id);
		final String string = textView.getText().toString();
		return string;
	}

	private void sendRequest() {
		boolean admin;
		{
			final CheckBox checkBox = (CheckBox) findViewById(R.id.CreateUserAdmin);
			admin = checkBox.isChecked();
		}
		String name = getValueById(R.id.CreateUserLastName);
		String vorname = getValueById(R.id.CreateUserName);
		String mail = getValueById(R.id.CreateUserEmail);
		Long birthday;
		{
			final DatePicker datePicker = (DatePicker) findViewById(R.id.CreateUserBirthday);
			birthday = AndroidConstants.formatDate(datePicker.getDayOfMonth(),
					datePicker.getMonth(), datePicker.getYear()).getTime();
		}
		try {
			long userId = sru.createUser(admin, name, vorname, mail, birthday);
			AndroidConstants.setUserId(this, userId);
			AndroidConstants.setAdmin(this, admin);
			final Intent intent = new Intent(getApplicationContext(),
					TerminUebersichtActrivity.class);
			startActivity(intent);
			finish();
		} catch (ServerRequestException e) {
			final Intent intent = new Intent(getApplicationContext(),
					ExceptionOccuredActivity.class);
			intent.putExtra(AndroidConstants.ERROR_KEY, e.getMessage());
			startActivity(intent);
		}
	}
}
