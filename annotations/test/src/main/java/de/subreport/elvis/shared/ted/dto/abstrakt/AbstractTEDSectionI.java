package de.subreport.elvis.shared.ted.dto.abstrakt;

import java.util.ArrayList;
import java.util.List;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.AddressContractingBody;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;

public abstract class AbstractTEDSectionI implements Section, ContainsTEDMappings {

	// I.1 Namen und Adressen
	private AddressContractingBody nameAddressContract = new AddressContractingBody();

	private List<AddressContractingBody> nameAddressContractAdditionals = new ArrayList<AddressContractingBody>();	// Wenn diese Liste gefÃ¼llt ist darf sie maximal 49 Elemente enthalten

	// I.2 Gemeinsame Beschaffung wird nur gefüllt wenn nameAddressContractAdditionals Elemente enthÃ¤lt
	private boolean jointProcurementInvolves;
	private String jointNationalLaw;	// Wird nur gesetzt, wenn jointProcurementInvolves = true ist
	private boolean jointProcurementCentral;

	public AbstractTEDSectionI() {
	}

	/* Fake Methods for enums */

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#getNameAddressContract()
	 */
	@Mapping("ADDRESSCONTRACTINGBODY")
	@TedRequired
	public AddressContractingBody getNameAddressContract() {
		return nameAddressContract;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#setNameAddressContract(de.subreport.elvis.shared.ted.AddressContractingBody)
	 */
	public void setNameAddressContract(AddressContractingBody nameAddressContract) {
		this.nameAddressContract = nameAddressContract;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#getNameAddressContractAdditionals()
	 */
	@Mapping("ADDRESSCONTRACTINGBODYADDITIONALS")
	public List<AddressContractingBody> getNameAddressContractAdditionals() {
		return nameAddressContractAdditionals;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#setNameAddressContractAdditionals(java.util.List)
	 */
	public void setNameAddressContractAdditionals(List<AddressContractingBody> nameAddressContractAdditionals) {
		this.nameAddressContractAdditionals = nameAddressContractAdditionals;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#isJointProcurementInvolves()
	 */
	@Mapping("JOINTPROCUREMENTINVOLVED")
	public boolean isJointProcurementInvolves() {
		return jointProcurementInvolves;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#setJointProcurementInvolves(boolean)
	 */
	public void setJointProcurementInvolves(boolean jointProcurementInvolves) {
		this.jointProcurementInvolves = jointProcurementInvolves;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#getJointNationalLaw()
	 */
	@Mapping("PROCUREMENTLAW")
	@TedMaxLength(200)
	public String getJointNationalLaw() {
		return jointNationalLaw;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#setJointNationalLaw(java.lang.String)
	 */
	public void setJointNationalLaw(String jointNationalLaw) {
		this.jointNationalLaw = jointNationalLaw;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#isJointProcurementCentral()
	 */

	@Mapping("CENTRALPURCHASING")
	public boolean isJointProcurementCentral() {
		return jointProcurementCentral;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.abstrakt.ITEDSectionI#setJointProcurementCentral(boolean)
	 */

	public void setJointProcurementCentral(boolean jointProcurementCentral) {
		this.jointProcurementCentral = jointProcurementCentral;
	}

}
