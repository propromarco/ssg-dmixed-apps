package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITeilnahmeData;

public class TeilnahmeData implements ITeilnahmeData {

    private static final long serialVersionUID = 8080807108232258277L;
    private Long userId;
    private Long terminId;
    private Long kindId;
    private ETeilnahmeStatus teilnahme;

    @Override
    public Long getId() {
	return userId;
    }

    @Override
    public void setId(final Long userId) {
	this.userId = userId;
    }

    @Override
    public Long getTerminId() {
	return terminId;
    }

    @Override
    public void setTerminId(final Long terminId) {
	this.terminId = terminId;
    }

    @Override
    public Long getKindId() {
	return kindId;
    }

    @Override
    public void setKindId(final Long kindId) {
	this.kindId = kindId;
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
