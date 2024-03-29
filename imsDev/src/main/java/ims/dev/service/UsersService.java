package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Users;
import ims.dev.repo.UsersRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersService {

	@Autowired
	private UsersRepo userRepo;
	
	public List<Users> getAllUsers() {
		log.info("Getting all users from repo");
		return userRepo.findAll();
	}

	public void saveUser(Users user) {
		log.debug("Saving user in repo : ",user);
		userRepo.save(user);
	}

	public void deleteUser(int user_id) {
		log.debug("Deleting user with userId : ",user_id );
		userRepo.deleteById(user_id);
	}

}
