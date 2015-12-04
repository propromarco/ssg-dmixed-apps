package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum Options implements HasXMLElementWithPath {
	OPTIONS("_yes", "OPTIONS"),
	NO_OPTIONS("_no", "NOOPTIONS");

	private String name;
	private String path;

	private Options(String name, String path) {
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
