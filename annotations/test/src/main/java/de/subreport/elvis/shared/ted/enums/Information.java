package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum Information implements HasXMLElementWithPath {
	ADDRESS_FURTHER_INFO_IDEM("address_to_above", "ADDRESSFURTHERINFOIDEM"),
	ADDRESS_FURTHER_INFO("address_another", "");	// Kein Pfad, WEN ADDRESS_FURTHER_INFO gewählt ist, ist ADDRESSFURTHERINFO gezwungenermaßen gesetzt

	private String name;
	private String path;

	private Information(String name, String path) {
		this.name = name;
		this.path = path;
	}

	@Override
	public String getElementName() {
		return name;
	}

	@Override
	public String getElementPath() {
		return path;
	}
}
