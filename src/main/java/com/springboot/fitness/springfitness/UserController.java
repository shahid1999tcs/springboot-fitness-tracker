package com.springboot.fitness.springfitness;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
	@Transactional(rollbackFor = Exception.class)
	public void saveUser(@RequestBody User user) {
		userRepo.save(user);
	}

	@GetMapping("/users")
	private Iterable<User> getusers() {
		return userRepo.findAll();
	}

	@GetMapping("/users/{id}")
	public User getuser(@PathVariable("id") Integer id) {
		Optional<User> useroptional = userRepo.findById(id);
		User user = new User();
		if(useroptional.isPresent()) {
			user = useroptional.get();
		}
		return user;
	}
}
