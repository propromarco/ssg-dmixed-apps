package de.subreport.elvis.shared.ted.enums;

import de.subreport.elvis.shared.ted.HasXMLElementWithPath;

public enum TypeProcedureF02F05 implements HasXMLElementWithPath {

	PT_OPEN("proctype_open", "PTOPEN"),
	PT_RESTRICTED("proctype_resticted", "PTRESTRICTED"),
	PT_COMPETITIVE_NEGOTIATION("proctype_comp_negotiation", "PTCOMPETITIVENEGOTIATION"),
	PT_COMPETITIVE_DIALOGUE("proctype_comp_dialogue", "PTCOMPETITIVEDIALOGUE"),
	PT_INNOVATION_PARTNERSHIP("proctype_innovation", "PTINNOVATIONPARTNERSHIP");

	private String name;
	private String path;

	private TypeProcedureF02F05(String name, String path) {
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
