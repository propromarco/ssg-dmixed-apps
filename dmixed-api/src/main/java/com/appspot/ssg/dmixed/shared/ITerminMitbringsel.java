package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;

public interface ITerminMitbringsel extends Serializable {
    Long getId();

    String getBeschreibung();

    ITerminTeilnehmer getMitbringer();

    void setMitbringer(ITerminTeilnehmer mitbringer);
}
