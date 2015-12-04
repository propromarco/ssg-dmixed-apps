/**
 * 
 */
package de.subreport.elvis.shared.ted;

import java.math.BigInteger;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.enums.Envisaged;

/**
 * @author Rolf
 *
 */
public class ObjectDescriptionF02F05 extends ObjectDescriptionF01F02F05 {

	// Nr. 9. Angabe zur Beschränkung der Zahl der Bewerber, die zur Angebotsabgabe bzw. Teilnahme aufgefordert werden
	private BigInteger envisagedNumber;
	private BigInteger envisagedMin;
	private BigInteger maxNumber;
	private String criteriaChoosingLimited;
	private Envisaged envisaged = Envisaged.ENVISAGEDNUMBER;

	// Nr. 12. Angaben zu elektronischen Katalogen
	private boolean electronicCatalogueRequired;
	private boolean closable;

	/**
	 * 
	 */
	public ObjectDescriptionF02F05() {
		super();
	}

	/**
	 * @return the envisagedNumber
	 */
	@Mapping("NBENVISAGEDCANDIDATE")
	public BigInteger getEnvisagedNumber() {
		return envisagedNumber;
	}

	/**
	 * @param envisagedNumber the envisagedNumber to set
	 */
	public void setEnvisagedNumber(BigInteger envisagedNumber) {
		this.envisagedNumber = envisagedNumber;
	}

	/**
	 * @return the envisagedMin
	 */
	@Mapping("NBMINLIMITCANDIDATE")
	public BigInteger getEnvisagedMin() {
		return envisagedMin;
	}

	/**
	 * @param envisagedMin the envisagedMin to set
	 */
	public void setEnvisagedMin(BigInteger envisagedMin) {
		this.envisagedMin = envisagedMin;
	}

	/**
	 * @return the maxNumber
	 */
	@Mapping("NBMAXLIMITCANDIDATE")
	public BigInteger getMaxNumber() {
		return maxNumber;
	}

	/**
	 * @param maxNumber the maxNumber to set
	 */
	public void setMaxNumber(BigInteger maxNumber) {
		this.maxNumber = maxNumber;
	}

	/**
	 * @return the criteriaChoosingLimited
	 */
	@Mapping("CRITERIACANDIDATE")
	@TedMaxLength(4000)
	public String getCriteriaChoosingLimited() {
		return criteriaChoosingLimited;
	}

	/**
	 * @param criteriaChoosingLimited the criteriaChoosingLimited to set
	 */
	public void setCriteriaChoosingLimited(String criteriaChoosingLimited) {
		this.criteriaChoosingLimited = criteriaChoosingLimited;
	}

	/**
	 * @return the electronicCatalogueRequired
	 */
	@Mapping("ECATALOGUEREQUIRED")
	public boolean isElectronicCatalogueRequired() {
		return electronicCatalogueRequired;
	}

	/**
	 * @param electronicCatalogueRequired the electronicCatalogueRequired to set
	 */
	public void setElectronicCatalogueRequired(boolean electronicCatalogueRequired) {
		this.electronicCatalogueRequired = electronicCatalogueRequired;
	}

	public Envisaged getEnvisaged() {
		return envisaged;
	}

	public void setEnvisaged(Envisaged envisaged) {
		this.envisaged = envisaged;
	}

	// For Action

	public void setClosable(boolean closable) {
		this.closable = closable;
	}

	public boolean isClosable() {
		return closable;
	}

}
