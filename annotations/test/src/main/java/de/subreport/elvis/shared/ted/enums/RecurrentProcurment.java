package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum RecurrentProcurment implements HasXMLElementWithPath {
	RECURRENT_PROCURMENT("_yes", "RECURRENTPROCUREMENT"),
	NO_RECURRENT_PROCURMENT("_no", "NORECURRENTPROCUREMENT");

	private String name;
	private String path;

	private RecurrentProcurment(String name, String path) {
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
