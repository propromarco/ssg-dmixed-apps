package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;
import java.util.List;

public interface ITermine extends Serializable {
    List<ITermin> getAll();
}
