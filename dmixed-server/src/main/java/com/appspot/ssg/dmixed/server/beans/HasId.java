package com.appspot.ssg.dmixed.server.beans;

import com.appspot.ssg.dmixed.shared.WithId;

public abstract class HasId implements WithId {

    private static final long serialVersionUID = -6565948970859748465L;

    private Long id;

    @Override
    public Long getId() {
	return id;
    }

    public void setId(final Long id) {
	this.id = id;
    }
}
