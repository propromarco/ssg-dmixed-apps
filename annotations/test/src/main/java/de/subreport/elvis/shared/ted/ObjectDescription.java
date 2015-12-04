package de.subreport.elvis.shared.ted;

import java.util.ArrayList;
import java.util.List;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;
import de.subreport.elvis.shared.ted.dto.NutsCodeDto;
import de.subreport.elvis.shared.ted.enums.AwardCriteria;
import de.subreport.elvis.shared.ted.enums.AwardCriteriaDoc;
import de.subreport.elvis.shared.ted.enums.EuUnionFunds;
import de.subreport.elvis.shared.ted.enums.Options;

public class ObjectDescription implements Section, ContainsTEDMappings {

	// Nr. 1. Bezeichnung des Auftrags
	private String titleContract;
	private String lotNumber;	// max 100 Zeichen

	// Nr. 2. weitere CPV-Codes
	private List<CPVAdditional> cpvAdditional = new ArrayList<>();			// Maximal 100 Codes in der Liste

	// Nr. 3. Erfüllungsort
	private List<NutsCodeDto> nutsCode = new ArrayList<>();	// Maximal 20 Einträge, max 5 Zeichen
	private String mainsiteplaceWorkDelivery;

	// Nr. 4. Beschreibung der Beschaffung
	private String descProcurement;

	// Nr. 5. Zuschlagskriterien
	private AwardCriteriaDoc awardCriteriaDoc = AwardCriteriaDoc.AWARD_CRITERIA;
	private boolean awardCriterionCheckBox;
	private List<AwardCriterion> awardCriterionQuality = new ArrayList<AwardCriterion>();	// mindestens ein Element, wenn awardCriterionCheckBox = true
	private AwardCriteria awardCriteria = AwardCriteria.AC_PRICE;
	private List<AwardCriterion> awardCriterionCost = new ArrayList<AwardCriterion>();	// mindestens ein Element, wenn PriceCriterion = AWARD_LOWEST_COST ist
	private String priceWeighting;	// Wenn PriceCriterion = PRICE, max 20 Zeichen

	// Nr. 11. Angaben zu Optionen
	private Options options = Options.NO_OPTIONS;
	private String optionsDescription;

	// Nr. 13. Angaben zu Mitteln der Europäischen Union
	private EuUnionFunds euUnionFunds = EuUnionFunds.NO_EU_PROGRAM_RELATED;
	private String euProgRef;	// Wird gesetzt, wenn euProgramRelated = true ist

	// Nr. 14. Zusätzliche Angaben:
	private String infoAdditional;

	/**
	 * 
	 */
	public ObjectDescription() {
	}

	/**
	 * @return the titleContract
	 */
	@Mapping("TITLE.P")
	@TedMaxLength(200)
	public String getTitleContract() {
		return titleContract;
	}

	/**
	 * @param titleContract the titleContract to set
	 */
	public void setTitleContract(String titleContract) {
		this.titleContract = titleContract;
	}

	/**
	 * @return the lotNumber
	 */
	@Mapping("LOTNO")
	@TedMaxLength(100)
	public String getLotNumber() {
		return lotNumber;
	}

	/**
	 * @param lotNumber the lotNumber to set
	 */
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	/**
	 * @return the cpvAdditional
	 */
	@Mapping("CPVADDITIONALS")
	public List<CPVAdditional> getCpvAdditional() {
		return cpvAdditional;
	}

	/**
	 * @param cpvAdditional the cpvAdditional to set
	 */
	public void setCpvAdditional(List<CPVAdditional> cpvAdditional) {
		this.cpvAdditional = cpvAdditional;
	}

	/**
	 * @return the nutsCode
	 */
	@Mapping("NUTS")
	@TedMaxLength(5)
	@TedRequired
	public List<NutsCodeDto> getNutsCode() {
		return nutsCode;
	}

	/**
	 * @param nutsCode the nutsCode to set
	 */
	public void setNutsCode(List<NutsCodeDto> nutsCode) {
		this.nutsCode = nutsCode;
	}

	/**
	 * @return the mainsiteplaceWorkDelivery
	 */
	@Mapping("MAINSITE")
	@TedMaxLength(200)
	public String getMainsiteplaceWorkDelivery() {
		return mainsiteplaceWorkDelivery;
	}

	/**
	 * @param mainsiteplaceWorkDelivery the mainsiteplaceWorkDelivery to set
	 */
	public void setMainsiteplaceWorkDelivery(String mainsiteplaceWorkDelivery) {
		this.mainsiteplaceWorkDelivery = mainsiteplaceWorkDelivery;
	}

