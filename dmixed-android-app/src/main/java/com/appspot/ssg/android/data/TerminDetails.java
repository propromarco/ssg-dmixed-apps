package com.appspot.ssg.android.data;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class TerminDetails implements ITerminDetails {

	private static final long serialVersionUID = 8925126053355907173L;
	private Long terminId;
	private Date termineDatum;
	private String terminKurzbeschreibung;
	private boolean heimspiel;
	private String terminBeschreibung;
	private List<ITerminTeilnehmer> teilnehmer;
	private List<ITerminMitbringsel> mitbringsel;

	@Override
	public Long getTerminId() {
		return terminId;
	}

	@Override
	public Date getTermineDatum() {
		return termineDatum;
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
		return teilnehmer;
	}

	@Override
	public List<ITerminMitbringsel> getMitbringsel() {
		return mitbringsel;
	}

	public void setTerminId(Long terminId) {
		this.terminId = terminId;
	}

	public void setTermineDatum(Date termineDatum) {
		this.termineDatum = termineDatum;
	}

	public void setTerminKurzbeschreibung(String terminKurzbeschreibung) {
		this.terminKurzbeschreibung = terminKurzbeschreibung;
	}

	public void setHeimspiel(boolean heimspiel) {
		this.heimspiel = heimspiel;
	}

	public void setTerminBeschreibung(String terminBeschreibung) {
		this.terminBeschreibung = terminBeschreibung;
	}

	public void setTeilnehmer(List<ITerminTeilnehmer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public void setMitbringsel(List<ITerminMitbringsel> mitbringsel) {
		this.mitbringsel = mitbringsel;
	}

}
