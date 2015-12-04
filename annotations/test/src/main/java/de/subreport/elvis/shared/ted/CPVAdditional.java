/**
 * 
 */
package de.subreport.elvis.shared.ted;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.dto.CpvCodeDto;
import de.subreport.elvis.shared.ted.dto.SupplementaryCodeDto;

/**
 * @author Rolf
 *
 */
public class CPVAdditional implements IsSerializable {

	private CpvCodeDto cpvMain;
	private List<SupplementaryCodeDto> cpvSupplem = new ArrayList<SupplementaryCodeDto>();	// Maximal 20 Codes in der Liste, 4 Zeichen

	/**
	 * @return the cpvMain
	 */
	@Mapping("CPVCODE")
	public CpvCodeDto getCpvMain() {
		return cpvMain;
	}

	/**
	 * @param cpvMain the cpvMain to set
	 */
	public void setCpvMain(CpvCodeDto cpvMain) {
		this.cpvMain = cpvMain;
	}

	/**
	 * @return the cpvSupplem
	 */
	@Mapping("CPVSUPPLEMENTARYCODES")
	@TedMaxLength(value = 4)
	public List<SupplementaryCodeDto> getCpvSupplem() {
		return cpvSupplem;
	}

	/**
	 * @param cpvSupplem the cpvSupplem to set
	 */
	public void setCpvSupplem(List<SupplementaryCodeDto> cpvSupplem) {
		this.cpvSupplem = cpvSupplem;
	}

}
