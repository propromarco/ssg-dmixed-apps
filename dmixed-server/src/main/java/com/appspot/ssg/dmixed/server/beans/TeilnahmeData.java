package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITeilnahmeData;

@XmlRootElement
public class TeilnahmeData extends HasId implements ITeilnahmeData {

    private static final long serialVersionUID = 3284373595974774682L;

    private Long terminId;
    private ETeilnahmeStatus teilnahme;

    @Override
    public Long getTerminId() {
	return terminId;
    }

    @Override
    public void setTerminId(final Long terminId) {
	this.terminId = terminId;
    }

    @Override
    public ETeilnahmeStatus getTeilnahme() {
	return teilnahme;
    }

    @Override
    public void setTeilnahme(final ETeilnahmeStatus teilnahme) {
	this.teilnahme = teilnahme;
    }

}
