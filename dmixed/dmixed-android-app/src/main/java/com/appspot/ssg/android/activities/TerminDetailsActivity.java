package com.appspot.ssg.android.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.appspot.ssg.android.activities.menu.MenuDefaultSupport;
import com.appspot.ssg.android.activities.menu.TerminDetailsAdminMenuSupport;
import com.appspot.ssg.android.data.AndroidConstants;
import com.appspot.ssg.android.server.ServerRequestException;
import com.appspot.ssg.android.server.ServerRequestUtil;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminDetailsActivity extends Activity {
	private final ServerRequestUtil sru = new ServerRequestUtil();
	private MenuDefaultSupport ms;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.termin_details);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		return ms.onCreateOptionsMenu(this, menu);
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		return ms.onOptionsItemSelected(this, item);
	}

	@Override
	protected void onResume() {
		super.onResume();
		final boolean admin = AndroidConstants.isAdmin(this);
		if (admin) {
			ms = new TerminDetailsAdminMenuSupport();
		} else {
			ms = new MenuDefaultSupport();
		}
		final Resources resources = getResources();
		final Drawable heimspielBitmap = resources.getDrawable(R.drawable.heim);
		final Drawable auswaertsBitmap = resources
				.getDrawable(R.drawable.auswaerts);
		final Drawable dabei = resources.getDrawable(R.drawable.gruen);
		final Drawable vielleicht = resources.getDrawable(R.drawable.gelb);
		final Drawable nichtDabei = resources.getDrawable(R.drawable.rot);

		final ITermin termin = (ITermin) getIntent().getExtras().get(
				AndroidConstants.TERMIN_KEY);
		if (termin != null) {
			try {
				final long userId = AndroidConstants.getUserId(this);
				final Long terminId = termin.getId();
				final ITerminDetails details = sru.getTerminDetails(userId,
						terminId);
				final TextView terminInfo = (TextView) findViewById(R.id.TerminDetailsInfo);
				terminInfo.setText(AndroidConstants.formatDate(details
						.getTermineDatum())
						+ " "
						+ details.getTerminKurzbeschreibung());
				final ImageView spielTyp = (ImageView) findViewById(R.id.TerminDetailsSpielTyp);
				spielTyp.setImageDrawable(details.isHeimspiel() ? heimspielBitmap
						: auswaertsBitmap);
				final TextView beschreibung = (TextView) findViewById(R.id.TerminDetailsBeschreibung);
				beschreibung.setText(details.getTerminBeschreibung());
				{// Teilnehmer
					final TableLayout teilnehmerTabelle = (TableLayout) findViewById(R.id.TerminDetailsTeilnehmerTabelle);
					teilnehmerTabelle.removeAllViews();
					final List<ITerminTeilnehmer> teilnehmer = details
							.getTeilnehmer();
					for (final ITerminTeilnehmer t : teilnehmer) {
						final TableRow row = new TableRow(this);
						final ImageView imageView = new ImageView(this);
						// LayoutParams layoutParams = new LayoutParams(30, 30);
						// imageView.setLayoutParams(layoutParams);
						final ETeilnahmeStatus teilnahme = t.getTeilnahme();
						final Drawable drawable = teilnahme == ETeilnahmeStatus.NimmtTeil ? dabei
								: teilnahme == ETeilnahmeStatus.Vielleicht ? vielleicht
										: nichtDabei;
						imageView.setImageDrawable(drawable);
						if (t.getId() == userId) {
							imageView.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(final View v) {
									try {
										final ETeilnahmeStatus oldTeilnahme = t
												.getTeilnahme();
										final ETeilnahmeStatus newTeilnahme = nextTeilnahme(oldTeilnahme);
										sru.setTeilnahme(newTeilnahme,
												terminId, userId);
										t.setTeilnahme(newTeilnahme);
										imageView
												.setImageDrawable(newTeilnahme == ETeilnahmeStatus.NimmtTeil ? dabei
														: newTeilnahme == ETeilnahmeStatus.Vielleicht ? vielleicht
																: nichtDabei);
									} catch (final ServerRequestException e) {
										final Intent intent = new Intent(v
												.getContext(),
												ExceptionOccuredActivity.class);
										intent.putExtra(
												AndroidConstants.ERROR_KEY,
												e.getMessage());
										startActivity(intent);
									}
								}

								private ETeilnahmeStatus nextTeilnahme(
										final ETeilnahmeStatus oldTeilnahme) {
									switch (oldTeilnahme) {
									case NimmtTeil:
										return ETeilnahmeStatus.Vielleicht;
									case Vielleicht:
										return ETeilnahmeStatus.NimmtNichtTeil;
									default:
										return ETeilnahmeStatus.NimmtTeil;
									}
								}
							});
						}
						row.addView(imageView);
						final TextView teilnehmerView = new TextView(this);
						teilnehmerView.setText(t.getVorname() + " "
								+ t.getName());
						row.addView(teilnehmerView);
						teilnehmerTabelle.addView(row);
					}
				}
				{// Mitbringsel
					final TableLayout mitbringselTabelle = (TableLayout) findViewById(R.id.TerminDetailsMitbringselTable);
					mitbringselTabelle.removeAllViews();
					final List<ITerminMitbringsel> mitbringsel = details
							.getMitbringsel();
					for (final ITerminMitbringsel m : mitbringsel) {
						final ITerminTeilnehmer mitbringer = m.getMitbringer();
						final StringBuilder sb = createStringBuilder(m);
						final TextView textView = new TextView(this);
						if (mitbringer == null || mitbringer.getId() == userId) {
							textView.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(final View v) {
									try {
										final boolean mitbringen = m
												.getMitbringer() == null;
										sru.addMitbringsel(userId, terminId,
												true, m.getId(), mitbringen);
										onResume();
									} catch (final ServerRequestException e) {
										final Intent intent = new Intent(v
												.getContext(),
												ExceptionOccuredActivity.class);
										intent.putExtra(
												AndroidConstants.ERROR_KEY,
												e.getMessage());
										startActivity(intent);
									}
								}

							});
						}
						if (mitbringer == null)
							sb.append(". Wollen Sie das mitbringen?");
						textView.setText(sb.toString());
						mitbringselTabelle.addView(textView);
					}

				}
			} catch (final ServerRequestException e) {
				final Intent intent = new Intent(getApplicationContext(),
						ExceptionOccuredActivity.class);
				intent.putExtra(AndroidConstants.ERROR_KEY, e.getMessage());
				startActivity(intent);
				finish();
			}
		} else {

		}
	}

	private StringBuilder createStringBuilder(final ITerminMitbringsel m) {
		final ITerminTeilnehmer mitbringer = m.getMitbringer();
		final StringBuilder sb = new StringBuilder();
		if (mitbringer != null) {
			sb.append(mitbringer.getVorname());
			sb.append(" ");
			sb.append(mitbringer.getName());
			sb.append(" bringt mit: ");
		} else {
			sb.append("Bisher bringt noch keiner mit: ");
		}
		sb.append(m.getBeschreibung());
		return sb;
	}

}
