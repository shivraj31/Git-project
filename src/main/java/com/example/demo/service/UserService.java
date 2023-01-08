package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	// post
	User createUser(User user);

	// get
	List<User> getUser();

	// getByName
	User getUserByName(String UserName);

	// getById
	User getUserById(Integer Id);

	// Update
	User updateUser(User user, Integer Id);

	// delete
	void deleteUser(Integer Id);

}
