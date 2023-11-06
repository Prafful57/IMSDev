package ims.dev.controller;

import java.util.List;

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
import lombok.extern.slf4j.Slf4j;

//@ApiModel(description = "Users Controller Api")
@Slf4j
@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersService userService;

	@Autowired
	private UsersRepo userRepo;

	@GetMapping("/get-users")
	public List<Users> getAllUsers() {
		log.info("Get Users Api Working");
		return userService.getAllUsers();
	}

//	@ApiModelProperty(notes="Post Api to save user")
	@PostMapping("/save-user")
	public ResponseEntity<?> saveUser(@RequestBody Users user) {
//		Throwable debugMessage = new Exception("Received a user: ");
//		log.debug( "Saving the user ", user);
		log.debug("Saving the user : ",user);
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}

	@DeleteMapping("/delete-user/{user_id}")
	public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
		log.debug("Deleting user with userId : ", user_id);
		boolean userId = userRepo.existsById(user_id);
		if (userId == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(user_id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/update-user/{user_id}")
	public ResponseEntity<Users> updateUser(@PathVariable int user_id, @RequestBody Users user) {
		boolean userId = userRepo.existsById(user_id);
		if (userId == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Users user1 = userRepo.findById(user_id).get();
		user1.setUserName(user.getUserName());
		user1.setUserPass(user.getUserPass());
		user1.setUserRole(user.getUserRole());
		userRepo.save(user1);
		log.debug("user data is updated to : ", user1);
		return ResponseEntity.accepted().body(user1);
	}

}
