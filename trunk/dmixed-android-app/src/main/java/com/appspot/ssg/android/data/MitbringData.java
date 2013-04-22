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
	public Long getUserId() {
		return userId;
	}

	@Override
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public Long getTerminId() {
		return terminId;
	}

	@Override
	public void setTerminId(Long terminId) {
		this.terminId = terminId;
	}

	@Override
	public Long getMitbringselId() {
		return mitbringselId;
	}

	@Override
	public void setMitbringselId(Long mitbringselId) {
		this.mitbringselId = mitbringselId;
	}

	@Override
	public Boolean getMitbringen() {
		return mitbringen;
	}

	@Override
	public void setMitbringen(Boolean mitbringen) {
		this.mitbringen = mitbringen;
	}

}