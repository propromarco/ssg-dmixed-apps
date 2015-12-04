package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum LotDivision implements HasXMLElementWithPath {
	LOT_ALL("lots_all", "LOTALL"),
	LOT_MAX_NUMBER("lots_max", ""),
	LOT_ONE_ONLY("lot_one_only", "LOTONEONLY");

	private String name;
	private String path;

	private LotDivision(String name, String path) {
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
