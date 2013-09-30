package com.appspot.ssg.dmixed.shared;

public interface ITerminMitbringsel extends WithId {

    String getBeschreibung();

    ITerminTeilnehmer getMitbringer();

    void setMitbringer(ITerminTeilnehmer mitbringer);
}
