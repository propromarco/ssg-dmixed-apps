package com.appspot.ssg.android.activities.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.appspot.ssg.android.activities.LoginActivity;
import com.appspot.ssg.android.activities.R;
import com.appspot.ssg.android.data.AndroidConstants;

public class MenuActrivitySupport {

	public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
		MenuInflater inflater = activity.getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(Activity activity, MenuItem item) {
		if (item.getItemId() == R.id.MenuLogout) {
			AndroidConstants.setUserId(activity, -1);
			final Context applicationContext = activity.getApplicationContext();
			final Intent intent = new Intent(applicationContext,
					LoginActivity.class);
			activity.startActivity(intent);
			activity.finish();
			return true;
		}
		return false;
	}
}
