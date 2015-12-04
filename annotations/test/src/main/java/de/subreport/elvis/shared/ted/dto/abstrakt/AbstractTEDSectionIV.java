package de.subreport.elvis.shared.ted.dto.abstrakt;

import java.util.Date;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.enums.GPA;

public abstract class AbstractTEDSectionIV implements Section, ContainsTEDMappings {

	// IV.1 Beschreibung

	// IV.1.8 Angaben zum Beschaffungsübereinkommen (GPA)
	private GPA gpa = GPA.NO_CONTRACT_COVERED_GPA;

	/**
	 * 
	 */
	public AbstractTEDSectionIV() {
	}

	/**
	 * @return the gpa
	 */
	@Mapping("")
	public GPA getGpa() {
		return gpa;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(GPA gpa) {
		this.gpa = gpa;
	}

	@SuppressWarnings("deprecation")
	protected String format(Date date) {
		if (date == null) {
			return null;
		}
		final int hours = date.getHours();
		final int minutes = date.getMinutes();
		return (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes);
	}

}
