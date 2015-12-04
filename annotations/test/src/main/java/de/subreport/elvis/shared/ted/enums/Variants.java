package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum Variants implements HasXMLElementWithPath {
	ACCEPTED_VARIANTS("_yes", "ACCEPTEDVARIANTS"),
	NO_ACCEPTED_VARIANTS("_no", "NOACCEPTEDVARIANTS");

	private String name;
	private String path;

	private Variants(String name, String path) {
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
