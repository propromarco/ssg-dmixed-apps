package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.IMitbringData;

public class MitbringData implements IMitbringData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long terminId;
	private Long mitbringselId;
	private Boolean mitbringen;

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