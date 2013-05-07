package com.appspot.ssg.dmixed.shared;


public interface IMitbringData extends WithId {

    void setId(Long id);

    Long getTerminId();

    void setTerminId(Long terminId);

    Long getMitbringselId();

    void setMitbringselId(Long mitbringselId);

    Boolean getMitbringen();

    void setMitbringen(Boolean mitbringen);

}
