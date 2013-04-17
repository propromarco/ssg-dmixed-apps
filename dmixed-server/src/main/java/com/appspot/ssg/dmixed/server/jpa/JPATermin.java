package com.appspot.ssg.dmixed.server.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "termin")
public class JPATermin {

    @Id
    @GeneratedValue
    private Long terminId;
    @Column
    private boolean heimspiel;
    @Column
    private Date termineDatum;
    @Column
    private String terminKurzbeschreibung;
    @Column
    private String terminBeschreibung;
    @OneToMany
    private List<JPATerminMitbringsel> mitbringsel;
    @OneToMany
    private List<JPATerminTeilnehmer> teilnehmer;

    public JPATermin() {
    }

    public JPATermin(final long terminId, final Date termineDatum, final String terminKurzbeschreibung, final String terminBeschreibung) {
        this.terminId = terminId;
        this.termineDatum = termineDatum;
        this.terminKurzbeschreibung = terminKurzbeschreibung;
        this.terminBeschreibung = terminBeschreibung;
    }

    public Long getTerminId() {
        return terminId;
    }

    public void setTerminId(final Long terminId) {
        this.terminId = terminId;
    }

    public boolean isHeimspiel() {
        return heimspiel;
    }

    public void setHeimspiel(final boolean heimspiel) {
        this.heimspiel = heimspiel;
    }

    public Date getTermineDatum() {
        return termineDatum;
    }

    public void setTermineDatum(final Date termineDatum) {
        this.termineDatum = termineDatum;
    }

    public String getTerminKurzbeschreibung() {
        return terminKurzbeschreibung;
    }

    public void setTerminKurzbeschreibung(final String terminKurzbeschreibung) {
        this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

    public final String getTerminBeschreibung() {
        return terminBeschreibung;
    }

    public final void setTerminBeschreibung(final String terminBeschreibung) {
        this.terminBeschreibung = terminBeschreibung;
    }

    public void setMitbringsel(final List<JPATerminMitbringsel> mitbringsel) {
        this.mitbringsel = mitbringsel;
    }

    public List<JPATerminMitbringsel> getMitbringsel() {
        return mitbringsel;
    }

}
