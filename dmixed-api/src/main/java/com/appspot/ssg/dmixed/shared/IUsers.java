package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;
import java.util.List;

public interface IUsers extends Serializable {
    List<IUserData> getAll();
}
