package de.subreport.elvis.shared.ted;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.validation.TEDUrl;

public class ContactReview extends AbstractAdress implements ContainsTEDMappings {

	private String internet;

	public ContactReview() {
	}

	@Mapping("URL")
	@TedMaxLength(200)
	@TEDUrl
	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	@Override
	public boolean isEmpty() {
		int result = 0;
		result = result + ((internet == null || internet.isEmpty()) ? 0 : internet.hashCode());
		return result == 0 && super.isEmpty();
	}

}
