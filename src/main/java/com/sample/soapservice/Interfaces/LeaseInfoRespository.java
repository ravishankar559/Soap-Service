package com.sample.soapservice.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.sample.soapservice.Entity.LeaseInfo;
import com.sample.soapservice.Entity.LeaseInfoPrimaryKey;

@Component
public interface LeaseInfoRespository extends JpaRepository<LeaseInfo, LeaseInfoPrimaryKey> {

	@Query("select lea from LeaseInfo lea where lea.leaseInfoPrimaryKey.accessoryId=:accessoryId")
	List<LeaseInfo> findAllByAccessoryId(String accessoryId);

}
