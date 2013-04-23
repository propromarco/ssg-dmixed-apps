package com.appspot.ssg.android.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AndroidConstants {
	public static final String TERMIN_DETAILS_KEY = "terminDetailsData";
	public static final String TERMIN_KEY = "terminData";
	private static final String USER_ID = "userId";
	private static final String ADMIN_ID = "adminId";

	@SuppressLint("SimpleDateFormat")
	private static final SimpleDateFormat format = new SimpleDateFormat(
			"dd.MM.yyyy");

	public static String formatDate(Date date) {
		return format.format(date);
	}

	public static Date formatDate(int dayOfMonth, int month, int year) {
		StringBuilder sb = new StringBuilder();
		if (dayOfMonth < 10)
			sb.append("0");
		sb.append(dayOfMonth);
		sb.append(".");
		if (month < 10)
			sb.append("0");
		sb.append(month);
		sb.append(".");
		sb.append(year);
		try {
			return format.parse(sb.toString());
		} catch (ParseException e) {
			return null;
		}
	}

	public static long getUserId(Activity activity) {
		final SharedPreferences settings = activity.getSharedPreferences(
				"ssgDmixed", 0);
		final long userId = settings.getLong(AndroidConstants.USER_ID, -1l);
		return userId;
	}

	public static void setUserId(Activity activity, long userId) {
		final SharedPreferences settings = activity.getSharedPreferences(
				"ssgDmixed", 0);
		final Editor edit = settings.edit();
		edit.putLong(USER_ID, userId);
		edit.commit();
	}

	public static boolean isAdmin(Activity activity) {
		final SharedPreferences settings = activity.getSharedPreferences(
				"ssgDmixed", 0);
		final boolean admin = settings.getBoolean(AndroidConstants.ADMIN_ID,
				false);
		return admin;
	}

	public static void setAdmin(Activity activity, boolean admin) {
		final SharedPreferences settings = activity.getSharedPreferences(
				"ssgDmixed", 0);
		final Editor edit = settings.edit();
		edit.putBoolean(ADMIN_ID, admin);
		edit.commit();
	}

}
