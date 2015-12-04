package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum TypeContract implements HasXMLElementWithPath {
	// TypeContract wir nicht auf ein EmptyObject, sondern auf einen String gemappt
	SERVICES("services", "CTYPE"),
	SUPPLIES("supplies", "CTYPE"),
	WORKS("works", "CTYPE");

	private String name;
	private String path;

	private TypeContract(String name, String path) {
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
