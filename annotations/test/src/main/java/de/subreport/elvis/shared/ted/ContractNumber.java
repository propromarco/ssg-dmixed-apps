/**
 * 
 */
package de.subreport.elvis.shared.ted;

import de.marco.test.annotations.Mapping;

/**
 * @author Rolf
 *
 */
public class ContractNumber implements Section, ContainsTEDMappings {

	private String contractNo;
	private String lotNo;

	/**
	 * 
	 */
	public ContractNumber() {
	}

	/**
	 * @return the contractNo
	 */
	@Mapping("CONTRACTNO")
	public String getContractNo() {
		return contractNo;
	}

	/**
	 * @param contractNo the contractNo to set
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	/**
	 * @return the lotNo
	 */
	@Mapping("LOTNO")
	public String getLotNo() {
		return lotNo;
	}

	/**
	 * @param lotNo the lotNo to set
	 */
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

}
