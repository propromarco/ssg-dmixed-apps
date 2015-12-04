/**
 * 
 */
package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

/**
 * @author Rolf
 *
 */
public enum TypeProcedureF01 implements HasXMLElementWithPath {
	PT_RESTRICTED("proctype_resticted", "PTRESTRICTED"),
	PT_COMPETITIVE_NEGOTIATION("proctype_comp_negotiation", "PTCOMPETITIVNEGOTIATION");

	private String name;
	private String path;

	private TypeProcedureF01(String name, String path) {
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
