package de.subreport.elvis.shared.ted.dto.abstrakt;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.CPVAdditional;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;
import de.subreport.elvis.shared.ted.enums.DivisionLots;
import de.subreport.elvis.shared.ted.enums.LotDivision;
import de.subreport.elvis.shared.ted.enums.TypeContract;

public abstract class AbstractTEDSectionII implements Section, ContainsTEDMappings {

	// II.1 Gegenstand der Beschaffung
	// II.1.1 Bezeichnung des Auftrags
	private String titleContract;
	private String fileref; // Maximal 100 Zeichen

	// II.1.2 CPV-Code
	private CPVAdditional cpvAdditionals = new CPVAdditional();

	// II.1.3 Art des Auftrags
	private TypeContract typeContract = TypeContract.WORKS;

	// II.1.4 Kurze Beschreibung
	private String descShort;

	// II.1.6 Angaben zu den Losen
	private DivisionLots divisionLots = DivisionLots.NO;
	private LotDivision lotDivision;	// Wenn divisionLots = YES ist
	private Integer lotsMax;	// Wenn lotDivision = LOT_MAX_NUMBER ist
	private boolean lotsMaxAwardedCheckbox;
	private Integer lotsMaxAwarded;	// Wenn lotsMaxAwardedCheckbox = true ist
	private boolean lotsCombitnationPossibleCheckbox;
	private String lotsCombinationPossible;

	public AbstractTEDSectionII() {
	}

	@Mapping("TITLE.P")
	@TedMaxLength(200)
	public String getTitleContract() {
		return titleContract;
	}

	public void setTitleContract(String titleContract) {
		this.titleContract = titleContract;
	}

	@Mapping("REFERENCENUMBER")
	@TedMaxLength(100)
	public String getFileref() {
		return fileref;
	}

	public void setFileref(String fileref) {
		this.fileref = fileref;
	}

	@Mapping("TYPECONTRACT")
	@TedRequired
	public TypeContract getTypeContract() {
		return typeContract;
	}

	public void setTypeContract(TypeContract typeContract) {
		this.typeContract = typeContract;
	}

	@Mapping("SHORTDESCR")
	@TedMaxLength(1000)
	@TedRequired
	public String getDescShort() {
		return descShort;
	}

	public void setDescShort(String descShort) {
		this.descShort = descShort;
	}

	@Mapping("")
	// Achtung!! negative Logik
	public DivisionLots getDivisionLots() {
		return divisionLots;
	}

	public void setDivisionLots(DivisionLots divisionLots) {
		this.divisionLots = divisionLots;
	}

	/**
	 * @return the cpvAdditionals
	 */
	@Mapping("CPVMAIN")
	@TedRequired
	public CPVAdditional getCpvAdditionals() {
		return cpvAdditionals;
	}

	/**
	 * @param cpvAdditionals the cpvAdditionals to set
	 */
	public void setCpvAdditionals(CPVAdditional cpvAdditionals) {
		this.cpvAdditionals = cpvAdditionals;
	}

	/**
	 * @return the lotDivision
	 */
	@Mapping("LOTDIVISION")
	public LotDivision getLotDivision() {
		return lotDivision;
	}

	/**
	 * @param lotDivision the lotDivision to set
	 */
	public void setLotDivision(LotDivision lotDivision) {
		this.lotDivision = lotDivision;
	}

	/**
	 * @return the lotsMax
	 */
	@Mapping("LOTDIVISION.LOTMAXNUMBER")
	public Integer getLotsMax() {
		return lotsMax;
	}

	/**
	 * @param lotsMax the lotsMax to set
	 */
	public void setLotsMax(Integer lotsMax) {
		this.lotsMax = lotsMax;
	}

	/**
	 * @return the lotsMaxAwardedCheckbox
	 */
	public boolean isLotsMaxAwardedCheckbox() {
		return lotsMaxAwardedCheckbox;
	}

	/**
	 * @param lotsMaxAwardedCheckbox the lotsMaxAwardedCheckbox to set
	 */
	public void setLotsMaxAwardedCheckbox(boolean lotsMaxAwardedCheckbox) {
		this.lotsMaxAwardedCheckbox = lotsMaxAwardedCheckbox;
	}

	/**
	 * @return the lotsMaxAwarded
	 */
	@Mapping("LOTDIVISION.LOTMAXONETENDERER")
	public Integer getLotsMaxAwarded() {
		return lotsMaxAwarded;
	}

	/**
	 * @param lotsMaxAwarded the lotsMaxAwarded to set
	 */
	public void setLotsMaxAwarded(Integer lotsMaxAwarded) {
		this.lotsMaxAwarded = lotsMaxAwarded;
	}

	/**
	 * @return the lotsCombitnationPossibleCheckbox
	 */
	public boolean isLotsCombitnationPossibleCheckbox() {
		return lotsCombitnationPossibleCheckbox;
	}

	/**
	 * @param lotsCombitnationPossibleCheckbox the lotsCombitnationPossibleCheckbox to set
	 */
	public void setLotsCombitnationPossibleCheckbox(boolean lotsCombitnationPossibleCheckbox) {
		this.lotsCombitnationPossibleCheckbox = lotsCombitnationPossibleCheckbox;
	}

	/**
	 * @return the lotsCombitnationPossible
	 */
	@Mapping("LOTDIVISION.LOTCOMBININGCONTRACTRIGHT")
	@TedMaxLength(400)
	public String getLotsCombinationPossible() {
		return lotsCombinationPossible;
	}

	/**
	 * @param lotsCombitnationPossible the lotsCombitnationPossible to set
	 */
	public void setLotsCombinationPossible(String lotsCombinationPossible) {
		this.lotsCombinationPossible = lotsCombinationPossible;
	}

}
