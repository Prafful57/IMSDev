package ims.dev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ims.dev.entity.Users;
import ims.dev.repo.UsersRepo;
import ims.dev.service.UsersService;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("users")
public class UsersController {

	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private UsersRepo userRepo;
	
	@GetMapping("/get-users")
	public List<Users> getAllUsers(){
		log.info("Get Users Api Working");
		return userService.getAllUsers();
	}
	
	@PostMapping("/save-user")
	public ResponseEntity<HttpStatus> saveUser(@RequestBody Users user) {
		Throwable debugMessage = new Exception("Received a user: ");
		log.debug( user, debugMessage);
		userService.saveUser(user);
		return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete-user/{user_id}")
	public ResponseEntity<String> deleteUser(@PathVariable int user_id){
		userService.deleteUser(user_id);
		return ResponseEntity.accepted().body("Deleted Successfully");
	}
	
	@PutMapping("/update-user/{user_id}")
	public ResponseEntity<Users> updateUser(@PathVariable int user_id, @RequestBody Users user){
		
		Users user1 = userRepo.findById(user_id).get();
		user1.setUser_name(user.getUser_name());
		user1.setUser_pass(user.getUser_pass());
		user1.setUser_role(user.getUser_role());
		userRepo.save(user1);
		log.info("user data is updated");
		return ResponseEntity.accepted().body(user1);
	}
	
}
