package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum DivisionLots implements HasXMLElementWithPath {
	YES("_yes", ""),	// YES hat keinen Pfad !!! Wenn YES gewählt wird ist zwingend auch die enum LotDivision gesetzt.
	NO("_no", "NOLOTDIVISION");

	private String name;
	private String path;

	private DivisionLots(String name, String path) {
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
