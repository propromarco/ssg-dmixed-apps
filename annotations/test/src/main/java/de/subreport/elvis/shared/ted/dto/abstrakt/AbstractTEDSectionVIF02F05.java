/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.abstrakt;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.enums.RecurrentProcurment;

/**
 * @author Rolf
 *
 */
public abstract class AbstractTEDSectionVIF02F05 extends AbstractTEDSectionVIF01F02F05 {

	// VI.1 Angaben zur Wiederkehr des Auftrags
	private RecurrentProcurment recurrentProcurment = RecurrentProcurment.NO_RECURRENT_PROCURMENT;
	private String furtherNoticeTiming;			// Wenn recurrentProcurment = YES ist

	/**
	 * 
	 */
	public AbstractTEDSectionVIF02F05() {
	}

	/**
	 * @return the complementInfo
	 */
	@Mapping("")
	public RecurrentProcurment getRecurrentProcurment() {
		return recurrentProcurment;
	}

	/**
	 * @param complementInfo the complementInfo to set
	 */
	public void setRecurrentProcurment(RecurrentProcurment recurrentProcurment) {
		this.recurrentProcurment = recurrentProcurment;
	}

	/**
	 * @return the furtherNoticeTiming
	 */
	@Mapping("ESTIMATEDTIMING")
	@TedMaxLength(400)
	public String getFurtherNoticeTiming() {
		return furtherNoticeTiming;
	}

	/**
	 * @param furtherNoticeTiming the furtherNoticeTiming to set
	 */
	public void setFurtherNoticeTiming(String furtherNoticeTiming) {
		this.furtherNoticeTiming = furtherNoticeTiming;
	}

}
