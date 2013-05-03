package com.appspot.ssg.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

import com.appspot.ssg.android.activities.menu.MenuDefaultSupport;
import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.server.ServerRequestException;
import com.appspot.ssg.android.server.ServerRequestUtil;
import com.appspot.ssg.dmixed.shared.ITerminDetails;

public class TerminErstellenActivity extends Activity {
	private final ServerRequestUtil sru = new ServerRequestUtil();
	private final MenuDefaultSupport mds = new MenuDefaultSupport();

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return mds.onOptionsItemSelected(this, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return mds.onCreateOptionsMenu(this, menu);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_termin);
		final Button button = (Button) findViewById(R.id.TerminErstellungErstellenButton);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				final boolean heimspiel = ((CheckBox) findViewById(R.id.TerminErstellenHeimspielCheckbox))
						.isChecked();
				final long userId = AndroidConstants
						.getUserId(TerminErstellenActivity.this);
				try {
					final ITerminDetails terminDetails = sru.createTermin(
							userId, heimspiel);
					final Intent intent = new Intent(
							TerminErstellenActivity.this,
							TerminDetailsBearbeitenActivity.class);
					intent.putExtra(AndroidConstants.TERMIN_DETAILS_KEY,
							terminDetails);
					startActivity(intent);
					finish();
				} catch (ServerRequestException e) {
					final Intent intent = new Intent(
							TerminErstellenActivity.this,
							ExceptionOccuredActivity.class);
					intent.putExtra(AndroidConstants.ERROR_KEY, e.getMessage());
					startActivity(intent);
				}
			}
		});
	}

}
