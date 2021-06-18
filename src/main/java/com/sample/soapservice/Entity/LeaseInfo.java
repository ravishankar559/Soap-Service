package com.sample.soapservice.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LeaseInfo")
public class LeaseInfo {
	
	@EmbeddedId
	private LeaseInfoPrimaryKey leaseInfoPrimaryKey;
	
	private int contractTerm;
	
	private double downPayment;
	
	private double monthlyInstallment;

	public LeaseInfoPrimaryKey getLeaseInfoPrimaryKey() {
		return leaseInfoPrimaryKey;
	}

	public void setLeaseInfoPrimaryKey(LeaseInfoPrimaryKey leaseInfoPrimaryKey) {
		this.leaseInfoPrimaryKey = leaseInfoPrimaryKey;
	}

	public int getContractTerm() {
		return contractTerm;
	}

	public void setContractTerm(int contractTerm) {
		this.contractTerm = contractTerm;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getMonthlyInstallment() {
		return monthlyInstallment;
	}

	public void setMonthlyInstallment(double monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}
	
}
