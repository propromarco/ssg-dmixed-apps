/**
 * 
 */
package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElement;

/**
 * @author Rolf
 *
 */
public enum Type implements HasXMLElement {
	PRI_ONLY("TYPE_PRI_ONLY"),
	PRI_CALL_COMPETITION("TYPE_CALL_COMPETITION"),
	PRI_REDUCING_TIME_LIMITS("PRI_REDUCING_TIME_LIMITS");

	private String name;

	private Type(String name) {
		this.name = name;
	}

	@Override
	public String getElementName() {
		return name;
	}

}
