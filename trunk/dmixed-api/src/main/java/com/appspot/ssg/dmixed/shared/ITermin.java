package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;
import java.util.Date;

public interface ITermin extends Serializable {
    Long getTerminId();

    Date getTermineDatum();

    String getTerminKurzbeschreibung();

}
