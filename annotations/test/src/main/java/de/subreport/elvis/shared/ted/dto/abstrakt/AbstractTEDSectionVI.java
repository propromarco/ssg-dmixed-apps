package de.subreport.elvis.shared.ted.dto.abstrakt;

import java.util.Date;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContactReview;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;

public abstract class AbstractTEDSectionVI implements Section, ContainsTEDMappings {

	// VI.3 Zusätzliche Angaben
	private String infoAdditional;

	// VI.4 Rechtsbehelfsverfahren/Nachprüfungsverfahren
	private ContactReview addressReview = new ContactReview();
	private ContactReview addressMediation = new ContactReview();
	private String appealsDeadline;
	private ContactReview addressReviewInfo = new ContactReview();

	// VI.5 Tag der Absendung dieser Bekanntmachung
	private Date dateDispatch;

	/**
	 * 
	 */
	public AbstractTEDSectionVI() {
	}

	/**
	 * @return the infoAdditional
	 */
	@Mapping("INFOADD")
	@TedMaxLength(4000)
	public String getInfoAdditional() {
		return infoAdditional;
	}

	/**
	 * @param infoAdditional the infoAdditional to set
	 */
	public void setInfoAdditional(String infoAdditional) {
		this.infoAdditional = infoAdditional;
	}

	/**
	 * @param addressMediation the addressReview to set
	 */
	public void setAddressReview(ContactReview addressReview) {
		this.addressReview = addressReview;
	}

	/**
	 * @return the addressReview
	 */
	@Mapping("ADDRESSREVIEWBODY")
	@TedRequired
	public ContactReview getAddressReview() {
		return addressReview;
	}

	/**
	 * @param addressMediation the addressMediation to set
	 */
	public void setAddressMediation(ContactReview addressMediation) {
		this.addressMediation = addressMediation;
	}

	/**
	 * @return the addressMediation
	 */
	@Mapping("ADDRESSMEDIATIONBODY")
	public ContactReview getAddressMediation() {
		return addressMediation;
	}

	/**
	 * @param addressReviewInfo the addressReviewInfo to set
	 */
	public void setAddressReviewInfo(ContactReview addressReviewInfo) {
		this.addressReviewInfo = addressReviewInfo;
	}

	/**
	 * @return the addressReviewInfo
	 */
	@Mapping("ADDRESSREVIEWINFO")
	public ContactReview getAddressReviewInfo() {
		return addressReviewInfo;
	}

	/**
	 * @return the appealsDeadline
	 */
	@Mapping("REVIEWPROCEDURE")
	@TedMaxLength(4000)
	public String getAppealsDeadline() {
		return appealsDeadline;
	}

	/**
	 * @param appealsDeadline the appealsDeadline to set
	 */
	public void setAppealsDeadline(String appealsDeadline) {
		this.appealsDeadline = appealsDeadline;
	}

	/**
	 * @return the dateDispatch
	 */
	@Mapping("DATEDISPATCHNOTICE")
	@TedRequired
	public Date getDateDispatch() {
		return dateDispatch;
	}

	/**
	 * @param dateDispatch the dateDispatch to set
	 */
	public void setDateDispatch(Date dateDispatch) {
		this.dateDispatch = dateDispatch;
	}
}
