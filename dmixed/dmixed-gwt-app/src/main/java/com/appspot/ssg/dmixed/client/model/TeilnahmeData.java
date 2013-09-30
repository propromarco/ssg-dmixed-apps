package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITeilnahmeData;

public class TeilnahmeData extends HasId implements ITeilnahmeData {

    private static final long serialVersionUID = 4366229073886046490L;

    @Override
    public Long getTerminId() {
	return getLong("terminId");
    }

    @Override
    public void setTerminId(final Long terminId) {
	setLong("terminId", terminId);
    }

    @Override
    public Long getKindId() {
	return getLong("kindId");
    }

    @Override
    public void setKindId(final Long kindId) {
	setLong("kindId", kindId);
    }

    @Override
    public ETeilnahmeStatus getTeilnahme() {
	final String s = getString("teilnahme");
	return ETeilnahmeStatus.valueOf(s);
    }

    @Override
    public void setTeilnahme(final ETeilnahmeStatus teilnahme) {
	setString("teilnahme", teilnahme.name());
    }

}
