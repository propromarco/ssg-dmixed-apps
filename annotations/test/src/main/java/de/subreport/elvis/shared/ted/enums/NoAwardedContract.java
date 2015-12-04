/**
 * 
 */
package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

/**
 * @author Rolf
 *
 */
public enum NoAwardedContract implements HasXMLElementWithPath {
	PROCUREMENTUNSUCCESSFUL("PROCUREMENTUNSUCCESSFUL", "PROCUREMENTUNSUCCESSFUL"),
	PROCUREMENTDISCONTINUED("PROCUREMENTDISCONTINUED", "");

	private String name;
	private String path;

	private NoAwardedContract(String name, String path) {
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
