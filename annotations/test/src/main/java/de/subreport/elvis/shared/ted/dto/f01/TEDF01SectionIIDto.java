/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ObjectDescriptionF01F02F05;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionIIF01F02F05;

/**
 * @author Rolf
 *
 */
public class TEDF01SectionIIDto extends AbstractTEDSectionIIF01F02F05 {

	// II 2. Beschreibung
	private List<ObjectDescriptionF01F02F05> description = new ArrayList<ObjectDescriptionF01F02F05>();	// Wenn divisionLots = NO hat die Liste nur ein Element bei dem lotNumber nicht gesetzt ist
	// Wenn devisionLots = YES hat die Liste soviele Elemente wie es Lose gibt, max 1000

	// III Voraussichtlicher Tag der Veröffentlichung der Auftragsbekanntmachung
	private Date datePublicationNotice;

	/**
	 * 
	 */
	public TEDF01SectionIIDto() {
	}

	/**
	 * @return the description
	 */
	@Mapping("OBJECTDESCRS")
	public List<ObjectDescriptionF01F02F05> getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(List<ObjectDescriptionF01F02F05> description) {
		this.description = description;
	}

	/**
	 * @return the datePublicationNotice
	 */
	@Mapping("DATEPUBLICATIONNOTICE")
	public Date getDatePublicationNotice() {
		return datePublicationNotice;
	}

	/**
	 * @param datePublicationNotice the datePublicationNotice to set
	 */
	public void setDatePublicationNotice(Date datePublicationNotice) {
		this.datePublicationNotice = datePublicationNotice;
	}

}
