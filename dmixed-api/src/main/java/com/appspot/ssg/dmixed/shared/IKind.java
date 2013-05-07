package com.appspot.ssg.dmixed.shared;

import java.util.Date;

public interface IKind extends WithId {

    String getVorname();

    Date getBirthday();

    ILiga getLiga();

}
