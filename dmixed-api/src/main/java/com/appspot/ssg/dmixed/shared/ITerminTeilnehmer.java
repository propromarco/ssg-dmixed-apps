package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;

public interface ITerminTeilnehmer extends Serializable {

    Long getId();

    String getVorname();

    String getName();

    boolean isTeilnahme();

    void setTeilnahme(boolean teilnahme);

}
