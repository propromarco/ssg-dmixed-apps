package de.subreport.elvis.shared.ted.dto;

import com.google.gwt.user.client.rpc.GwtTransient;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.dto.abstrakt.CodeDto;

/**
 * This Class maps the Nuts-Code Excel List into a form
 * that it can be handle to build a Tree with.
 * 
 * @see CodeDto
 * @author Heinrichs
 *
 */
public class NutsCodeDto extends CodeDto<NutsCodeDto> implements ContainsTEDMappings {

	private static final long serialVersionUID = 4959510870796171803L;

	@GwtTransient
	private String isoCode;
	@GwtTransient
	private String isoId;
	@GwtTransient
	private int lvl;

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getIsoId() {
		return isoId;
	}

	public void setIsoId(String isoId) {
		this.isoId = isoId;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	@Override
	@Mapping("CODE")
	public String getCode() {
		return code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
		result = prime * result + ((isoId == null) ? 0 : isoId.hashCode());
		result = prime * result + lvl;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NutsCodeDto other = (NutsCodeDto) obj;
		if (isoCode == null) {
			if (other.isoCode != null) {
				return false;
			}
		} else if (!isoCode.equals(other.isoCode)) {
			return false;
		}
		if (isoId == null) {
			if (other.isoId != null) {
				return false;
			}
		} else if (!isoId.equals(other.isoId)) {
			return false;
		}
		if (lvl != other.lvl) {
			return false;
		}
		return true;
	}

}
