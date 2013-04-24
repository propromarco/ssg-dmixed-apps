package com.appspot.ssg.android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.dmixed.shared.ITerminDetails;

public class TerminDetailsBearbeitenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_termin);
		ITerminDetails terminDetails = (ITerminDetails) savedInstanceState
				.get(AndroidConstants.TERMIN_DETAILS_KEY);
		if (terminDetails != null) {
			final EditText beschreibungText = (EditText) findViewById(R.id.TerminDetailsBearbeitenBeschreibungEingabe);
			beschreibungText.setText(terminDetails.getTerminBeschreibung());
			final CheckBox heimspiel = (CheckBox) findViewById(R.id.TerminDetailsBearbeitenHeimspielCheckbox);
			heimspiel.setChecked(terminDetails.isHeimspiel());

			final Button speichernButton = (Button) findViewById(R.id.TerminDetailsBearbeitenAendernButton);
			speichernButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					finish();
				}
			});
		}

	}

}
