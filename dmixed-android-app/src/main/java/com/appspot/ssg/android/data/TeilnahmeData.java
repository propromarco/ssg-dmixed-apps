package com.appspot.ssg.android.data;

import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITeilnahmeData;

public class TeilnahmeData implements ITeilnahmeData {

	private static final long serialVersionUID = 8080807108232258277L;
	private Long userId;
	private Long terminId;
	private ETeilnahmeStatus teilnahme;

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
	public ETeilnahmeStatus getTeilnahme() {
		return teilnahme;
	}

	@Override
	public void setTeilnahme(ETeilnahmeStatus teilnahme) {
		this.teilnahme = teilnahme;
	}

}
