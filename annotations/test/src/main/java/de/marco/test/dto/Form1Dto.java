package de.marco.test.dto;

import java.util.List;

import de.marco.test.annotations.Mapping;
import de.marco.test.annotations.MappingMain;

@MappingMain("de.marco.test.jaxb.FormularI")
public class Form1Dto extends AbstractFormDto {

	private String name, ort;
	private AdresseDto mainAdresse;
	private List<AdresseDto> zusatzAdressen;
	private List<String> languages;

	@Mapping("title")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Mapping("nameDesOrtes")
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Mapping("object.adresse")
	public AdresseDto getMainAdresse() {
		return mainAdresse;
	}

	public void setMainAdresse(final AdresseDto mainAdresse) {
		this.mainAdresse = mainAdresse;
	}

	@Mapping("object.additionalAdresses")
	public List<AdresseDto> getZusatzAdressen() {
		return zusatzAdressen;
	}

	public void setZusatzAdressen(final List<AdresseDto> zusatzAdressen) {
		this.zusatzAdressen = zusatzAdressen;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

}
