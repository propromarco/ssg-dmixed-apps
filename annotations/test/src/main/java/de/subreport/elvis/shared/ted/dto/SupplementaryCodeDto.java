package de.subreport.elvis.shared.ted.dto;

import com.google.gwt.user.client.rpc.GwtTransient;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.dto.abstrakt.CodeDto;

public class SupplementaryCodeDto extends CodeDto<SupplementaryCodeDto> {

	private static final long serialVersionUID = 5767304422794215499L;

	@GwtTransient
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	@Mapping("CODE")
	public String getCode() {
		return code;
	}

}
