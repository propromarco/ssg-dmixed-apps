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
public class Val implements ContainsTEDMappings, IsSerializable {

	private BigDecimal value;
	private Currency currency = Currency.EUR;

	/**
	 * 
	 */
	public Val() {
	}

	/**
	 * @return the value
	 */
	@Mapping("Value")
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
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
