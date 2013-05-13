package com.appspot.ssg.android.activities;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.appspot.ssg.android.activities.menu.MenuDefaultSupport;
import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.data.Ligen;
import com.appspot.ssg.android.server.ServerRequestException;
import com.appspot.ssg.android.server.ServerRequestUtil;
import com.appspot.ssg.dmixed.shared.ILiga;
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
	}

	@Override
	protected void onResume() {
		super.onResume();
		final Button button = (Button) findViewById(R.id.TerminErstellungErstellenButton);
		final long userId = AndroidConstants
				.getUserId(TerminErstellenActivity.this);
		try {
			final Spinner spinner = (Spinner) findViewById(R.id.TerminErstellungLigaAuswahl);
			final Ligen ligen = sru.getLigen(userId);
			final List<ILiga> allLigen = ligen.getAll();
			final SpinnerAdapter adapter = new ArrayAdapter<ILiga>(this,
					android.R.layout.simple_spinner_item, allLigen);
			spinner.setAdapter(adapter);
			final AtomicLong ligaId = new AtomicLong(-1);
			spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int pos, long id) {
					final ILiga item = (ILiga) parent.getItemAtPosition(pos);
					ligaId.set(item.getId());
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {

				}
			});
			final DatePicker datum = (DatePicker) findViewById(R.id.TerminErstellenDatum);
			final EditText kurzbeschreibungEingabe = (EditText) findViewById(R.id.TerminErstellenKurzbeschreibung);
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View view) {
					final boolean heimspiel = ((CheckBox) findViewById(R.id.TerminErstellenHeimspielCheckbox))
							.isChecked();
					try {
						final long liga = ligaId.get();
						final long terminDatum = AndroidConstants.formatDate(
								datum.getDayOfMonth(), datum.getMonth(),
								datum.getYear()).getTime();
						final String terminKurzbeschreibung = kurzbeschreibungEingabe
								.getText().toString();
						final ITerminDetails terminDetails = sru.createTermin(
								userId, heimspiel, liga, terminDatum,
								terminKurzbeschreibung);
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
						intent.putExtra(AndroidConstants.ERROR_KEY,
								e.getMessage());
						startActivity(intent);
					}
				}
			});
		} catch (ServerRequestException e1) {
			final Intent intent = new Intent(getApplicationContext(),
					ExceptionOccuredActivity.class);
			intent.putExtra(AndroidConstants.ERROR_KEY, e1.getMessage());
			startActivity(intent);
		}

	}

}
