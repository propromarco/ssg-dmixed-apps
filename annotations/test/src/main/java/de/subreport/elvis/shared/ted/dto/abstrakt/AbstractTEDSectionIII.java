package de.subreport.elvis.shared.ted.dto.abstrakt;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;

public abstract class AbstractTEDSectionIII implements Section, ContainsTEDMappings {

	// III.1 Teilnahmebedingungen

	// III.1.1 Befähigung zur Berufsausübung einschließlich Auflagen hinsichtlich der Eintragung in einem Berufs- oder Handelsregister
	protected String infoEvaluatingRequir;

	// III.1.2 Wirtschaftliche und finanzielle Leistungsfähigkeit
	protected boolean criteriaSelectionDocs;
	protected String infoEvaluatingWethRequir;	// Wenn criteiriaSelectionDocs = false ist
	protected String minStandardRequired;		// Wenn criteiriaSelectionDocs = false ist

	// III.1.3 Technische und berufliche Leistungsfähigkeit
	protected boolean criteriaSelectionDocs2;
	protected String infoEvaluatingWethRequir2;	// Wenn criteiriaSelectionDocs2 = false ist
	protected String minStandardRequired2;		// Wenn criteiriaSelectionDocs2 = false ist

	// II.1.4 Angaben zu vorbehaltenen Aufträgen
	protected boolean restictedShelteredWorkshop;
	protected boolean restrictedShelteredProgam;

	// III.2 Bedingungen für den Auftrag

	// III.2.1 Angaben zu einem besonderen Berufsstand
	protected boolean particularProfessionReserved;
	protected String refLawRegProv;		// Wenn particularProfessionReserved = true ist

	// III.2.2 Bedingungen für die Ausführung des Auftrags
	protected String otherConditions;

	// III.2.3 Für die Ausführung des Auftrags verantwortliches Personal
	protected boolean staffResponsibleIndicate;

	/**
	 * 
	 */
	public AbstractTEDSectionIII() {
	}

	/**
	 * @return the infoEvaluatingRequir
	 */
	@Mapping("SUITABILITY")
	@TedMaxLength(4000)
	public String getInfoEvaluatingRequir() {
		return infoEvaluatingRequir;
	}

	/**
	 * @param infoEvaluatingRequir the infoEvaluatingRequir to set
	 */
	public void setInfoEvaluatingRequir(String infoEvaluatingRequir) {
		this.infoEvaluatingRequir = infoEvaluatingRequir;
	}

	/**
	 * @return the criteriaSelectionDocs
	 */
	@Mapping("ECONOMICCRITERIADOC")
	public boolean isCriteriaSelectionDocs() {
		return criteriaSelectionDocs;
	}

	/**
	 * @param criteriaSelectionDocs the criteriaSelectionDocs to set
	 */
	public void setCriteriaSelectionDocs(boolean criteriaSelectionDocs) {
		this.criteriaSelectionDocs = criteriaSelectionDocs;
	}

	/**
	 * @return the infoEvaluatingWethRequir
	 */
	@Mapping("ECONOMICFINANCIALINFO")
	@TedMaxLength(4000)
	public String getInfoEvaluatingWethRequir() {
		return infoEvaluatingWethRequir;
	}

	/**
	 * @param infoEvaluatingWethRequir the infoEvaluatingWethRequir to set
	 */
	public void setInfoEvaluatingWethRequir(String infoEvaluatingWethRequir) {
		this.infoEvaluatingWethRequir = infoEvaluatingWethRequir;
	}

	/**
	 * @return the minStandardRequired
	 */
	@Mapping("ECONOMICFINANCIALMINLEVEL")
	@TedMaxLength(4000)
	public String getMinStandardRequired() {
		return minStandardRequired;
	}

	/**
	 * @param minStandardRequired the minStandardRequired to set
	 */
	public void setMinStandardRequired(String minStandardRequired) {
		this.minStandardRequired = minStandardRequired;
	}

	/**
	 * @return the criteriaSelectionDocs2
	 */
	@Mapping("TECHNICALCRITERIADOC")
	public boolean isCriteriaSelectionDocs2() {
		return criteriaSelectionDocs2;
	}

