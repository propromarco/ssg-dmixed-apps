package de.subreport.elvis.shared.ted;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;
import de.subreport.elvis.shared.ted.dto.NutsCodeDto;
import de.subreport.elvis.shared.ted.validation.TEDEmail;
import de.subreport.elvis.shared.ted.validation.TEDUrl;

public class AddressContractingBody extends AbstractAdress implements ContainsTEDMappings {

	private String nationalId;		// max 100 Zeichen
	private NutsCodeDto nutscode; 	// max. 5 Zeichen
	private String contactpoint;	// max 300 Zeichen
	private String urlGeneral;		// max 200 Zeichen
	private String urlBuyerprofile;	// max 200 Zeichen

	public AddressContractingBody() {
	}

	@Mapping("NATIONALID")
	@TedMaxLength(100)
	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	@Mapping("NUTS")
	@TedMaxLength(5)
	@TedRequired
	public NutsCodeDto getNutscode() {
		return nutscode;
	}

	public void setNutscode(NutsCodeDto nutscode) {
		this.nutscode = nutscode;
	}

	@Mapping("CONTACTPOINT")
	@TedMaxLength(300)
	public String getContactpoint() {
		return contactpoint;
	}

	public void setContactpoint(String contactpoint) {
		this.contactpoint = contactpoint;
	}

	@Override
	@Mapping("EMAIL")
	@TedMaxLength(200)
	@TedRequired
	@TEDEmail
	public String getAddressEmail() {
		return super.getAddressEmail();
	}

	@Mapping("URLGENERAL")
	@TedMaxLength(200)
	@TedRequired
	@TEDUrl
	public String getUrlGeneral() {
		return urlGeneral;
	}

	public void setUrlGeneral(String urlGeneral) {
		this.urlGeneral = urlGeneral;
	}

	@Mapping("URLBUYER")
	@TedMaxLength(200)
	@TEDUrl
	public String getUrlBuyerprofile() {
		return urlBuyerprofile;
	}

	public void setUrlBuyerprofile(String urlBuyerprofile) {
		this.urlBuyerprofile = urlBuyerprofile;
	}

	@Override
	public boolean isEmpty() {
		int result = 0;
		result = result + ((contactpoint == null || contactpoint.isEmpty()) ? 0 : contactpoint.hashCode());
		result = result + ((nationalId == null || nationalId.isEmpty()) ? 0 : nationalId.hashCode());
		result = result + ((nutscode == null) ? 0 : nutscode.hashCode());
		result = result + ((urlBuyerprofile == null || urlBuyerprofile.isEmpty()) ? 0 : urlBuyerprofile.hashCode());
		result = result + ((urlGeneral == null || urlGeneral.isEmpty()) ? 0 : urlGeneral.hashCode());
		return result == 0 && super.isEmpty();
	}

}
