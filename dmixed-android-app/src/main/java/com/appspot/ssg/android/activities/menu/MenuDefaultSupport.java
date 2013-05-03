package com.appspot.ssg.android.activities.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.appspot.ssg.android.activities.ExceptionOccuredActivity;
import com.appspot.ssg.android.activities.LoginActivity;
import com.appspot.ssg.android.activities.R;
import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.server.ServerRequestException;
import com.appspot.ssg.android.server.ServerRequestUtil;

public class MenuDefaultSupport {
	protected final ServerRequestUtil sru = new ServerRequestUtil();

	public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
		MenuInflater inflater = activity.getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(Activity activity, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.MenuLogout: {
			AndroidConstants.setUserId(activity, -1);
			final Context applicationContext = activity.getApplicationContext();
			final Intent intent = new Intent(applicationContext,
					LoginActivity.class);
			activity.startActivity(intent);
			activity.finish();
			return true;
		}
		case R.id.MenuDelete: {
			final long userId = AndroidConstants.getUserId(activity);
			try {
				sru.deleteUser(userId);
				final Context applicationContext = activity
						.getApplicationContext();
				final Intent intent = new Intent(applicationContext,
						LoginActivity.class);
				AndroidConstants.setUserId(activity, -1);
				activity.startActivity(intent);
				activity.finish();
			} catch (ServerRequestException e) {
				final Intent intent = new Intent(
						activity.getApplicationContext(),
						ExceptionOccuredActivity.class);
				intent.putExtra(AndroidConstants.ERROR_KEY, e.getMessage());
				activity.startActivity(intent);
			}
			return true;
		}
		default:
			return false;
		}
	}
}
