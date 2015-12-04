/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.abstrakt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;
import de.subreport.elvis.shared.ted.enums.FrameworkInfo;
import de.subreport.elvis.shared.ted.enums.Language;

/**
 * @author Rolf
 *
 */
public abstract class AbstractTEDSectionIVF01F02F05 extends AbstractTEDSectionIV {

	// IV.1 Beschreibung

	// IV.1.3 Angaben zur Rahmenvereinbarung oder zum dynamischen Beschaffungssystem
	private boolean noticeInvolvesFramework;
	private FrameworkInfo frameworkInfo;
	private Integer frameworkParticipEnvis;			// Wenn Framework = FRAMEWORK_SEVERAL ist

	private boolean noticeInvolevesDPS;
	private boolean dpsPurchasers;					// Wenn noticeInvolvesFramework = true ist
	private String frameworkJustFour;				// Wenn noticeInvolvesFramework = true ist

	// IV 1.6 Angaben zur elektronischen Auktion
	private boolean eauctionWillUsed;
	private String eauctionInfoAddit;				// Wenn eauctionWillUsed = true ist

	// IV.2 Verwaltungsangaben

	// IV.2.2 Schlusstermin für den Eingang der Angebote oder Teilnahmeanträge
	private Date limitReceiptTendersReqPartDate;
	// private String limitReceiptTendersReqPartTime;

	// IV.2.4 Sprache(n), in der (denen) Angebote oder Teilnahmeanträge eingereicht werden können
	private List<Language> languagesAllowed = new ArrayList<Language>();	// Maximal 50 Sprachen

	/**
	 * 
	 */
	public AbstractTEDSectionIVF01F02F05() {
		languagesAllowed.add(Language.DE);
	}

	/**
	 * @return the noticeInvolvesFramework
	 */
	public boolean isNoticeInvolvesFramework() {
		return noticeInvolvesFramework;
	}

	/**
	 * @param noticeInvolvesFramework the noticeInvolvesFramework to set
	 */
	public void setNoticeInvolvesFramework(boolean noticeInvolvesFramework) {
		this.noticeInvolvesFramework = noticeInvolvesFramework;
	}

	/**
	 * @return the frameworkInfo
	 */
	@Mapping("FRAMEWORK")
	public FrameworkInfo getFrameworkInfo() {
		return frameworkInfo;
	}

	/**
	 * @param frameworkInfo the frameworkInfo to set
	 */
	public void setFrameworkInfo(FrameworkInfo frameworkInfo) {
		this.frameworkInfo = frameworkInfo;
	}

	/**
	 * @return the frameworkParticipEnvis
	 */
	@Mapping("FRAMEWORK.NBPARTICIPANTS")
	public Integer getFrameworkParticipEnvis() {
		return frameworkParticipEnvis;
	}

	/**
	 * @param frameworkParticipEnvis the frameworkParticipEnvis to set
	 */
	public void setFrameworkParticipEnvis(Integer frameworkParticipEnvis) {
		this.frameworkParticipEnvis = frameworkParticipEnvis;
	}

	/**
	 * @return the noticeInvolevesDPS
	 */
	@Mapping("DPS")
	public boolean isNoticeInvolevesDPS() {
		return noticeInvolevesDPS;
	}

	/**
	 * @param noticeInvolevesDPS the noticeInvolevesDPS to set
	 */
	public void setNoticeInvolevesDPS(boolean noticeInvolevesDPS) {
		this.noticeInvolevesDPS = noticeInvolevesDPS;
	}

	/**
	 * @return the dpsPurchasers
	 */
	@Mapping("DPSADDITIONALPURCHASERS")
	public boolean isDpsPurchasers() {
		return dpsPurchasers;
	}

	/**
	 * @param dpsPurchasers the dpsPurchasers to set
	 */
	public void setDpsPurchasers(boolean dpsPurchasers) {
		this.dpsPurchasers = dpsPurchasers;
	}

	/**
	 * @return the frameworkJustFour
	 */
	@Mapping("FRAMEWORK.JUSTIFICATION")
	@TedMaxLength(400)
	public String getFrameworkJustFour() {
		return frameworkJustFour;
	}

	/**
	 * @param frameworkJustFour the frameworkJustFour to set
	 */
	public void setFrameworkJustFour(String frameworkJustFour) {
		this.frameworkJustFour = frameworkJustFour;
	}

	/**
	 * @return the eauctionWillUsed
	 */
	@Mapping("EAUCTIONUSED")
	public boolean isEauctionWillUsed() {
		return eauctionWillUsed;
	}

	/**
	 * @param eauctionWillUsed the eauctionWillUsed to set
	 */
	public void setEauctionWillUsed(boolean eauctionWillUsed) {
		this.eauctionWillUsed = eauctionWillUsed;
	}

	/**
	 * @return the eauctionInfoAddit
	 */
	@Mapping("INFOADDEAUCTION")
	@TedMaxLength(400)
	public String getEauctionInfoAddit() {
		return eauctionInfoAddit;
	}

	/**
	 * @param eauctionInfoAddit the eauctionInfoAddit to set
	 */
	public void setEauctionInfoAddit(String eauctionInfoAddit) {
		this.eauctionInfoAddit = eauctionInfoAddit;
	}

	/**
	 * @return the limitReceiptTendersReqPartDate
	 */
	@Mapping("DATERECEIPTTENDERS")
	@TedRequired
	public Date getLimitReceiptTendersReqPartDate() {
		return limitReceiptTendersReqPartDate;
	}

	/**
	 * @param limitReceiptTendersReqPartDate the limitReceiptTendersReqPartDate to set
	 */
	public void setLimitReceiptTendersReqPartDate(Date limitReceiptTendersReqPartDate) {
		this.limitReceiptTendersReqPartDate = limitReceiptTendersReqPartDate;
	}

	/**
	 * @return the limitReceiptTendersReqPartTime
	 */
	@Mapping("TIMERECEIPTTENDERS")
	@TedMaxLength(5)
	@TedRequired
	public String getLimitReceiptTendersReqPartTime() {
		return format(limitReceiptTendersReqPartDate);
	}

	// /**
	// * @param limitReceiptTendersReqPartTime the limitReceiptTendersReqPartTime to set
	// */
	// public void setLimitReceiptTendersReqPartTime(String limitReceiptTendersReqPartTime) {
	// this.limitReceiptTendersReqPartTime = limitReceiptTendersReqPartTime;
	// }

	/**
	 * @return the languagesAllowed
	 */
	@Mapping("LANGUAGES")
	@TedRequired
	public List<Language> getLanguagesAllowed() {
		return languagesAllowed;
	}

	/**
	 * @param languagesAllowed the languagesAllowed to set
	 */
	public void setLanguagesAllowed(List<Language> languagesAllowed) {
		this.languagesAllowed = languagesAllowed;
	}

}
