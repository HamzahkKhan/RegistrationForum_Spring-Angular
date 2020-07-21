package com.demo.registration.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.registration.model.Users_InfoEntity;
import com.demo.registration.repository.UserInfoRepository;

@Service
public class UserInfoServices {

	@Autowired
	UserInfoRepository repository;

	public Users_InfoEntity addUser(Users_InfoEntity entity) {

		entity = repository.save(entity);

		return entity;

	}

	public void deleteUserByUser_id(long id) {

		repository.deleteUser(id);

	}

	public Optional<Users_InfoEntity> findById(long id) {

		return repository.findById(id);
	}

	public Users_InfoEntity getUserInfoBy_UserId(long id) throws Exception {

		Users_InfoEntity user = repository.SelectUserBy_User_Id(id);

		if (user != null) {
			return user;
		} else {
			throw new Exception("No employee record exist for given id");
		}

	}

	public Users_InfoEntity UpdateUser(Users_InfoEntity updateuser) throws Exception {

		Optional<Users_InfoEntity> UpdateEntity = findById(updateuser.getId());

		if (UpdateEntity.isPresent()) {

			Users_InfoEntity UpUser = UpdateEntity.get();
			UpUser.setAddress(updateuser.getAddress());
			UpUser.setDob(updateuser.getDob());
			UpUser.setNationality(updateuser.getNationality());
			UpUser.setPhonenumber(updateuser.getPhonenumber());
			UpUser = repository.save(UpUser);
			return UpUser;

		} else {

			throw new Exception("No employee record exist for given id");
		}

	}

}
