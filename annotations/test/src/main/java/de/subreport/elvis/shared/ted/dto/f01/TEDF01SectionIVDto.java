/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f01;

import java.util.Date;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionIV;
import de.subreport.elvis.shared.ted.enums.TypeProcedureF01;

/**
 * @author Rolf
 *
 */
public class TEDF01SectionIVDto extends AbstractTEDSectionIV {

	// IV.1.1 Verfahrensart
	private TypeProcedureF01 typeProcedure;

	// IV.2.5 Voraussichtlicher Beginn der Vergabeverfahren
	private Date dateAwardScheduled;

	/**
	 * 
	 */
	public TEDF01SectionIVDto() {
	}

	/**
	 * @return the typeProcedure
	 */
	@Mapping("")
	public TypeProcedureF01 getTypeProcedure() {
		return typeProcedure;
	}

	/**
	 * @param typeProcedure the typeProcedure to set
	 */
	public void setTypeProcedure(TypeProcedureF01 typeProcedure) {
		this.typeProcedure = typeProcedure;
	}

	/**
	 * @return the dateAwardScheduled
	 */
	@Mapping("DATEAWARDSCHEDULED")
	public Date getDateAwardScheduled() {
		return dateAwardScheduled;
	}

	/**
	 * @param dateAwardScheduled the dateAwardScheduled to set
	 */
	public void setDateAwardScheduled(Date dateAwardScheduled) {
		this.dateAwardScheduled = dateAwardScheduled;
	}
}
