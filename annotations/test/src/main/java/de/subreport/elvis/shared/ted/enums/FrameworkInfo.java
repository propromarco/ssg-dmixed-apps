package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum FrameworkInfo implements HasXMLElementWithPath {
	SINGLE_OPERATOR("framework_single", "SINGLEOPERATOR"),
	SEVERAL_OPERATORS("framework_several", "SEVERALOPERATORS");

	private String name;
	private String path;

	private FrameworkInfo(String name, String path) {
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
