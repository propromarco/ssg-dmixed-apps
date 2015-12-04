/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.abstrakt;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.enums.Type;

/**
 * @author Rolf
 *
 */
public abstract class AbstractTEDSection0 implements Section, ContainsTEDMappings {

	private Type type;

	/**
	 * 
	 */

	public AbstractTEDSection0() {
	}

	/**
	 * @return the type
	 */
	@Mapping("TYPE")
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

}
