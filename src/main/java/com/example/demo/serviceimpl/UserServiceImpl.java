package com.example.demo.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidInput;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo addressRepo;

	@Override
	@Transactional
	public User createUser(User user) {

		User user1 = userRepo.save(user);
		// address entity for binding data for transaction management
//		Address address = new Address();
//		address.setStreetName("DPU medical college Road");
//		address.setCity("Pimpary-Chinchwad");
//		address.setUser(user1);
//		addressRepo.save(address);
	return user1;
	}

	@Override
	public User getUserByName(String userName) {
		User user = userRepo.getUser(userName);
		if (user == null) {
			throw new InvalidInput("Invalid Username : " + userName + "  ?" + "\n" + "Enter the correct User Name");
		}
		return user;
	}

	@Override
	public List<User> getUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Integer Id) {
		User user = userRepo.findById(Id).get();
		if (user == null) {
			throw new InvalidInput("Invalid Username : " + Id + "  ?" + "\n" + "Enter the correct User Id");
		}
		return user;
	}

	@Override
	public User updateUser(User user, Integer Id) {
		User newUser = userRepo.findById(Id).get();
		if (user == null) {
			throw new InvalidInput("Invalid Username : " + Id + "  ?" + "\n" + "Enter the correct User Id");
		}
		newUser.setUserId(user.getUserId());
		newUser.setUserName(user.getUserName());
		return userRepo.save(newUser);

	}

	@Override
	public void deleteUser(Integer Id) {
		userRepo.deleteById(Id);
	}
}
