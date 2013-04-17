package com.appspot.ssg.dmixed.server.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appspot.ssg.dmixed.server.adapter.DateAdapter;
import com.appspot.ssg.dmixed.server.adapter.TerminMitbringselAdapter;
import com.appspot.ssg.dmixed.server.adapter.TerminTeilnehmerAdapter;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

@XmlRootElement
public class TerminDetails implements ITerminDetails {

    private static final long serialVersionUID = 5321435089982968530L;
    private String terminBeschreibung;
    private String terminKurzbeschreibung;
    private Date termineDatum;
    private Long terminId;
    private boolean heimspiel;
    private List<ITerminTeilnehmer> teilnehmer;
    private List<ITerminMitbringsel> mitbringsel;

    public TerminDetails() {
    }

    @Override
    public Long getTerminId() {
        return terminId;
    }

    public void setTerminId(final Long terminId) {
        this.terminId = terminId;
    }

    @Override
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getTermineDatum() {
        return termineDatum;
    }

    public void setTermineDatum(final Date termineDatum) {
        this.termineDatum = termineDatum;
    }

    @Override
    public String getTerminKurzbeschreibung() {
        return terminKurzbeschreibung;
    }

    public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
        this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

    @Override
    public String getTerminBeschreibung() {
        return terminBeschreibung;
    }

    public void setTerminBeschreibung(final String terminBeschreibung) {
        this.terminBeschreibung = terminBeschreibung;
    }

    @Override
    public boolean isHeimspiel() {
        return heimspiel;
    }

    public void setHeimspiel(final boolean heimspiel) {
        this.heimspiel = heimspiel;
    }

    @Override
    @XmlJavaTypeAdapter(TerminTeilnehmerAdapter.class)
    public List<ITerminTeilnehmer> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(final List<ITerminTeilnehmer> teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    @Override
    @XmlJavaTypeAdapter(TerminMitbringselAdapter.class)
    public List<ITerminMitbringsel> getMitbringsel() {
        return mitbringsel;
    }

    public void setMitbringsel(final List<ITerminMitbringsel> mitbringsel) {
        this.mitbringsel = mitbringsel;
    }

}
