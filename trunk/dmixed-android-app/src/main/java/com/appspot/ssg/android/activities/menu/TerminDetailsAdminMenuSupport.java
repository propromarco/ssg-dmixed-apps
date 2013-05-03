package com.appspot.ssg.android.activities.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.appspot.ssg.android.activities.R;
import com.appspot.ssg.android.activities.TerminDetailsBearbeitenActivity;

public class TerminDetailsAdminMenuSupport extends MenuDefaultSupport {

	public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
		MenuInflater inflater = activity.getMenuInflater();
		inflater.inflate(R.menu.termin_details_admin_menu, menu);
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
		case R.id.MenuEditTermin:
			final Intent intent = new Intent(activity,
					TerminDetailsBearbeitenActivity.class);
			activity.startActivityForResult(intent, 0);
			return true;

		default:
			return false;
		}
	}

}
