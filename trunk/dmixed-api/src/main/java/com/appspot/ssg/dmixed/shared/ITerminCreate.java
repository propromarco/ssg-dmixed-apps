package com.appspot.ssg.dmixed.shared;

import java.util.Date;

public interface ITerminCreate extends WithId {
    Date getTerminDatum();

    String getTerminKurzbeschreibung();

    ILiga getLiga();

    boolean isHeimspiel();

}
