package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;

public interface ITeilnahmeData extends Serializable {

    Long getUserId();

    void setUserId(Long userId);

    Long getTerminId();

    void setTerminId(Long terminId);

    Boolean getTeilnahme();

    void setTeilnahme(Boolean teilnahme);

}
