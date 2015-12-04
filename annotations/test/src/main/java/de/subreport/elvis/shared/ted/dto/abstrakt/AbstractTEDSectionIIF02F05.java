/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.abstrakt;

import java.util.ArrayList;
import java.util.List;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.ObjectDescriptionF02F05;
import de.subreport.elvis.shared.ted.Section;

/**
 * @author Rolf
 *
 */
public abstract class AbstractTEDSectionIIF02F05 extends AbstractTEDSectionIIF01F02F05 implements Section, ContainsTEDMappings {

	// II 2. Beschreibung
	private List<ObjectDescriptionF02F05> description = new ArrayList<ObjectDescriptionF02F05>();	// Wenn divisionLots = NO hat die Liste nur ein Element bei dem lotNumber nicht gesetzt ist

	// Wenn devisionLots = YES hat die Liste soviele Elemente wie es Lose gibt, max 1000

	/**
	 * 
	 */
	public AbstractTEDSectionIIF02F05() {
		super();
		if (description.isEmpty()) {
			description.add(new ObjectDescriptionF02F05());
		}
	}

	/**
	 * @return the description
	 */
	@Mapping("OBJECTDESCRS")
	public List<ObjectDescriptionF02F05> getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(List<ObjectDescriptionF02F05> description) {
		this.description = description;
	}

}
