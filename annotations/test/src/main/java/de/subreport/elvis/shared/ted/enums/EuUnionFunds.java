package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum EuUnionFunds implements HasXMLElementWithPath {
	EU_PROGRAM_RELATED("_yes", "EUPROGRRELATED"),
	NO_EU_PROGRAM_RELATED("_no", "NOEUPROGRRELATED");

	private String name;
	private String path;

	private EuUnionFunds(String name, String path) {
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
