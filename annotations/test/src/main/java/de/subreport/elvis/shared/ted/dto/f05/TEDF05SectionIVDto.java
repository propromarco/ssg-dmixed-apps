/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f05;

import java.util.Date;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionIVF02F05;
import de.subreport.elvis.shared.ted.enums.TypeProcedureF02F05;
import de.subreport.elvis.shared.ted.validation.TEDNumberOj;

/**
 * @author Rolf
 *
 */
public class TEDF05SectionIVDto extends AbstractTEDSectionIVF02F05 {

	// IV.1.1 Verfahrensart
	private TypeProcedureF02F05 typeProcedure;

	// IV.2.1 Frühere Bekanntmachung zu diesem Verfahren
	private String numberOj;

	// IV.2.3 Voraussichtlicher Tag der Absendung der Aufforderungen zur Angebotsabgabe bzw. zur Teilnahme an ausgewählte Bewerber
	private Date dateDispatchTenderParticipate;

	// IV.2.7 Bedingungen für die Öffnung der Angebote
	private Date openingConditionsDate;
	// private String openingsConditionsTime;
	private String openingsConditionsPlace;
	private String openingAdditInfo;

	/**
	 * 
	 */
	public TEDF05SectionIVDto() {
		super();
	}

	/**
	 * @return the typeProcedure
	 */
	@Mapping("")
	public TypeProcedureF02F05 getTypeProcedure() {
		return typeProcedure;
	}

	/**
	 * @param typeProcedure the typeProcedure to set
	 */
	public void setTypeProcedure(TypeProcedureF02F05 typeProcedure) {
		this.typeProcedure = typeProcedure;
	}

	/**
	 * @return the numberOj
	 */
	@Mapping("NOTICENUMBEROJ")
	@TEDNumberOj
	public String getNumberOj() {
		return numberOj;
	}

	/**
	 * @param numberOj the numberOj to set
	 */
	public void setNumberOj(String numberOj) {
		this.numberOj = numberOj;
	}

	/**
	 * @return the dateDispatchTenderParticipate
	 */
	@Override
	@Mapping("DATEDISPATCHINVITATIONS")
	public Date getDateDispatchTenderParticipate() {
		return dateDispatchTenderParticipate;
	}

	/**
	 * @param dateDispatchTenderParticipate the dateDispatchTenderParticipate to set
	 */
	@Override
	public void setDateDispatchTenderParticipate(Date dateDispatchTenderParticipate) {
		this.dateDispatchTenderParticipate = dateDispatchTenderParticipate;
	}

	/**
	 * @return the openingConditionsDate
	 */
	@Override
	@Mapping("OPENINGCONDITION.DATEOPENINGTENDERS")
	public Date getOpeningConditionsDate() {
		return openingConditionsDate;
	}

	/**
	 * @param openingConditionsDate the openingConditionsDate to set
	 */
	@Override
	public void setOpeningConditionsDate(Date openingConditionsDate) {
		this.openingConditionsDate = openingConditionsDate;
	}

	/**
	 * @return the openingsConditionsTime
	 */
	@Override
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
	@Override
	@Mapping("OPENINGCONDITION.PLACE")
	@TedMaxLength(400)
	public String getOpeningsConditionsPlace() {
		return openingsConditionsPlace;
	}

	/**
	 * @param openingsConditionsPlace the openingsConditionsPlace to set
	 */
	@Override
	public void setOpeningsConditionsPlace(String openingsConditionsPlace) {
		this.openingsConditionsPlace = openingsConditionsPlace;
	}

	/**
	 * @return the openingAdditInfo
	 */
	@Override
	@Mapping("OPENINGCONDITION.INFOADD")
	@TedMaxLength(400)
	public String getOpeningAdditInfo() {
		return openingAdditInfo;
	}

	/**
	 * @param openingAdditInfo the openingAdditInfo to set
	 */
	@Override
	public void setOpeningAdditInfo(String openingAdditInfo) {
		this.openingAdditInfo = openingAdditInfo;
	}

}
