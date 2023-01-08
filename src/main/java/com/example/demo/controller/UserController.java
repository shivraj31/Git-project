package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	// post
	@PostMapping("/post")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		return new ResponseEntity(userServiceImpl.createUser(user), HttpStatus.CREATED);
	}

	// getByuserName
	@GetMapping("/get/{userName}")
	public ResponseEntity<User> getByUserName(@PathVariable String userName) {
		return new ResponseEntity(userServiceImpl.getUserByName(userName), HttpStatus.OK);
	}

	// getAll
	@GetMapping("/get")
	public ResponseEntity<User> getUser() {
		return new ResponseEntity(userServiceImpl.getUser(), HttpStatus.OK);
	}

	// update
	@PutMapping("/update/{Id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer Id) {
		return new ResponseEntity(userServiceImpl.updateUser(user, Id), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{Id}")
	public void deleteUser(@PathVariable Integer Id) {

		userServiceImpl.deleteUser(Id);
	}

}
