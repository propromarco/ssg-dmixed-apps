/**
 * 
 */
package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

/**
 * @author Rolf
 *
 */
public enum TypeProcedureF03 implements HasXMLElementWithPath {

	PT_OPEN("proctype_open", "PTOPEN"),
	PT_RESTRICTED("proctype_resticted", "PTRESTICTED"),
	PT_COMPETITIVE_NEGOTIATION("proctype_comp_negotiation", "PTCOMPETITIVNEGOTIATION"),
	PT_COMPETITIVE_DIALOGUE("proctype_comp_dialogue", "PTCOMPETETIVEDIALOGUE"),
	PT_INNOVATION_PARTNERSHIP("proctype_innovation", "PTINNOVATIONPARTNERSHIP"),
	PT_AWARD_CONTRACT_WITHOUT_CALL("proctype_award_without_call", "");

	private String name;
	private String path;

	private TypeProcedureF03(String name, String path) {
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
