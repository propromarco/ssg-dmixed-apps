package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElement;

public enum CeActivity implements HasXMLElement {

	AIRPORT_RELATED_ACTIVITIES("mainactiv_aitport"),
	ELECTRICITY("mainactive_electricity"),
	EXPLORATION_EXTRACTION_COAL_OTHER_SOLID_FUEL("mainactiv_coal"),
	EXPLORATION_EXTRACTION_GAS_OIL("mainactiv_gas"),
	PORT_RELATED_ACTIVITIES("mainactiv_port"),
	POSTAL_SERVICES("mainactiv_postal"),
	PRODUCTION_TRANSPORT_DISTRIBUTION_GAS_HEAT("mainactiv_distribution_gas"),
	RAILWAY_SERVICES("mainactiv_railway"),
	URBAN_RAILWAY_TRAMWAY_TROLLEYBUS_BUS_SERVICES("mainactive_urban"),
	WATER("mainactiv_water"),
	OTHER("other_activity");

	private String name;

	private CeActivity(String name) {
		this.name = name;
	}

	@Override
	public String getElementName() {
		return name;
	}
}
