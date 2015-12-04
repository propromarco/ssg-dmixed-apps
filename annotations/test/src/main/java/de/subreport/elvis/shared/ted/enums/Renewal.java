package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum Renewal implements HasXMLElementWithPath {
	RENEWAL("_yes", "RENEWAL"),
	NO_RENEWAL("_no", "NORENEWAL");

	private String name;
	private String path;

	private Renewal(String name, String path) {
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
