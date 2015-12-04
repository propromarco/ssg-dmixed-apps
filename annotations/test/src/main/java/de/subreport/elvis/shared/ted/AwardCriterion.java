package de.subreport.elvis.shared.ted;

import com.google.gwt.user.client.rpc.IsSerializable;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;

public class AwardCriterion implements IsSerializable, ContainsTEDMappings {

	private String criterion;	// max 200 Zeichen
	private String weighting;	// max 20 Zeichen

	/**
	 * 
	 */
	public AwardCriterion() {
	}

	/**
	 * @return the name
	 */
	@Mapping("ACCRITERION")
	@TedMaxLength(200)
	public String getCriterion() {
		return criterion;
	}

	/**
	 * @param name the name to set
	 */
	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}

	/**
	 * @return the weight
	 */
	@Mapping("ACWEIGHTING")
	@TedMaxLength(20)
	public String getWeighting() {
		return weighting;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeighting(String weighting) {
		this.weighting = weighting;
	}

}