	/**
	 * @param criteriaSelectionDocs2 the criteriaSelectionDocs2 to set
	 */
	public void setCriteriaSelectionDocs2(boolean criteriaSelectionDocs2) {
		this.criteriaSelectionDocs2 = criteriaSelectionDocs2;
	}

	/**
	 * @return the infoEvaluatingWethRequir2
	 */
	@Mapping("TECHNICALPROFESSIONALINFO")
	@TedMaxLength(4000)
	public String getInfoEvaluatingWethRequir2() {
		return infoEvaluatingWethRequir2;
	}

	/**
	 * @param infoEvaluatingWethRequir2 the infoEvaluatingWethRequir2 to set
	 */
	public void setInfoEvaluatingWethRequir2(String infoEvaluatingWethRequir2) {
		this.infoEvaluatingWethRequir2 = infoEvaluatingWethRequir2;
	}

	/**
	 * @return the minStandardRequired2
	 */
	@Mapping("TECHNICALPROFESSIONALMINLEVEL")
	@TedMaxLength(4000)
	public String getMinStandardRequired2() {
		return minStandardRequired2;
	}

	/**
	 * @param minStandardRequired2 the minStandardRequired2 to set
	 */
	public void setMinStandardRequired2(String minStandardRequired2) {
		this.minStandardRequired2 = minStandardRequired2;
	}

	/**
	 * @return the restictedShelteredWorkshop
	 */
	@Mapping("RESTRICTEDSHELTEREDWORKSHOP")
	public boolean isRestictedShelteredWorkshop() {
		return restictedShelteredWorkshop;
	}

	/**
	 * @param restictedShelteredWorkshop the restictedShelteredWorkshop to set
	 */
	public void setRestictedShelteredWorkshop(boolean restictedShelteredWorkshop) {
		this.restictedShelteredWorkshop = restictedShelteredWorkshop;
	}

	/**
	 * @return the restrictedShelteredProgam
	 */
	@Mapping("RESTRICTEDSHELTEREDPROGRAM")
	public boolean isRestrictedShelteredProgam() {
		return restrictedShelteredProgam;
	}

	/**
	 * @param restrictedShelteredProgam the restrictedShelteredProgam to set
	 */
	public void setRestrictedShelteredProgam(boolean restrictedShelteredProgam) {
		this.restrictedShelteredProgam = restrictedShelteredProgam;
	}

	/**
	 * @return the particularProfessionReserved
	 */
	@Mapping("RESERVEDORGANISATIONSSERVICEMISSION")
	public boolean isParticularProfessionReserved() {
		return particularProfessionReserved;
	}

	/**
	 * @param particularProfessionReserved the particularProfessionReserved to set
	 */
	public void setParticularProfessionReserved(boolean particularProfessionReserved) {
		this.particularProfessionReserved = particularProfessionReserved;
	}

	/**
	 * @return the refLawRegProv
	 */
	@Mapping("REFERENCETOLAW")
	@TedMaxLength(1500)
	public String getRefLawRegProv() {
		return refLawRegProv;
	}

	/**
	 * @param refLawRegProv the refLawRegProv to set
	 */
	public void setRefLawRegProv(String refLawRegProv) {
		this.refLawRegProv = refLawRegProv;
	}

	/**
	 * @return the otherConditions
	 */
	@Mapping("CRITERIASELECTION")
	@TedMaxLength(1000)
	public String getOtherConditions() {
		return otherConditions;
	}

	/**
	 * @param otherConditions the otherConditions to set
	 */
	public void setOtherConditions(String otherConditions) {
		this.otherConditions = otherConditions;
	}

	/**
	 * @return the staffResponsibleIndicate
	 */
	@Mapping("PERFORMANCESTAFFQUALIFICATION")
	public boolean isStaffResponsibleIndicate() {
		return staffResponsibleIndicate;
	}

	/**
	 * @param staffResponsibleIndicate the staffResponsibleIndicate to set
	 */
	public void setStaffResponsibleIndicate(boolean staffResponsibleIndicate) {
		this.staffResponsibleIndicate = staffResponsibleIndicate;
	}

}
