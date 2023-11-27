package com.sangamone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangamone.entity.LeaveCompanyEntity;
import com.sangamone.repository.CompanyRepository;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;
	
	@PostMapping("/addCompany")
	public ResponseEntity<LeaveCompanyEntity> createLeaveCompany(@RequestBody LeaveCompanyEntity leaveCompany){
		LeaveCompanyEntity savedCompany = companyRepository.save(leaveCompany);
		return new ResponseEntity<>(savedCompany,HttpStatus.CREATED);
	}
	
	@GetMapping("viewCompanies")
	public ResponseEntity<List<LeaveCompanyEntity>> getCompanyDetails(){
		List<LeaveCompanyEntity> companiesList = companyRepository.findAll();
		return new ResponseEntity<>(companiesList,HttpStatus.OK);
	}
	
	@GetMapping("viewCompanyById/{company_id}")
	public List<LeaveCompanyEntity> viewCompanyById(@PathVariable("company_id") int company_id){
		return companyRepository.viewCompanyById(company_id);
	}
}
