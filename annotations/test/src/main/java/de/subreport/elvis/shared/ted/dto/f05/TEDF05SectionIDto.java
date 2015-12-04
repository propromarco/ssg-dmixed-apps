/**
 * 
 */
package de.subreport.elvis.shared.ted.dto.f05;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.AddressContractingBody;
import de.subreport.elvis.shared.ted.AdressesForSectionI;
import de.subreport.elvis.shared.ted.ContainsTEDMappings;
import de.subreport.elvis.shared.ted.Section;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.dto.abstrakt.AbstractTEDSectionI;
import de.subreport.elvis.shared.ted.enums.CeActivity;
import de.subreport.elvis.shared.ted.enums.DocumentUrl;
import de.subreport.elvis.shared.ted.enums.Information;
import de.subreport.elvis.shared.ted.enums.TenderRequest;
import de.subreport.elvis.shared.ted.validation.TEDUrl;

/**
 * @author Rolf
 *
 */
public class TEDF05SectionIDto extends AbstractTEDSectionI implements Section, AdressesForSectionI, ContainsTEDMappings {

	// I.3 Kommunikation
	private DocumentUrl documentUrl = DocumentUrl.DOCUMENT_FULL;
	private String adressObtainDoc;	// Wenn documentRestriction DOCUMENT_FULL ist, max 200 Zeichen
	private String docsResticted;	// Wenn documentRestiction DOCUMENT_RESTICTED ist, max 200 Zeichen

	private Information information;
	private AddressContractingBody addressAnother; // Wenn addressFurtherInfo ADDRESS_FURTHER_INFO ist

	private boolean sendTendersCheckBox;
	private String addressSendTenders;	// Wenn sendTendersCheckBox true ist, max 200 Zeichen
	private TenderRequest tenderRequest;
	private AddressContractingBody addressFollowing = new AddressContractingBody(); // Wenn addressParticipation ADDRESS_PARTICIPATION ist

	private boolean urlCommunicationToolsCheckBox;
	private String urlCommunicationTools;	// Wenn urlCommunicationToolsCheckBox true ist, max 200 Zeichen

	// I.6 Haupttätigkeit
	private CeActivity ceActivity;
	private String otherActivity;	// Wenn ceActivity OTHER ist, max. 200 Zeichen

	/**
	 * 
	 */
	public TEDF05SectionIDto() {
	}

	@Mapping("")
	public DocumentUrl getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(DocumentUrl documentUrlMan) {
		this.documentUrl = documentUrlMan;
	}

	@Mapping("URLDOCUMENT")
	@TedMaxLength(200)
	@TEDUrl
	public String getAdressObtainDoc() {
		return adressObtainDoc;
	}

	public void setAdressObtainDoc(String adressObtainDoc) {
		this.adressObtainDoc = adressObtainDoc;
	}

	@Mapping("URLDOCUMENT")
	@TedMaxLength(200)
	@TEDUrl
	public String getDocsResticted() {
		return docsResticted;
	}

	public void setDocsResticted(String docsResticted) {
		this.docsResticted = docsResticted;
	}

	@Mapping("")
	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	@Mapping("ADDRESSFURTHERINFO")
	public AddressContractingBody getAddressAnother() {
		return addressAnother;
	}

	@Override
	public void setAddressAnother(AddressContractingBody addressAnother) {
		this.addressAnother = addressAnother;
	}

	public boolean isSendTendersCheckBox() {
		return sendTendersCheckBox;
	}

	public void setSendTendersCheckBox(boolean sendTendersCheckBox) {
		this.sendTendersCheckBox = sendTendersCheckBox;
	}

	@Mapping("URLPARTICIPATION")
	@TedMaxLength(200)
	@TEDUrl
	public String getAddressSendTenders() {
		return addressSendTenders;
	}

	public void setAddressSendTenders(String addressSendTenders) {
		this.addressSendTenders = addressSendTenders;
	}

	@Mapping("")
	public TenderRequest getTenderRequest() {
		return tenderRequest;
	}

	public void setTenderRequest(TenderRequest tenderRequest) {
		this.tenderRequest = tenderRequest;
	}

	@Mapping("ADDRESSPARTICIPATION")
	public AddressContractingBody getAddressFollowing() {
		return addressFollowing;
	}

	@Override
	public void setAddressFollowing(AddressContractingBody addressFollowing) {
		this.addressFollowing = addressFollowing;
	}

	public boolean isUrlCommunicationToolsCheckBox() {
		return urlCommunicationToolsCheckBox;
	}

	public void setUrlCommunicationToolsCheckBox(boolean urlCommunicationToolsCheckBox) {
		this.urlCommunicationToolsCheckBox = urlCommunicationToolsCheckBox;
	}

	@Mapping("URLTOOL")
	@TedMaxLength(200)
	@TEDUrl
	public String getUrlCommunicationTools() {
		return urlCommunicationTools;
	}

	public void setUrlCommunicationTools(String urlCommunicationTools) {
		this.urlCommunicationTools = urlCommunicationTools;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.f05.IF05SectionI#getCeActivity()
	 */
	@Mapping("CEACTIVITY.VALUE")
	public CeActivity getCeActivity() {
		return ceActivity;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.f05.IF05SectionI#setCeActivity(de.subreport.elvis.shared.ted.enums.CeActivity)
	 */
	public void setCeActivity(CeActivity ceActivity) {
		this.ceActivity = ceActivity;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.f05.IF05SectionI#getOtherActivity()
	 */
	@Mapping("CEACTIVITYOTHER")
	@TedMaxLength(200)
	public String getOtherActivity() {
		return otherActivity;
	}

	/*
	 * (non-Javadoc)
	 * @see de.subreport.elvis.shared.ted.dto.f05.IF05SectionI#setOtherActivity(java.lang.String)
	 */
	public void setOtherActivity(String otherActivity) {
		this.otherActivity = otherActivity;
	}

}
