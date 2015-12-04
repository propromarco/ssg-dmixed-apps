/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f02;

import de.marco.test.annotations.MappingMain;
import de.subreport.elvis.shared.ted.AdressesForSectionVI;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionVIF02F05;

/**
 * @author Rolf
 *
 */
@MappingMain("eu.europa.publications.formex.ted.schema.CiF02")
public class TEDF02SectionVIDto extends AbstractTEDSectionVIF02F05 implements AdressesForSectionVI {

	/**
	 * 
	 */
	public TEDF02SectionVIDto() {
		super();
	}

}
