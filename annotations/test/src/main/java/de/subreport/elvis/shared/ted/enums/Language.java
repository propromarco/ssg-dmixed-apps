package de.subreport.elvis.shared.ted.enums;

public enum Language {

	AR(),
	BG(),
	BR(),
	CA(),
	CO(),
	CS(),
	CY(),
	DA(),
	DE(),
	EL(),
	EN(),
	ES(),
	ET(),
	EU(),
	FI(),
	FO(),
	FR(),
	FY(),
	GA(),
	GD(),
	GL(),
	HE(),
	HR(),
	HU(),
	HY(),
	IS(),
	IT(),
	JA(),
	KL(),
	KO(),
	KU(),
	LB(),
	LT(),
	LV(),
	// ME(),
	MK(),
	MS(),
	MT(),
	NL(),
	NO(),
	OC(),
	PL(),
	PT(),
	RM(),
	RO(),
	SE(),
	SK(),
	SL(),
	SQ(),
	SR(),
	SV(),
	TA(),
	TR(),
	WA(),
	ZH();

	private Language() {
	}

	public String value() {
		return name();
	}

	public static Language fromValue(String v) {
		return valueOf(v);
	}

}
