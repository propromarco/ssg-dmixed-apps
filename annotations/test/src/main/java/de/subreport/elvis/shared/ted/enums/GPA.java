package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum GPA implements HasXMLElementWithPath {
	CONTRACT_COVERED_GPA("_yes", "CONTRACTCOVEREDGPA"),
	NO_CONTRACT_COVERED_GPA("_no", "NOCONTRACTCOVEREDGPA");

	private String name;
	private String path;

	private GPA(String name, String path) {
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
