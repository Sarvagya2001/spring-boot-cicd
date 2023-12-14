package com.sarvagya.employeemanagementbackend.controller;

import com.sarvagya.employeemanagementbackend.exception.UserNotFoundException;
import com.sarvagya.employeemanagementbackend.model.User;
import com.sarvagya.employeemanagementbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;



@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	User getUserId(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return userRepository.findById(id)
				.map(user -> {
					user.setUsername(newUser.getUsername());
					user.setEmail(newUser.getEmail());
					user.setName(newUser.getName());
					return userRepository.save(user);
				}).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!userRepository.existsById(id)) {   //no user with that id
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
		return " User Deleted with ID " +id ;
	}
	
}
