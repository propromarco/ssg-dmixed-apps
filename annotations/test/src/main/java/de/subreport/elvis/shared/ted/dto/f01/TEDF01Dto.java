/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f01;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.dto.TEDDto;

/**
 * @author Rolf
 *
 */
@XmlRootElement
public class TEDF01Dto implements TEDDto {

	private TEDF01Section0Dto section0 = new TEDF01Section0Dto();
	private TEDF01SectionIDto sectionI = new TEDF01SectionIDto();
	private List<TEDF01SectionIIDto> sectionII = new ArrayList<TEDF01SectionIIDto>();	// Mindestens 1, maximal 100 Einträge
	private TEDF01SectionIIIDto sectionIII = new TEDF01SectionIIIDto();
	private TEDF01SectionIVDto sectionIV = new TEDF01SectionIVDto();
	private TEDF01SectionVIDto sectionVI = new TEDF01SectionVIDto();

	/**
	 * 
	 */
	public TEDF01Dto() {
		super();
	}

	/**
	 * @return the section0
	 */
	@Mapping("NOTICE")
	public TEDF01Section0Dto getSection0() {
		return section0;
	}

	/**
	 * @param section0 the section0 to set
	 */
	public void setSection0(TEDF01Section0Dto section0) {
		this.section0 = section0;
	}

	@Mapping("CONTRACTINGBODY")
	public TEDF01SectionIDto getSectionI() {
		return sectionI;
	}

	public void setSectionI(TEDF01SectionIDto sectionI) {
		this.sectionI = sectionI;
	}

	@Mapping("OBJECTCONTRACTS")
	public List<TEDF01SectionIIDto> getSectionII() {
		return sectionII;
	}

	public void setSectionII(List<TEDF01SectionIIDto> sectionII) {
		this.sectionII = sectionII;
	}

	@Mapping("LEFTI")
	public TEDF01SectionIIIDto getSectionIII() {
		return sectionIII;
	}

	public void setSectionIII(TEDF01SectionIIIDto sectionIII) {
		this.sectionIII = sectionIII;
	}

	@Mapping("PROCEDURE")
	public TEDF01SectionIVDto getSectionIV() {
		return sectionIV;
	}

	public void setSectionIV(TEDF01SectionIVDto sectionIV) {
		this.sectionIV = sectionIV;
	}

	@Mapping("COMPLEMENTARYINFO")
	public TEDF01SectionVIDto getSectionVI() {
		return sectionVI;
	}

	public void setSectionVI(TEDF01SectionVIDto sectionVI) {
		this.sectionVI = sectionVI;
	}

}
