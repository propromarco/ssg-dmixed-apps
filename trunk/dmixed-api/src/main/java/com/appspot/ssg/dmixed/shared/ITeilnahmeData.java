package com.appspot.ssg.dmixed.shared;

public interface ITeilnahmeData extends WithId {

    void setId(Long id);

    Long getTerminId();

    void setTerminId(Long terminId);

    ETeilnahmeStatus getTeilnahme();

    void setTeilnahme(ETeilnahmeStatus teilnahme);

}
