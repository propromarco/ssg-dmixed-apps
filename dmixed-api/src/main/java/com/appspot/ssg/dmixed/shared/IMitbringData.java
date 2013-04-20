package com.appspot.ssg.dmixed.shared;

import java.io.Serializable;

public interface IMitbringData extends Serializable {

    Long getUserId();

    void setUserId(Long userId);

    Long getTerminId();

    void setTerminId(Long terminId);

    Long getMitbringselId();

    void setMitbringselId(Long mitbringselId);

    Boolean getMitbringen();

    void setMitbringen(Boolean mitbringen);

}
