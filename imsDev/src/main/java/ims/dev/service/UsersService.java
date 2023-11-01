package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Users;
import ims.dev.repo.UsersRepo;

@Service
public class UsersService {

	@Autowired
	private UsersRepo userRepo;
	
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}

	public void saveUser(Users user) {
		userRepo.save(user);
	}

	public void deleteUser(int user_id) {
		userRepo.deleteById(user_id);
	}

}
