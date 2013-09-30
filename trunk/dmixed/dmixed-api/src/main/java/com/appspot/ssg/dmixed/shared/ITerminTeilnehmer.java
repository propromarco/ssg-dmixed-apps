package com.appspot.ssg.dmixed.shared;

public interface ITerminTeilnehmer extends WithId {

    boolean isChangeAllowed();

    String getVorname();

    String getName();

    ETeilnahmeStatus getTeilnahme();

    void setTeilnahme(ETeilnahmeStatus teilnahme);

}
