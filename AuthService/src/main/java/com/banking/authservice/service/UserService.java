package com.banking.authservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.authservice.entity.User;

@Service
public interface UserService {
	public User createUser(User user);
	public String loginUser(User user);
	public List<User> getAllUsers();
	public User getUserById(int userId);
	public User updateUser(int userId,User user);
	public String deleteUser(int userId);
}
