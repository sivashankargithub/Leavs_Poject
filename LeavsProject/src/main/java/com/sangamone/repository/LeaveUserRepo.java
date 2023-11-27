package com.sangamone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sangamone.entity.LeaveUserEntity;

public interface LeaveUserRepo extends CrudRepository<LeaveUserEntity, Integer> {

	@Query(value="select * from company_user where user_id=:user_id",nativeQuery = true)
	List<LeaveUserEntity> viewUserById(int user_id);
}
