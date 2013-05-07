package com.appspot.ssg.dmixed.shared;

import java.util.Date;

public interface ITermin extends WithId {
    Date getTermineDatum();

    String getTerminKurzbeschreibung();

}
