package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;
import java.util.List;

public interface IUserData extends Serializable {

    Long getId();

    String getName();

    String getEmail();

    List<IKind> getKinder();

    boolean isAdmin();

}
