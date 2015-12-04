package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum AwardCriteriaDoc implements HasXMLElementWithPath {
	AWARD_CRITERIA("award_criteria_below", ""),	// Wenn AWARD_CRITERIA gesetzt ist ist zwingend auch die Enum AwardCriteria gesetzt
	AC_PROCUMENT_DOC("award_criteria_descriptive", "ACPROCUREMENTDOC");

	private String name;
	private String path;

	private AwardCriteriaDoc(String name, String path) {
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
