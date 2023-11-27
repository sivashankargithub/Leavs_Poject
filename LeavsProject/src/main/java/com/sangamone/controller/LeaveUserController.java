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

import com.sangamone.entity.LeaveUserEntity;
import com.sangamone.repository.LeaveUserRepo;

@RestController
@RequestMapping("/api/user")
public class LeaveUserController {
	
	@Autowired
	private LeaveUserRepo leaveUserRepo;
	
	@PostMapping("/addUser")
	public ResponseEntity<LeaveUserEntity> addUser(@RequestBody LeaveUserEntity leaveUserEntity) {
		LeaveUserEntity saveUserEntity = leaveUserRepo.save(leaveUserEntity);
		return new ResponseEntity<>(saveUserEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<LeaveUserEntity>> viewAllUsers() {
		List<LeaveUserEntity> usersList= (List<LeaveUserEntity>) leaveUserRepo.findAll();
		return new ResponseEntity<>(usersList,HttpStatus.OK);
	}
	
	@GetMapping("/viewUserById/{user_id}")
	public List<LeaveUserEntity>viewUserById(@PathVariable ("user_id") int user_id){
		return leaveUserRepo.viewUserById(user_id);	
	}
}
