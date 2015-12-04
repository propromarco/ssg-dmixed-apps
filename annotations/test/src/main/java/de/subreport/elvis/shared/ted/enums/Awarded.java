/**
 * 
 */
package de.subreport.elvis.shared.ted.enums;

/**
 * @author Rolf
 *
 */
public enum Awarded {
	AWARDED("_yes"),
	NOT_OPTIONS("_no");

	private String name;

	private Awarded(String name) {
		this.name = name;
	}

	public String getElementName() {
		return name;
	}

}
