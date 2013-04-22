package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;
import java.util.Date;

public interface IUserData extends Serializable {

    Long getId();

    String getVorname();

    String getName();

    String getEmail();

    Date getBirthday();

    boolean isAdmin();

}
