package de.subreport.elvis.shared.ted.dto.f02;

import javax.xml.bind.annotation.XmlRootElement;

import de.marco.test.annotations.Mapping;
import de.marco.test.annotations.MappingMain;
import de.subreport.elvis.shared.ted.dto.TEDDto;

@XmlRootElement
@MappingMain("eu.europa.publications.formex.ted.schema.F022014")
public class TEDF02Dto implements TEDDto {

	private TEDF02SectionIDto sectionI = new TEDF02SectionIDto();
	private TEDF02SectionIIDto sectionII = new TEDF02SectionIIDto();
	private TEDF02SectionIIIDto sectionIII = new TEDF02SectionIIIDto();
	private TEDF02SectionIVDto sectionIV = new TEDF02SectionIVDto();
	private TEDF02SectionVIDto sectionVI = new TEDF02SectionVIDto();

	public TEDF02Dto() {
		super();
	}

	@Mapping("CONTRACTINGBODY")
	public TEDF02SectionIDto getSectionI() {
		return sectionI;
	}

	public void setSectionI(TEDF02SectionIDto sectionI) {
		this.sectionI = sectionI;
	}

	@Mapping("OBJECTCONTRACT")
	public TEDF02SectionIIDto getSectionII() {
		return sectionII;
	}

	public void setSectionII(TEDF02SectionIIDto sectionII) {
		this.sectionII = sectionII;
	}

	@Mapping("LEFTI")
	public TEDF02SectionIIIDto getSectionIII() {
		return sectionIII;
	}

	public void setSectionIII(TEDF02SectionIIIDto sectionIII) {
		this.sectionIII = sectionIII;
	}

	@Mapping("PROCEDURE")
	public TEDF02SectionIVDto getSectionIV() {
		return sectionIV;
	}

	public void setSectionIV(TEDF02SectionIVDto sectionIV) {
		this.sectionIV = sectionIV;
	}

	@Mapping("COMPLEMENTARYINFO")
	public TEDF02SectionVIDto getSectionVI() {
		return sectionVI;
	}

	public void setSectionVI(TEDF02SectionVIDto sectionVI) {
		this.sectionVI = sectionVI;
	}

}
