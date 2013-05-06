package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;
import java.util.Date;

public interface IKind extends Serializable {

    Long getId();

    String getVorname();

    Date getBirthday();
    
    ILiga getLiga();

}
