package com.appspot.ssg.android.activities;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.appspot.ssg.android.data.AndroidConstants;

public class TerminErstellenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_termin);
		final EditText kurzbeschreibung = (EditText) findViewById(R.id.TerminErstellungKurzbeschreibungEingabe);
		final DatePicker datum = (DatePicker) findViewById(R.id.TerminErstellungDatumsauswahl);
		final Button button = (Button) findViewById(R.id.TerminErstellungErstellenButton);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				final String kurzbeschreibungString = kurzbeschreibung
						.getText().toString().trim();
				if (kurzbeschreibungString.length() > 0
						&& datum.getDayOfMonth() > 0 && datum.getMonth() > 0
						&& datum.getYear() > 0) {
					Date date = AndroidConstants.formatDate(
							datum.getDayOfMonth(), datum.getMonth(),
							datum.getYear());
					// TODO server aufrufen und mit dem Ergebnis (Termin) die Editier-Seite aufrufen
					final Intent intent = new Intent(view.getContext(), TerminDetailsBearbeitenActivity.class);
					// termindetails setzen
					//ITerminDetails terminDetails = ServerRequestUtil.getTerminDetails(AndroidConstants.getUserId(TerminCreationActivity.this), terminId);
					//intent.putExtra(AndroidConstants.TERMIN_DETAILS_KEY, terminDetails);
					startActivityForResult(intent, 10);
				} else {
					StringBuilder sb = new StringBuilder();
					if (kurzbeschreibungString.length() == 0) {
						sb.append("Sie haben noch keine Kurzbeschreibung angegeben.\n");
					}
					if (!(datum.getDayOfMonth() > 0 && datum.getMonth() > 0 && datum
							.getYear() > 0)) {
						sb.append("Bitte noch ein Datum auswählen");
					}
					// TODO fehlermeldung ausgeben...
				}
			}
		});
	}

}
