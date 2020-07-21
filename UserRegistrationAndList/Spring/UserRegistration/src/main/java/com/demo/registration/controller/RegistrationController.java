package com.demo.registration.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.registration.model.User_UserInfoEntity;
import com.demo.registration.model.UsersEntity;
import com.demo.registration.model.Users_InfoEntity;
import com.demo.registration.services.UserInfoServices;
import com.demo.registration.services.UsersServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class RegistrationController {

	@Autowired
	UsersServices services;
	@Autowired
	UserInfoServices infoServices;
	
	

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<UsersEntity> getAll() {
		//System.out.print("Get All Created");
		return services.getAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@RequestBody UsersEntity entity) {



		services.addUser(entity);

		System.out.println(entity);

	}

	@DeleteMapping(path = { "/{id}" })
	public void delete(@PathVariable("id") long id) {
		infoServices.deleteUserByUser_id(id);
		services.delete(id);
		
	}

	@PutMapping(value = "/update/{id}")
	public void update(@RequestBody Users_InfoEntity user) throws Exception {
		
		//user = infoServices.getUserInfoBy_UserId(userId);
		infoServices.UpdateUser(user);
		
		System.out.print("Updated");
	}

	@RequestMapping(value = { "/UserById/{username}/{id}" }, method = RequestMethod.GET, produces = "application/json")
	public UsersEntity getUserById(@PathVariable("id") long id, @PathVariable("username") String username) throws Exception {

		UsersEntity user = services.getUserById(id);

		if (!(user != null))
			throw new Exception("Could not find employee with id- ");

		System.out.println("USERNAME " + username + " with ID: " + id + " Selected");
		return user;

	}
	
	@RequestMapping(value = { "/UserInfoById/{id}" }, method = RequestMethod.GET, produces = "application/json")
	public Users_InfoEntity getUserInfoById(@PathVariable("id") long id) throws Exception {


		Users_InfoEntity user = infoServices.getUserInfoBy_UserId(id);

		if (!(user != null))
			throw new Exception("Could not find employee with id- ");

		return user;

	}
	
	@RequestMapping(value = "/addnewUser", method = RequestMethod.POST)
	public void addUser_UserInfo(@RequestBody User_UserInfoEntity entity) {
		
		UsersEntity usersEntity = new UsersEntity();
		Users_InfoEntity users_InfoEntity = new Users_InfoEntity();
		
		usersEntity.setUsername(entity.getUsername());
		usersEntity.setUseremail(entity.getUseremail());
		usersEntity.setUserpassword(entity.getUserpassword());
		
		users_InfoEntity.setAddress(entity.getAddress());
		users_InfoEntity.setDob(entity.getDob());
		users_InfoEntity.setNationality(entity.getNationality());
		users_InfoEntity.setPhonenumber(entity.getPhonenumber());
		users_InfoEntity.setUsersEntity(usersEntity);
		
		services.addUser(usersEntity);
		infoServices.addUser(users_InfoEntity);
		

	}
	
}


	

