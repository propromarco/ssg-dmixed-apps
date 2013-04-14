package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;

public interface ITerminTeilnehmer extends Serializable {

    String getVorname();

    String getName();

    boolean isTeilnahme();
}
