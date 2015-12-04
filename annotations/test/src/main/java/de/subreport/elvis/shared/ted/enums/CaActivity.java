package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElement;

public enum CaActivity implements HasXMLElement {
	DEFENCE("mainactiv_defence"),
	ECONOMIC_AND_FINANCIAL_AFFAIRS("mainactiv_economic"),
	EDUCATION("mainactiv_education"),
	ENVIRONMENT("mainactiv_environment"),
	GENERAL_PUBLIC_SERVICES("mainactiv_general"),
	HEALTH("mainactiv_health"),
	HOUSING_AND_COMMUNITY_AMENITIES("mainactiv_housing"),
	PUBLIC_ORDER_AND_SAFETY("mainactiv_safety"),
	RECREATION_CULTURE_AND_RELIGION("mainactiv_culture"),
	SOCIAL_PROTECTION("mainactiv_social"),
	OTHER("other_activity");

	private String name;

	private CaActivity(String name) {
		this.name = name;
	}

	@Override
	public String getElementName() {
		return name;
	}
}
