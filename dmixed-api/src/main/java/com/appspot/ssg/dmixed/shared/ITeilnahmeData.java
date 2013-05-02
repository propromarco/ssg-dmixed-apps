package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;

public interface ITeilnahmeData extends Serializable {

    Long getUserId();

    void setUserId(Long userId);

    Long getTerminId();

    void setTerminId(Long terminId);

    ETeilnahmeStatus getTeilnahme();

    void setTeilnahme(ETeilnahmeStatus teilnahme);

}
