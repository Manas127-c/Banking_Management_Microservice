package com.banking.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.authservice.entity.User;
import com.banking.authservice.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerNewUser(@RequestBody User user){
		return new ResponseEntity<User>(this.userService.createUser(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId){
		return new ResponseEntity<String>(this.userService.deleteUser(userId), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user){
		return new ResponseEntity<String>(this.userService.loginUser(user), HttpStatus.OK);
	}
}
