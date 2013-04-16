package com.appspot.ssg.dmixed.server.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.appspot.ssg.dmixed.shared.ITermin;

@Entity
@Table(name = "termin")
public class JPATermin implements ITermin {
    private static final long serialVersionUID = -2074181411290603332L;

    @Id
    private Long terminId;
    @Column
    private boolean heimspiel;
    @Column
    private Date termineDatum;
    @Column
    private String terminKurzbeschreibung;
    @Column
    private String terminBeschreibung;

    private List<JPATerminMitbringsel> mitbringsel;

    public JPATermin() {
    }

    public JPATermin(long terminId, Date termineDatum, String terminKurzbeschreibung, String terminBeschreibung) {
        this.terminId = terminId;
        this.termineDatum = termineDatum;
        this.terminKurzbeschreibung = terminKurzbeschreibung;
        this.terminBeschreibung = terminBeschreibung;
    }

    public Long getTerminId() {
        return terminId;
    }

    public void setTerminId(Long terminId) {
        this.terminId = terminId;
    }

    public boolean isHeimspiel() {
        return heimspiel;
    }

    public void setHeimspiel(boolean heimspiel) {
        this.heimspiel = heimspiel;
    }

    public Date getTermineDatum() {
        return termineDatum;
    }

    public void setTermineDatum(Date termineDatum) {
        this.termineDatum = termineDatum;
    }

    public String getTerminKurzbeschreibung() {
        return terminKurzbeschreibung;
    }

    public void setTerminKurzbeschreibung(String terminKurzbeschreibung) {
        this.terminKurzbeschreibung = terminKurzbeschreibung;
    }

    public final String getTerminBeschreibung() {
        return terminBeschreibung;
    }

    public final void setTerminBeschreibung(String terminBeschreibung) {
        this.terminBeschreibung = terminBeschreibung;
    }

    public void setMitbringsel(List<JPATerminMitbringsel> mitbringsel) {
        this.mitbringsel = mitbringsel;
    }

    public List<JPATerminMitbringsel> getMitbringsel() {
        return mitbringsel;
    }

}
