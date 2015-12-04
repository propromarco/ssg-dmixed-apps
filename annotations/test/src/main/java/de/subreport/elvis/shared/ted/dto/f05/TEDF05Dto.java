/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f05;

import javax.xml.bind.annotation.XmlRootElement;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.dto.TEDDto;

/**
 * @author Rolf
 *
 */
@XmlRootElement
public class TEDF05Dto implements TEDDto {

	private TEDF05SectionIDto sectionI = new TEDF05SectionIDto();
	private TEDF05SectionIIDto sectionII = new TEDF05SectionIIDto();
	private TEDF05SectionIIIDto sectionIII = new TEDF05SectionIIIDto();
	private TEDF05SectionIVDto sectionIV = new TEDF05SectionIVDto();
	private TEDF05SectionVIDto sectionVI = new TEDF05SectionVIDto();

	/**
	 * 
	 */
	public TEDF05Dto() {
		super();
	}

	@Mapping("CONTRACTINGBODY")
	public TEDF05SectionIDto getSectionI() {
		return sectionI;
	}

	public void setSectionI(TEDF05SectionIDto sectionI) {
		this.sectionI = sectionI;
	}

	@Mapping("OBJECTCONTRACT")
	public TEDF05SectionIIDto getSectionII() {
		return sectionII;
	}

	public void setSectionII(TEDF05SectionIIDto sectionII) {
		this.sectionII = sectionII;
	}

	@Mapping("LEFTI")
	public TEDF05SectionIIIDto getSectionIII() {
		return sectionIII;
	}

	public void setSectionIII(TEDF05SectionIIIDto sectionIII) {
		this.sectionIII = sectionIII;
	}

	@Mapping("PROCEDURE")
	public TEDF05SectionIVDto getSectionIV() {
		return sectionIV;
	}

	public void setSectionIV(TEDF05SectionIVDto sectionIV) {
		this.sectionIV = sectionIV;
	}

	@Mapping("COMPLEMENTARYINFO")
	public TEDF05SectionVIDto getSectionVI() {
		return sectionVI;
	}

	public void setSectionVI(TEDF05SectionVIDto sectionVI) {
		this.sectionVI = sectionVI;
	}
}
