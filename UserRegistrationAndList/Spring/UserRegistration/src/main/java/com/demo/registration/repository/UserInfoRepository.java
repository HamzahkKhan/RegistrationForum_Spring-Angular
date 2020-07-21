package com.demo.registration.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.registration.model.Users_InfoEntity;


public interface UserInfoRepository extends JpaRepository<Users_InfoEntity, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM user_info WHERE user_id = :id", 
			  nativeQuery = true)
			void deleteUser(@Param("id") long id);
	
	
	@Query(value = "SELECT * FROM user_info WHERE user_id = :id", 
			  nativeQuery = true)
			Users_InfoEntity SelectUserBy_User_Id(@Param("id") long id);
	
}
