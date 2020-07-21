package com.demo.registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.registration.model.UsersEntity;

public interface RegistrationRepository extends JpaRepository<UsersEntity, Long> {
	

}
