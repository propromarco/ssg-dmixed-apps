package de.subreport.elvis.shared.ted;

import com.google.gwt.user.client.rpc.IsSerializable;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;
import de.subreport.elvis.shared.ted.enums.Countries;
import de.subreport.elvis.shared.ted.validation.TEDEmail;
import de.subreport.elvis.shared.ted.validation.TEDPhone;

public abstract class AbstractAdress implements IsSerializable {

	private String nameOfficial;
	private String addressPostal;
	private String addressTown;
	private String addressPostcode;
	private Countries addressCountry;
	private String addressPhone;
	private String addressEmail;
	private String addressFax;

	public AbstractAdress() {
	}

	@Mapping("OFFICIALNAME")
	@TedMaxLength(300)
	@TedRequired
	public String getNameOfficial() {
		return nameOfficial;
	}

	public void setNameOfficial(String nameOfficial) {
		this.nameOfficial = nameOfficial;
	}

	@Mapping("ADDRESS")
	@TedMaxLength(400)
	public String getAddressPostal() {
		return addressPostal;
	}

	public void setAddressPostal(String addressPostal) {
		this.addressPostal = addressPostal;
	}

	@Mapping("TOWN")
	@TedMaxLength(100)
	@TedRequired
	public String getAddressTown() {
		return addressTown;
	}

	public void setAddressTown(String addressTown) {
		this.addressTown = addressTown;
	}

	@Mapping("POSTALCODE")
	@TedMaxLength(20)
	public String getAddressPostcode() {
		return addressPostcode;
	}

	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}

	@Mapping("COUNTRY.VALUE")
	@TedMaxLength(2)
	@TedRequired
	public Countries getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(Countries addressCountry) {
		this.addressCountry = addressCountry;
	}

	@Mapping("PHONE")
	@TedMaxLength(100)
	@TEDPhone
	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	@Mapping("EMAIL")
	@TedMaxLength(200)
	@TEDEmail
	public String getAddressEmail() {
		return addressEmail;
	}

	public void setAddressEmail(String addressEmail) {
		this.addressEmail = addressEmail;
	}

	@Mapping("FAX")
	@TedMaxLength(100)
	@TEDPhone
	public String getAddressFax() {
		return addressFax;
	}

	public void setAddressFax(String addressFax) {
		this.addressFax = addressFax;
	}

	public boolean isEmpty() {
		int result = 0;
		result = result + ((addressCountry == null) ? 0 : addressCountry.hashCode());
		result = result + ((addressEmail == null || addressEmail.isEmpty()) ? 0 : addressEmail.hashCode());
		result = result + ((addressFax == null || addressFax.isEmpty()) ? 0 : addressFax.hashCode());
		result = result + ((addressPhone == null || addressPhone.isEmpty()) ? 0 : addressPhone.hashCode());
		result = result + ((addressPostal == null || addressPostal.isEmpty()) ? 0 : addressPostal.hashCode());
		result = result + ((addressPostcode == null || addressPostcode.isEmpty()) ? 0 : addressPostcode.hashCode());
		result = result + ((addressTown == null || addressTown.isEmpty()) ? 0 : addressTown.hashCode());
		result = result + ((nameOfficial == null || nameOfficial.isEmpty()) ? 0 : nameOfficial.hashCode());
		return result == 0;
	}

}
