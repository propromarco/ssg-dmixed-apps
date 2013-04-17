package com.appspot.ssg.dmixed.shared;

import java.util.List;

public interface ITerminDetails extends ITermin {

    boolean isHeimspiel();

    String getTerminBeschreibung();

    List<ITerminTeilnehmer> getTeilnehmer();

    List<ITerminMitbringsel> getMitbringsel();

}
