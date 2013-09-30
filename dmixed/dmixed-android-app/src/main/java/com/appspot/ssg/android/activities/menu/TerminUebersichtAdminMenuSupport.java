package com.appspot.ssg.android.activities.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.appspot.ssg.android.activities.R;
import com.appspot.ssg.android.activities.TerminErstellenActivity;

public class TerminUebersichtAdminMenuSupport extends MenuDefaultSupport {

	public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
		MenuInflater inflater = activity.getMenuInflater();
		inflater.inflate(R.menu.termin_admin_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(Activity activity, MenuItem item) {
		final boolean onOptionsItemSelected = super.onOptionsItemSelected(
				activity, item);
		if (onOptionsItemSelected) {
			return onOptionsItemSelected;
		}
		switch (item.getItemId()) {
		case R.id.MenuCreateTermin:
			final Intent intent = new Intent(activity,
					TerminErstellenActivity.class);
			activity.startActivity(intent);
			return true;

		default:
			return false;
		}
	}

}
