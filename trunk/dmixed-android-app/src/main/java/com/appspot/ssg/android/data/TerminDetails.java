package com.appspot.ssg.android.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminDetails implements ITerminDetails {

	private static final long serialVersionUID = 8925126053355907173L;
	private Long terminId;
	private Long termineDatum;
	private String terminKurzbeschreibung;
	private boolean heimspiel;
	private String terminBeschreibung;
	private List<TerminTeilnehmer> teilnehmer;
	private List<TerminMitbringsel> mitbringsel;

	@Override
	public Long getId() {
		return terminId;
	}

	@Override
	public Date getTermineDatum() {
		return new Date(termineDatum);
	}

	@Override
	public String getTerminKurzbeschreibung() {
		return terminKurzbeschreibung;
	}

	@Override
	public boolean isHeimspiel() {
		return heimspiel;
	}

	@Override
	public String getTerminBeschreibung() {
		return terminBeschreibung;
	}

	@Override
	public List<ITerminTeilnehmer> getTeilnehmer() {
		return teilnehmer != null ? new ArrayList<ITerminTeilnehmer>(teilnehmer) : new ArrayList<ITerminTeilnehmer>();
	}

	@Override
	public List<ITerminMitbringsel> getMitbringsel() {
		return mitbringsel != null ? new ArrayList<ITerminMitbringsel>(mitbringsel) : new ArrayList<ITerminMitbringsel>();
	}

	public void setTerminId(final Long terminId) {
		this.terminId = terminId;
	}

	public void setTermineDatum(final Long termineDatum) {
		this.termineDatum = termineDatum;
	}

	public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
		this.terminKurzbeschreibung = terminKurzbeschreibung;
	}

	public void setHeimspiel(final boolean heimspiel) {
		this.heimspiel = heimspiel;
	}

	public void setTerminBeschreibung(final String terminBeschreibung) {
		this.terminBeschreibung = terminBeschreibung;
	}

	public void setTeilnehmer(final List<TerminTeilnehmer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public void setMitbringsel(final List<TerminMitbringsel> mitbringsel) {
		this.mitbringsel = mitbringsel;
	}

	@Override
	public ILiga getLiga() {
	    // TODO Auto-generated method stub
	    return null;
	}

}
