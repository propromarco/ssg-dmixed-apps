/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f05;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionIII;

/**
 * @author Rolf
 *
 */
public class TEDF05SectionIIIDto extends AbstractTEDSectionIII {

	private String rulesCriteria;
	private String depositeGuaranteeRequired;
	private String mainFinancingConditions;
	private String legalForm;

	/**
	 * 
	 */
	public TEDF05SectionIIIDto() {
		super();
	}

	/**
	 * @return the rulesCriteria
	 */
	@Mapping("RULESCRITERIA")
	public String getRulesCriteria() {
		return rulesCriteria;
	}

	/**
	 * @param rulesCriteria the rulesCriteria to set
	 */
	public void setRulesCriteria(String rulesCriteria) {
		this.rulesCriteria = rulesCriteria;
	}

	/**
	 * @return the depositeGuaranteeRequired
	 */
	@Mapping("DEPOSITGUARANTEEREQUIRED")
	public String getDepositeGuaranteeRequired() {
		return depositeGuaranteeRequired;
	}

	/**
	 * @param depositeGuaranteeRequired the depositeGuaranteeRequired to set
	 */
	public void setDepositeGuaranteeRequired(String depositeGuaranteeRequired) {
		this.depositeGuaranteeRequired = depositeGuaranteeRequired;
	}

	/**
	 * @return the mainFinancingConditions
	 */
	@Mapping("MAINFINANCINGCONDITION")
	public String getMainFinancingConditions() {
		return mainFinancingConditions;
	}

	/**
	 * @param mainFinancingConditions the mainFinancingConditions to set
	 */
	public void setMainFinancingConditions(String mainFinancingConditions) {
		this.mainFinancingConditions = mainFinancingConditions;
	}

	/**
	 * @return the legalForm
	 */
	@Mapping("LEGALFORM")
	public String getLegalForm() {
		return legalForm;
	}

	/**
	 * @param legalForm the legalForm to set
	 */
	public void setLegalForm(String legalForm) {
		this.legalForm = legalForm;
	}

}
