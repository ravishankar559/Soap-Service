package com.sample.soapservice.EndPoints;

import java.util.List;

import org.example.leaseeligbility.GetLeaseEligibilityRequest;
import org.example.leaseeligbility.GetLeaseEligibilityResponse;
import org.example.leaseeligbility.LeaseInfoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sample.soapservice.Entity.LeaseInfo;
import com.sample.soapservice.Interfaces.LeaseInfoRespository;

@Endpoint
public class LeaseEligibilityEndPoint {
	
	private static final String NAMESPACE_URI = "http://www.example.org/LeaseEligbility";
	
	@Autowired
	private LeaseInfoRespository leaseInfoRespository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLeaseEligibilityRequest")
	@ResponsePayload
	public GetLeaseEligibilityResponse getLeaseEligibility(@RequestPayload GetLeaseEligibilityRequest request) {
		GetLeaseEligibilityResponse response = new GetLeaseEligibilityResponse();
		List<LeaseInfo> leaseInfoList = leaseInfoRespository.findAllByAccessoryId(request.getAccessoryId());
		response.setAccessoryId(request.getAccessoryId());
		if(null != leaseInfoList && !leaseInfoList.isEmpty()) {
			for(LeaseInfo leaseInfo : leaseInfoList) {
				LeaseInfoType leaseInfoType = new LeaseInfoType();
				leaseInfoType.setContractName(leaseInfo.getLeaseInfoPrimaryKey().getContractName());
				leaseInfoType.setContractTerm(leaseInfo.getContractTerm());
				leaseInfoType.setDownPayment(leaseInfo.getDownPayment());
				leaseInfoType.setMonthlyInstallment(leaseInfo.getMonthlyInstallment());
				response.getLeaseInfo().add(leaseInfoType);
			}	
		}
		
		return response;
	}

}
