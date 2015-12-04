/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.abstrakt;

import java.util.Date;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.enums.MinTimeMaintain;

/**
 * @author Rolf
 *
 */
public abstract class AbstractTEDSectionIVF02F05 extends AbstractTEDSectionIVF01F02F05 {

	// IV.1.4 Angaben zur Verringerung der Zahl der Wirtschaftsteilnehmer oder Lösungen im Laufe der Verhandlung bzw. des Dialogs
	private boolean reductionRecourse;

	// IV.2.3 Voraussichtlicher Tag der Absendung der Aufforderungen zur Angebotsabgabe bzw. zur Teilnahme an ausgewählte Bewerber
	private Date dateDispatchTenderParticipate;

	private MinTimeMaintain minTimeMaintain = MinTimeMaintain.DateTenderValid;
	// IV.2.6 Bindefrist des Angebots
	private Date dateTenderValid;
	private Integer durationMonthsValue;

	// IV.2.7 Bedingungen für die Öffnung der Angebote
	private Date openingConditionsDate;
	// private String openingsConditionsTime;
	private String openingsConditionsPlace;
	private String openingAdditInfo;

	/**
	 * 
	 */
	public AbstractTEDSectionIVF02F05() {
		super();
	}

	/**
	 * @return the reductionRecourse
	 */
	@Mapping("REDUCTIONRECOURSE")
	public boolean isReductionRecourse() {
		return reductionRecourse;
	}

	/**
	 * @param reductionRecourse the reductionRecourse to set
	 */
	public void setReductionRecourse(boolean reductionRecourse) {
		this.reductionRecourse = reductionRecourse;
	}

	/**
	 * @return the dateDispatchTenderParticipate
	 */
	@Mapping("DATEDISPATCHINVITATIONS")
	public Date getDateDispatchTenderParticipate() {
		return dateDispatchTenderParticipate;
	}

	/**
	 * @param dateDispatchTenderParticipate the dateDispatchTenderParticipate to set
	 */
	public void setDateDispatchTenderParticipate(Date dateDispatchTenderParticipate) {
		this.dateDispatchTenderParticipate = dateDispatchTenderParticipate;
	}

	/**
	 * @return the dateTenderValid
	 */
	@Mapping("DATETENDERVALID")
	public Date getDateTenderValid() {
		return dateTenderValid;
	}

	/**
	 * @param dateTenderValid the dateTenderValid to set
	 */
	public void setDateTenderValid(Date dateTenderValid) {
		this.dateTenderValid = dateTenderValid;
	}

	/**
	 * @return the durationMonthsValue
	 */
	@Mapping("DURATIONTENDERVALID.Value")
	public Integer getDurationMonthsValue() {
		return durationMonthsValue;
	}

	/**
	 * @param durationMonthsValue the durationMonthsValue to set
	 */
	public void setDurationMonthsValue(Integer durationMonthsValue) {
		this.durationMonthsValue = durationMonthsValue;
	}

	/**
	 * @return the openingConditionsDate
	 */
	@Mapping("OPENINGCONDITION.DATEOPENINGTENDERS")
	public Date getOpeningConditionsDate() {
		return openingConditionsDate;
	}

	/**
	 * @param openingConditionsDate the openingConditionsDate to set
	 */
	public void setOpeningConditionsDate(Date openingConditionsDate) {
		this.openingConditionsDate = openingConditionsDate;
	}

	/**
	 * @return the openingsConditionsTime
	 */
	@Mapping("OPENINGCONDITION.TIMEOPENINGTENDERS")
	@TedMaxLength(5)
	public String getOpeningsConditionsTime() {
		return format(openingConditionsDate);
	}

	// /**
	// * @param openingsConditionsTime the openingsConditionsTime to set
	// */
	// public void setOpeningsConditionsTime(String openingsConditionsTime) {
	// this.openingsConditionsTime = openingsConditionsTime;
	// }

	/**
	 * @return the openingsConditionsPlace
	 */
	@Mapping("OPENINGCONDITION.PLACE")
	@TedMaxLength(400)
	public String getOpeningsConditionsPlace() {
		return openingsConditionsPlace;
	}

	/**
	 * @param openingsConditionsPlace the openingsConditionsPlace to set
	 */
	public void setOpeningsConditionsPlace(String openingsConditionsPlace) {
		this.openingsConditionsPlace = openingsConditionsPlace;
	}

	/**
	 * @return the openingAdditInfo
	 */
	@Mapping("OPENINGCONDITION.INFOADD")
	@TedMaxLength(400)
	public String getOpeningAdditInfo() {
		return openingAdditInfo;
	}

	/**
	 * @param openingAdditInfo the openingAdditInfo to set
	 */
	public void setOpeningAdditInfo(String openingAdditInfo) {
		this.openingAdditInfo = openingAdditInfo;
	}

	/**
	 * @return the durationMonthsType
	 */
	@Mapping("DURATIONTENDERVALID.TYPE")
	public String getDurationMonthsType() {
		return getDurationMonthsValue() != null ? "MONTH" : null;
	}

	public MinTimeMaintain getMinTimeMaintain() {
		return minTimeMaintain;
	}

	public void setMinTimeMaintain(MinTimeMaintain minTimeMaintain) {
		this.minTimeMaintain = minTimeMaintain;
	}

}
