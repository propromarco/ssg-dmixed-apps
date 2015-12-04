package de.subreport.elvis.shared.ted.enums;

public enum Currency {
	GBP(),
	ISK(),
	CHF(),
	SEK(),
	JPY(),
	NOK(),
	RON(),
	CZK(),
	DKK(),
	PLN(),
	BGN(),
	HUF(),
	USD(),
	EUR(),
	MKD(),
	TRY(),
	HRK();

	private Currency() {
	}

	public String value() {
		return name();
	}

	public static Currency fromValue(String v) {
		return valueOf(v);
	}

}
