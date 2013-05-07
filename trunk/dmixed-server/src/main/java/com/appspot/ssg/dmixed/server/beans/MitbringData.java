package com.appspot.ssg.dmixed.server.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.appspot.ssg.dmixed.shared.IMitbringData;

@XmlRootElement
public class MitbringData extends HasId implements IMitbringData {

    private static final long serialVersionUID = -1422394781628028447L;

    private Long terminId;
    private Boolean teilnahme;
    private Long mitbringselId;
    private Boolean mitbringen;

    @Override
    public Long getTerminId() {
	return terminId;
    }

    @Override
    public void setTerminId(final Long terminId) {
	this.terminId = terminId;
    }

    public final Boolean getTeilnahme() {
	return teilnahme;
    }

    public final void setTeilnahme(final Boolean teilnahme) {
	this.teilnahme = teilnahme;
    }

    @Override
    public Long getMitbringselId() {
	return mitbringselId;
    }

    @Override
    public void setMitbringselId(final Long mitbringselId) {
	this.mitbringselId = mitbringselId;
    }

    @Override
    public Boolean getMitbringen() {
	return mitbringen;
    }

    @Override
    public void setMitbringen(final Boolean mitbringen) {
	this.mitbringen = mitbringen;
    }

}
