package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.IMitbringData;

public class MitbringData extends AbstractData implements IMitbringData {

    private static final long serialVersionUID = -8062983896652043376L;

    @Override
    public Long getUserId() {
        return getLong("userId");
    }

    @Override
    public void setUserId(final Long userId) {
        setLong("userId", userId);
    }

    @Override
    public Long getTerminId() {
        return getLong("terminId");
    }

    @Override
    public void setTerminId(final Long terminId) {
        setLong("terminId", terminId);
    }

    @Override
    public Long getMitbringselId() {
        return getLong("mitbringselId");
    }

    @Override
    public void setMitbringselId(final Long mitbringselId) {
        setLong("mitbringselId", mitbringselId);
    }

    @Override
    public Boolean getMitbringen() {
        return getBoolean("mitbringen");
    }

    @Override
    public void setMitbringen(final Boolean mitbringen) {
        setBoolean("mitbringen", mitbringen);
    }

}
