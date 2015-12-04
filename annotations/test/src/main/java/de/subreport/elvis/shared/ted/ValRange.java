/**
 * 
 */
package de.subreport.elvis.shared.ted;

import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.enums.Currency;

/**
 * @author Rolf
 *
 */
public class ValRange implements ContainsTEDMappings, IsSerializable {

	private BigDecimal low;
	private BigDecimal high;
	private Currency currency;

	/**
	 * 
	 */
	public ValRange() {
	}

	/**
	 * @return the low
	 */
	@Mapping("LOW")
	public BigDecimal getLow() {
		return low;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(BigDecimal low) {
		this.low = low;
	}

	/**
	 * @return the high
	 */
	@Mapping("HIGH")
	public BigDecimal getHigh() {
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	/**
	 * @return the currency
	 */
	@Mapping("CURRENCY")
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
