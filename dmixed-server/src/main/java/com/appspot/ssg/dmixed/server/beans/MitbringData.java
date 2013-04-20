package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.IMitbringData;

@XmlRootElement
public class MitbringData implements IMitbringData {

    private static final long serialVersionUID = -1422394781628028447L;

    private Long _userId;
    private Long _terminId;
    private Boolean _teilnahme;
    private Long _mitbringselId;
    private Boolean _mitbringen;

    @Override
    public Long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(final Long userId) {
        _userId = userId;
    }

    @Override
    public Long getTerminId() {
        return _terminId;
    }

    @Override
    public void setTerminId(final Long terminId) {
        _terminId = terminId;
    }

    public final Boolean getTeilnahme() {
        return _teilnahme;
    }

    public final void setTeilnahme(final Boolean teilnahme) {
        _teilnahme = teilnahme;
    }

    @Override
    public Long getMitbringselId() {
        return _mitbringselId;
    }

    @Override
    public void setMitbringselId(final Long mitbringselId) {
        _mitbringselId = mitbringselId;
    }

    @Override
    public Boolean getMitbringen() {
        return _mitbringen;
    }

    @Override
    public void setMitbringen(final Boolean mitbringen) {
        _mitbringen = mitbringen;
    }

}
