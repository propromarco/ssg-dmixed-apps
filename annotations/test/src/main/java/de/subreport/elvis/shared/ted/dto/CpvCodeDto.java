package de.subreport.elvis.shared.ted.dto;

import com.google.gwt.user.client.rpc.GwtTransient;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.dto.abstrakt.CodeDto;

/**
 * This Class maps the CPV-Code Excel List into a form
 * that it can be handle to build a Tree with.
 * 
 * @see CodeDto
 * @author Heinrichs
 *
 */
public class CpvCodeDto extends CodeDto<CpvCodeDto> implements ContainsTEDMappings {

	private static final long serialVersionUID = 3284417815450676103L;

	@GwtTransient
	private String shortCode;
	@GwtTransient
	private String codeId;
	@GwtTransient
	private String language;

	/**
	 * 
	 * @return The first two letters of the CPV-Code who are declare the top dot.
	 */
	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	/**
	 * 
	 * @return All letters after the first two of the code, which are unique and declare a code and his level.
	 */
	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	@Override
	@Mapping("CPVCODE")
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return The first two letters of the language from the name.
	 */
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
