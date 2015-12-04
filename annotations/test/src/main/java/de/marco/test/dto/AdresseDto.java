package de.marco.test.dto;

import de.marco.test.annotations.Mapping;
import de.marco.test.annotations.MappingMain;

@MappingMain("de.marco.test.jaxb.Address")
public class AdresseDto {

	private String strasse, hausnummer;

	@Mapping("strasse")
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(final String strasse) {
		this.strasse = strasse;
	}

	@Mapping("hnr")
	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

}
