package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.ITeilnahmeData;

@XmlRootElement
public class TeilnahmeData implements ITeilnahmeData {

    private static final long serialVersionUID = 3284373595974774682L;

    private Long _userId;
    private Long _terminId;
    private Boolean _teilnahme;

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

    @Override
    public Boolean getTeilnahme() {
        return _teilnahme;
    }

    @Override
    public void setTeilnahme(final Boolean teilnahme) {
        _teilnahme = teilnahme;
    }

}
