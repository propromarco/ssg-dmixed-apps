package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum TenderRequest implements HasXMLElementWithPath {
	ADDRESS_PARTICIPATION_IDEM("address_to_above", "ADDRESSPARTICIPATIONIDEM"),
	ADDRESS_PARTICIPATION("address_following", ""); 	// Kein Pfad, wenn ADDRESS_PARTICIPATION gewählt ist, ist ADDRESSPARTICIPATION gezwungenermaßen gesetzt

	private String name;
	private String path;

	private TenderRequest(String name, String path) {
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
