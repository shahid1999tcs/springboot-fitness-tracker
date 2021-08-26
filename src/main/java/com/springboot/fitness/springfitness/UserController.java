package com.springboot.fitness.springfitness;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	IUserRepository userRepo;
	
	@PostMapping("/users")
	public void saveUser(@RequestBody User user) {
		userRepo.save(user);
	}
	
	@GetMapping("/users")
	private Iterable<User> getusers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	private User getuser(@PathVariable("id") Integer id) {
		Optional<User> user = userRepo.findById(id);
		return user.get();
	}
}
