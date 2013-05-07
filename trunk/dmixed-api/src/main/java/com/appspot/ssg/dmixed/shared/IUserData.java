package com.appspot.ssg.dmixed.shared;

import java.util.List;

public interface IUserData extends WithId {

    String getName();

    String getEmail();

    List<IKind> getKinder();

    boolean isAdmin();

}
