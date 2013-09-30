package com.appspot.ssg.dmixed.shared;

import java.util.Date;

public interface ITerminCreate extends WithId {
    Date getTerminDatum();

    String getTerminBeschreibung();

    String getTerminKurzbeschreibung();

    Long getLiga();

    boolean isHeimspiel();

}
