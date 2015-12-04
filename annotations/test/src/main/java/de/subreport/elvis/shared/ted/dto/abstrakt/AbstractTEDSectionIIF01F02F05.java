/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.abstrakt;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.Val;

/**
 * @author Rolf
 *
 */
public abstract class AbstractTEDSectionIIF01F02F05 extends AbstractTEDSectionII implements Section, ContainsTEDMappings {

	// II.1.5 Geschätzter Gesamtwert
	private Val valEstimatedTotal = new Val();

	/**
	 * 
	 */
	public AbstractTEDSectionIIF01F02F05() {
	}

	@Mapping("VALESTIMATEDTOTAL")
	public Val getValEstimatedTotal() {
		return valEstimatedTotal;
	}

	public void setValEstimatedTotal(Val valEstimatedTotal) {
		this.valEstimatedTotal = valEstimatedTotal;
	}

}
