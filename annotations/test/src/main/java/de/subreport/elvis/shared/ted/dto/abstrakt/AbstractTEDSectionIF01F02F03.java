/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.abstrakt;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.enums.CaActivity;
import de.subreport.elvis.shared.ted.enums.CaType;

/**
 * @author Rolf
 *
 */
public abstract class AbstractTEDSectionIF01F02F03 extends AbstractTEDSectionI implements Section, ContainsTEDMappings {

	// I.4 Art des öffentlichen Auftraggebers
	private CaType caType = CaType.MINISTRY;
	private String otherType;	// Wenn caType OTHER ist, max. 200 Zeichen

	// I.5 Haupttätigkeit
	private CaActivity caActivity = CaActivity.GENERAL_PUBLIC_SERVICES;
	private String otherActivity;	// Wenn caActivity OTHER ist, max. 200 Zeichen

	/**
	 * 
	 */
	public AbstractTEDSectionIF01F02F03() {
	}

	@Mapping("CATYPE.VALUE")
	public CaType getCaType() {
		return caType;
	}

	public void setCaType(CaType caType) {
		this.caType = caType;
	}

	@Mapping("CATYPEOTHER")
	@TedMaxLength(200)
	public String getOtherType() {
		return otherType;
	}

	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}

	@Mapping("CAACTIVITY.VALUE")
	public CaActivity getCaActivity() {
		return caActivity;
	}

	public void setCaActivity(CaActivity caActivity) {
		this.caActivity = caActivity;
	}

	@Mapping("CAACTIVITYOTHER")
	@TedMaxLength(200)
	public String getOtherActivity() {
		return otherActivity;
	}

	public void setOtherActivity(String otherActivity) {
		this.otherActivity = otherActivity;
	}

}
