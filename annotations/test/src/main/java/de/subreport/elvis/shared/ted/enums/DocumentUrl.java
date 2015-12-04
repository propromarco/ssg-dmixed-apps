package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum DocumentUrl implements HasXMLElementWithPath {
	DOCUMENT_FULL("address_obtain_docs", "DOCUMENTFULL"),
	DOCUMENT_RESTRICTED("docs_resticted", "DOCUMENTRESTRICTED");

	private String name;
	private String path;

	private DocumentUrl(String name, String path) {
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
