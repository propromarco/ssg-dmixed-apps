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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appspot.ssg.android.activities.menu.MenuDefaultSupport;
import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.data.TerminDetails;
import com.appspot.ssg.android.server.ServerRequestUtil;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminDetailsBearbeitenActivity extends Activity {
    private final ServerRequestUtil sru = new ServerRequestUtil();
    private final MenuDefaultSupport mds = new MenuDefaultSupport();

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
	return mds.onCreateOptionsMenu(this, menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
	return mds.onOptionsItemSelected(this, item);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.edit_termin);
	final TerminDetails terminDetails = (TerminDetails) savedInstanceState.get(AndroidConstants.TERMIN_DETAILS_KEY);
	if (terminDetails != null) {
	    {
		final String[] split = AndroidConstants.formatDate(terminDetails.getTermineDatum()).split(".");
		((DatePicker) findViewById(R.id.TerminDetailsDatumAuswahl)).updateDate(Integer.parseInt(split[2]), Integer.parseInt(split[1]),
			Integer.parseInt(split[0]));
	    }
	    ((EditText) findViewById(R.id.TerminDetailsBeschreibung)).setContentDescription(terminDetails.getTerminBeschreibung());
	    ((EditText) findViewById(R.id.TerminDetailsKurzbeschreibung)).setContentDescription(terminDetails.getTerminKurzbeschreibung());
	    ((CheckBox) findViewById(R.id.TerminDetailsHeimspielCheckbox)).setChecked(terminDetails.isHeimspiel());
	    final LinearLayout teilnehmerListe = (LinearLayout) findViewById(R.id.TerminDetailsTeilnehmerListe);
	    teilnehmerListe.removeAllViews();
	    for (final ITerminTeilnehmer teilnehmer : terminDetails.getTeilnehmer()) {
		final TextView textView = new TextView(this);
		textView.setContentDescription(teilnehmer.getVorname() + " " + teilnehmer.getName());
		teilnehmerListe.addView(textView);
	    }
	    final LinearLayout mitbringselListe = (LinearLayout) findViewById(R.id.TerminDetailsMitbringselListe);
	    mitbringselListe.removeAllViews();
	    for (final ITerminMitbringsel mitbringsel : terminDetails.getMitbringsel()) {
		final TextView textView = new TextView(this);
		textView.setContentDescription(mitbringsel.getBeschreibung());
		mitbringselListe.addView(textView);
	    }
	    final Button speichernButton = (Button) findViewById(R.id.TerminDetailsBearbeitenAendernButton);
	    speichernButton.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(final View v) {
		    {
			final DatePicker datePicker = (DatePicker) findViewById(R.id.TerminDetailsDatumAuswahl);
			terminDetails.setTermineDatum(AndroidConstants.formatDate(datePicker.getDayOfMonth(), datePicker.getMonth(),
				datePicker.getYear()).getTime());
		    }
		    terminDetails.setTerminBeschreibung((((EditText) findViewById(R.id.TerminDetailsBeschreibung)).getContentDescription())
			    .toString());
		    terminDetails.setTerminKurzbeschreibung(((EditText) findViewById(R.id.TerminDetailsKurzbeschreibung)).getContentDescription()
			    .toString());
		    terminDetails.setHeimspiel(((CheckBox) findViewById(R.id.TerminDetailsHeimspielCheckbox)).isChecked());
//		    final long userId = AndroidConstants.getUserId(TerminDetailsBearbeitenActivity.this);
//		    try {
			// TODO sru.updateTermin(userId, terminDetails);
			final Intent intent = new Intent(TerminDetailsBearbeitenActivity.this, TerminUebersichtActrivity.class);
			startActivity(intent);
			finish();
//		    } catch (final ServerRequestException e) {
//			final Intent intent = new Intent(TerminDetailsBearbeitenActivity.this, ExceptionOccuredActivity.class);
//			intent.putExtra(AndroidConstants.ERROR_KEY, e.getMessage());
//			startActivity(intent);
//		    }
		}
	    });
	}

    }
}
