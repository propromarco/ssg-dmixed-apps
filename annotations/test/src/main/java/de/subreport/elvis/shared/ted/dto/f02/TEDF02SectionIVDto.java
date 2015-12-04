/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f02;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionIVF02F05;
import de.subreport.elvis.shared.ted.enums.TypeProcedureF02F05;
import de.subreport.elvis.shared.ted.validation.TEDNumberOj;

/**
 * @author Rolf
 *
 */
public class TEDF02SectionIVDto extends AbstractTEDSectionIVF02F05 {

	// IV.1.1 Verfahrensart
	private TypeProcedureF02F05 typeProcedure = TypeProcedureF02F05.PT_OPEN;

	private boolean proctypeAcceleratedCheckBox1;	// Wenn typeProcedure = PT_OPEN ist
	private String justification1;					// Wenn proctypeAcceleratedCheckBox1 = true ist
	private boolean proctypeAcceleratedCheckBox2;	// Wenn typeProcedure = PT_RESTRICTED ist
	private String justification2;					// Wenn proctypeAcceleratedCheckBox2 = true ist
	private boolean proctypeAcceleratedCheckBox3;	// Wenn typeProcedure = PT_COMPETITIVE_NEGOTIATION ist
	private String justification3;					// Wenn proctypeAcceleratedCheckBox3 = true ist

	private boolean negotiationWithout;

	// IV.1.5 Angaben zur Verhandlung
	protected boolean rightContractInitialTenders;

	// IV.2 Verwaltung

	// IV.2.1 Frühere Bekanntmachung zu diesem Verfahren
	private String numberOj;

	/**
	 * 
	 */
	public TEDF02SectionIVDto() {
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
	 * @return the justification
	 */
	@Mapping("ACCELERATEDPROC")
	@TedMaxLength(1000)
	public String getJustification() {
		if (typeProcedure == null) {
			return null;
		}
		switch (typeProcedure) {
			case PT_OPEN:
				return justification1;
			case PT_RESTRICTED:
				return justification2;
			case PT_COMPETITIVE_NEGOTIATION:
				return justification3;
			default:
				return null;
		}
	}

	/**
	 * @param justification the justification to set
	 */
	public void setJustification(String justification) {
		if (typeProcedure == null) {
			return;
		}
		switch (typeProcedure) {
			case PT_OPEN:
				justification1 = justification;
				break;
			case PT_RESTRICTED:
				justification2 = justification;
				break;
			case PT_COMPETITIVE_NEGOTIATION:
				justification3 = justification;
				break;
			default:
		}
	}

	/**
	 * @return the negotiationWithout
	 */
	@Mapping("RIGHTCONTRACTINITIALTENDERS")
	public boolean isNegotiationWithout() {
		return negotiationWithout;
	}

	/**
	 * @param negotiationWithout the negotiationWithout to set
	 */
	public void setNegotiationWithout(boolean negotiationWithout) {
		this.negotiationWithout = negotiationWithout;
	}

	/**
	 * @return the rightContractInitialTenders
	 */
	@Mapping("RIGHTCONTRACTINITIALTENDERS")
	public boolean isRightContractInitialTenders() {
		return rightContractInitialTenders;
	}

	/**
	 * @param rightContractInitialTenders the rightContractInitialTenders to set
	 */
	public void setRightContractInitialTenders(boolean rightContractInitialTenders) {
		this.rightContractInitialTenders = rightContractInitialTenders;
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

	// Get/Set für Editor

	public boolean isProctypeAcceleratedCheckBox1() {
		return proctypeAcceleratedCheckBox1;
	}

	public void setProctypeAcceleratedCheckBox1(boolean proctypeAcceleratedCheckBox1) {
		this.proctypeAcceleratedCheckBox1 = proctypeAcceleratedCheckBox1;
	}

	public String getJustification1() {
		return justification1;
	}

	public void setJustification1(String justification1) {
		this.justification1 = justification1;
	}

	public boolean isProctypeAcceleratedCheckBox2() {
		return proctypeAcceleratedCheckBox2;
	}

	public void setProctypeAcceleratedCheckBox2(boolean proctypeAcceleratedCheckBox2) {
		this.proctypeAcceleratedCheckBox2 = proctypeAcceleratedCheckBox2;
	}

	public String getJustification2() {
		return justification2;
	}

	public void setJustification2(String justification2) {
		this.justification2 = justification2;
	}

	public boolean isProctypeAcceleratedCheckBox3() {
		return proctypeAcceleratedCheckBox3;
	}

	public void setProctypeAcceleratedCheckBox3(boolean proctypeAcceleratedCheckBox3) {
		this.proctypeAcceleratedCheckBox3 = proctypeAcceleratedCheckBox3;
	}

	public String getJustification3() {
		return justification3;
	}

	public void setJustification3(String justification3) {
		this.justification3 = justification3;
	}

}
