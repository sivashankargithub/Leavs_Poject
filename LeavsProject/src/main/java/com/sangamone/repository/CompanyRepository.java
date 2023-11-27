package com.sangamone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sangamone.entity.LeaveCompanyEntity;

public interface CompanyRepository extends JpaRepository<LeaveCompanyEntity, Integer> {
	@Query(value = "select * from leavs_companies where company_id=:company_id",nativeQuery = true)
	List<LeaveCompanyEntity> viewCompanyById(int company_id);
}
