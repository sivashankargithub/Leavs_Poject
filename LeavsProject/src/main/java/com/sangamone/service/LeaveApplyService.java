package com.sangamone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangamone.entity.LeaveApplyEntity;
import com.sangamone.repository.LeaveApplyRepo;

@Service
public class LeaveApplyService {
	@Autowired
	LeaveApplyRepo leaveApplyRepo;
	
	public LeaveApplyEntity leaveApply(LeaveApplyEntity leaveApplyEntity) {
		leaveApplyEntity.setStatus("Pending");
		return leaveApplyRepo.save(leaveApplyEntity);
	}

}
