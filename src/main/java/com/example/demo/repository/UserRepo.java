package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "select * from users where user_name=?1", nativeQuery = true)

	User getUser(String userName);
}
