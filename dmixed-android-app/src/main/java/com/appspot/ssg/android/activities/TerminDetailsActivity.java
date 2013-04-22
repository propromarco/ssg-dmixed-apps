package com.appspot.ssg.android.activities;

import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.server.ServerRequestUtil;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.termin_details);
	}

	@Override
	protected void onResume() {
		super.onResume();
		final Resources resources = getResources();
		Drawable heimspielBitmap = resources.getDrawable(R.drawable.heim);
		Drawable auswaertsBitmap = resources.getDrawable(
				R.drawable.auswaerts);
		Drawable dabei = resources.getDrawable(R.drawable.dabei);
		Drawable nichtDabei = resources
				.getDrawable(R.drawable.nicht_dabei);

		ITermin termin = (ITermin) getIntent().getExtras().get(
				AndroidConstants.TERMIN_KEY);
		if (termin != null) {
			ITerminDetails details = ServerRequestUtil.getTerminDetails(
					AndroidConstants.getUserId(this), termin.getTerminId());
			TextView terminInfo = (TextView) findViewById(R.id.TerminInfo);
			terminInfo.setText(AndroidConstants.formatDate(details
					.getTermineDatum())
					+ " "
					+ details.getTerminKurzbeschreibung());
			ImageView spielTyp = (ImageView) findViewById(R.id.TerminSpielTyp);
			spielTyp.setImageDrawable(details.isHeimspiel() ? heimspielBitmap
					: auswaertsBitmap);
			TextView beschreibung = (TextView) findViewById(R.id.TerminBeschreibung);
			beschreibung.setText(details.getTerminBeschreibung());
			{// Teilnehmer
				TableLayout teilnehmerTabelle = (TableLayout) findViewById(R.id.TeilnehmerTabelle);
				teilnehmerTabelle.removeAllViews();
				List<ITerminTeilnehmer> teilnehmer = details.getTeilnehmer();
				for (ITerminTeilnehmer t : teilnehmer) {
					TableRow row = new TableRow(this);
					ImageView imageView = new ImageView(this);
					// LayoutParams layoutParams = new LayoutParams(30, 30);
					// imageView.setLayoutParams(layoutParams);
					imageView.setImageDrawable(t.isTeilnahme() ? dabei
							: nichtDabei);
					row.addView(imageView);
					TextView teilnehmerView = new TextView(this);
					teilnehmerView.setText(t.getVorname() + " " + t.getName());
					row.addView(teilnehmerView);
					teilnehmerTabelle.addView(row);
				}
			}
			{// Mitbringsel
				TableLayout mitbringselTabelle = (TableLayout) findViewById(R.id.mitbringselTable);
				mitbringselTabelle.removeAllViews();
				List<ITerminMitbringsel> mitbringsel = details.getMitbringsel();
				for (ITerminMitbringsel m : mitbringsel) {
					ITerminTeilnehmer mitbringer = m.getMitbringer();
					String bez = mitbringer.getVorname() + " "
							+ mitbringer.getName() + " bringt mit: "
							+ m.getBeschreibung();
					TextView textView = new TextView(this);
					textView.setText(bez);
					mitbringselTabelle.addView(textView);
				}

			}
		} else {

		}
	}

}
