package de.subreport.elvis.shared.ted.dto.abstrakt;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;

public class AbstractTEDSectionVIF01F02F05 extends AbstractTEDSectionVI implements Section, ContainsTEDMappings {

	// VI.2 Angaben zu elektronischen Arbeitsabläufen
	private boolean eorderingUsed;
	private boolean einvoiceUsed;
	private boolean epaymentUsed;

	/**
	 * 
	 */
	public AbstractTEDSectionVIF01F02F05() {

	}

	/**
	 * @return the eorderingUsed
	 */
	@Mapping("EORDERING")
	public boolean isEorderingUsed() {
		return eorderingUsed;
	}

	/**
	 * @param eorderingUsed the eorderingUsed to set
	 */
	public void setEorderingUsed(boolean eorderingUsed) {
		this.eorderingUsed = eorderingUsed;
	}

	/**
	 * @return the einvoiceUsed
	 */
	@Mapping("EINVOICING")
	public boolean isEinvoiceUsed() {
		return einvoiceUsed;
	}

	/**
	 * @param einvoiceUsed the einvoiceUsed to set
	 */
	public void setEinvoiceUsed(boolean einvoiceUsed) {
		this.einvoiceUsed = einvoiceUsed;
	}

	/**
	 * @return the epaymentUsed
	 */
	@Mapping("EPAYMENT")
	public boolean isEpaymentUsed() {
		return epaymentUsed;
	}

	/**
	 * @param epaymentUsed the epaymentUsed to set
	 */
	public void setEpaymentUsed(boolean epaymentUsed) {
		this.epaymentUsed = epaymentUsed;
	}

}
