package com.appspot.ssg.dmixed.shared;

public interface ITeilnahmeData extends WithId {

    void setId(Long id);

    Long getTerminId();

    void setTerminId(Long terminId);

    Long getKindId();
    
    void setKindId(Long kindId);
    
    ETeilnahmeStatus getTeilnahme();

    void setTeilnahme(ETeilnahmeStatus teilnahme);

}