	/**
	 * @return the descProcurement
	 */
	@Mapping("SHORTDESCR")
	@TedMaxLength(4000)
	@TedRequired
	public String getDescProcurement() {
		return descProcurement;
	}

	/**
	 * @param descProcurement the descProcurement to set
	 */
	public void setDescProcurement(String descProcurement) {
		this.descProcurement = descProcurement;
	}

	/**
	 * @return the awardCriteria
	 */
	@Mapping("")
	public AwardCriteriaDoc getAwardCriteriaDoc() {
		return awardCriteriaDoc;
	}

	/**
	 * @param awardCriteria the awardCriteria to set
	 */
	public void setAwardCriteriaDoc(AwardCriteriaDoc awardCriteria) {
		this.awardCriteriaDoc = awardCriteria;
	}

	/**
	 * @return the awardCriterionCheckBox
	 */
	public boolean isAwardCriterionCheckBox() {
		return awardCriterionCheckBox;
	}

	/**
	 * @param awardCriterionCheckBox the awardCriterionCheckBox to set
	 */
	public void setAwardCriterionCheckBox(boolean awardCriterionCheckBox) {
		this.awardCriterionCheckBox = awardCriterionCheckBox;
	}

	/**
	 * @return the awardCriterionQuality
	 */
	@Mapping("ACQUALITIES")
	public List<AwardCriterion> getAwardCriterionQuality() {
		return awardCriterionQuality;
	}

	/**
	 * @param awardCriterionQuality the awardCriterionQuality to set
	 */
	public void setAwardCriterionQuality(List<AwardCriterion> awardCriterionQuality) {
		this.awardCriterionQuality = awardCriterionQuality;
	}

	/**
	 * @return the priceCriterion
	 */
	public AwardCriteria getAwardCriteria() {
		return awardCriteria;
	}

	/**
	 * @param priceCriterion the priceCriterion to set
	 */
	public void setAwardCriteria(AwardCriteria awardCriteria) {
		this.awardCriteria = awardCriteria;
	}

	/**
	 * @return the awardCriterionCost
	 */
	@Mapping("ACCOSTS")
	public List<AwardCriterion> getAwardCriterionCost() {
		return awardCriterionCost;
	}

	/**
	 * @param awardCriterionCost the awardCriterionCost to set
	 */
	public void setAwardCriterionCost(List<AwardCriterion> awardCriterionCost) {
		this.awardCriterionCost = awardCriterionCost;
	}

	/**
	 * @return the priceWeighting
	 */
	@Mapping("ACPRICE.ACWEIGHTING")
	@TedMaxLength(20)
	public String getPriceWeighting() {
		return priceWeighting;
	}

	/**
	 * @param priceWeighting the priceWeighting to set
	 */
	public void setPriceWeighting(String priceWeighting) {
		this.priceWeighting = priceWeighting;
	}

	/**
	 * @return the options
	 */
	@Mapping("")
	public Options getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(Options options) {
		this.options = options;
	}

	/**
	 * @return the optionsDescription
	 */
	@Mapping("OPTIONSDESCR")
	public String getOptionsDescription() {
		return optionsDescription;
	}

	/**
	 * @param optionsDescription the optionsDescription to set
	 */
	public void setOptionsDescription(String optionsDescription) {
		this.optionsDescription = optionsDescription;
	}

	/**
	 * @return the euProgramRelated
	 */
	@Mapping("")
	public EuUnionFunds getEuUnionFunds() {
		return euUnionFunds;
	}

	/**
	 * @param euUnionFunds the euProgramRelated to set
	 */
	public void setEuUnionFunds(EuUnionFunds euUnionFunds) {
		this.euUnionFunds = euUnionFunds;
	}

	/**
	 * @return the euProgRef
	 */
	@Mapping("EUPROGRRELATED")
	@TedMaxLength(200)
	public String getEuProgRef() {
		return euProgRef;
	}

	/**
	 * @param euProgRef the euProgRef to set
	 */
	public void setEuProgRef(String euProgRef) {
		this.euProgRef = euProgRef;
	}

	/**
	 * @return the infoAdditional
	 */
	@Mapping("INFOADD")
	@TedMaxLength(400)
	public String getInfoAdditional() {
		return infoAdditional;
	}

	/**
	 * @param infoAdditional the infoAdditional to set
	 */
	public void setInfoAdditional(String infoAdditional) {
		this.infoAdditional = infoAdditional;
	}

}
