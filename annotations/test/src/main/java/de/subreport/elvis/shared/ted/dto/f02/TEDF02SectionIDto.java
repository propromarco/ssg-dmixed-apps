/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f02;

import de.marco.test.annotations.MappingMain;
import de.subreport.elvis.shared.ted.AdressesForSectionI;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionIF01F02;

/**
 * @author Rolf
 *
 */
@MappingMain("eu.europa.publications.formex.ted.schema.BodyF02")
public class TEDF02SectionIDto extends AbstractTEDSectionIF01F02 implements ContainsTEDMappings, AdressesForSectionI {

	/**
	 * 
	 */
	public TEDF02SectionIDto() {
	}

}
