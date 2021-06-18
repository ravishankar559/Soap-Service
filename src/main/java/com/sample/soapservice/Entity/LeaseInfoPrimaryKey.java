package com.sample.soapservice.Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LeaseInfoPrimaryKey implements Serializable {
	
	private String accessoryId;
	
	private String contractName;

	public String getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	

}
