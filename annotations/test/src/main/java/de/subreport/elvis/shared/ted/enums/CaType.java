package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElement;

public enum CaType implements HasXMLElement {
	BODY_PUBLIC("maintype_publicbody"),
	EU_INSTITUTION("maintype_eu"),
	MINISTRY("maintype_ministry"),
	NATIONAL_AGENCY("maintype_natagency"),
	REGIONAL_AGENCY("maintype_localagency"),
	REGIONAL_AUTHORITY("maintype_localauth"),
	OTHER("other_type");

	private String name;

	private CaType(String name) {
		this.name = name;
	}

	@Override
	public String getElementName() {
		return name;
	}

}
