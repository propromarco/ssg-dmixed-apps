package de.subreport.elvis.shared.ted.enums;

public enum AwardCriteria {
	AC_COST("award_lowest_cost"), // Kein Pfad, da entweder eine Liste mit gewichteten Kosten
	AC_PRICE("price");	// ... oder eine Gewichtung des Preises stattfindet.

	private String name;

	private AwardCriteria(String name) {
		this.name = name;
	}

	public String getElementName() {
		return name;
	}
}
