package com.appspot.ssg.android.activities;

import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.appspot.ssg.android.activities.menu.MenuDefaultSupport;
import com.appspot.ssg.android.activities.menu.TerminUebersichtAdminMenuSupport;
import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.server.ServerRequestException;
import com.appspot.ssg.android.server.ServerRequestUtil;
import com.appspot.ssg.dmixed.shared.ITermin;

public class TerminUebersichtActrivity extends Activity {
	private final ServerRequestUtil sru = new ServerRequestUtil();
	private MenuDefaultSupport mas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.termin);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return mas.onCreateOptionsMenu(this, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return mas.onOptionsItemSelected(this, item);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (AndroidConstants.isAdmin(this)) {
			mas = new TerminUebersichtAdminMenuSupport();
		} else {
			mas = new MenuDefaultSupport();
		}
		try {
			Collection<ITermin> termine = sru.getTermine(AndroidConstants
					.getUserId(this));
			TableLayout table = (TableLayout) findViewById(R.id.TerminUebersichtTabelle);
			table.removeAllViews();
			int width = 80;// findViewById(R.id.DatumHeader).getWidth();
			for (final ITermin iTermin : termine) {
				TableRow row = new TableRow(this);
				{
					TextView textView = new TextView(this);
					textView.setText(AndroidConstants.formatDate(iTermin
							.getTermineDatum()));
					textView.setWidth(width);
					row.addView(textView);
				}
				{
					TextView textView = new TextView(this);
					textView.setText(iTermin.getTerminKurzbeschreibung());
					row.addView(textView);
				}
				row.setClickable(true);
				row.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View view) {
						Intent intent = new Intent(view.getContext(),
								TerminDetailsActivity.class);
						intent.putExtra(AndroidConstants.TERMIN_KEY, iTermin);
						startActivityForResult(intent, 0);
					}
				});
				MarginLayoutParams params = new MarginLayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				params.setMargins(0, 10, 0, 0);
				row.setLayoutParams(params);
				table.addView(row);
			}
		} catch (ServerRequestException e) {
			final Intent intent = new Intent(getApplicationContext(),
					ExceptionOccuredActivity.class);
			intent.putExtra(AndroidConstants.ERROR_KEY, e.getMessage());
			startActivity(intent);
		}
	}
}
