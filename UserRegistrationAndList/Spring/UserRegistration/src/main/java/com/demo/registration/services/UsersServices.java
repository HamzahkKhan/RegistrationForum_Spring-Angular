package com.demo.registration.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.registration.model.UsersEntity;
import com.demo.registration.repository.RegistrationRepository;

@Service
public class UsersServices {

	@Autowired
	RegistrationRepository repository;

	public List<UsersEntity> getAll() {

		List<UsersEntity> registrationEntities = repository.findAll();

		if (registrationEntities.size() > 0) {
			return registrationEntities;
		} else {
			return new ArrayList<UsersEntity>();
		}

	}

	public UsersEntity addUser(UsersEntity entity) {

		entity = repository.save(entity);

		return entity;	

	}

	public Optional<UsersEntity> delete(long id) {
		
        Optional<UsersEntity> user = findById(id);
        
        if(user != null){
            repository.deleteById(id);
        }
        return user;
    }
	
	public UsersEntity UpdateUser (UsersEntity updateuser) {
		
		Optional<UsersEntity> registrationEntity = findById(updateuser.getId());
		
		if (registrationEntity.isPresent()) {
			
			UsersEntity UpUser = registrationEntity.get();
			
			UpUser.setUsername(updateuser.getUsername());
			
			UpUser = repository.save(UpUser);
			return UpUser;
			
		} else {
			
			return updateuser;
		}
		
		
		
	}
	
	public Optional<UsersEntity> findById(long id) {
		
        return repository.findById(id);
    }

	public UsersEntity getUserById(long id) throws Exception {
		
		 Optional<UsersEntity> user = findById(id);
		 
		 if(user.isPresent()) {
	            return user.get();
	        } else {
	            throw new Exception("No employee record exist for given id");
	        }
		
	}
}
