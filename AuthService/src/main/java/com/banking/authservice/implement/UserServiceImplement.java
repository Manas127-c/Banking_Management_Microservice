package com.banking.authservice.implement;

import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.authservice.entity.User;
import com.banking.authservice.exception.UserNotFoundException;
import com.banking.authservice.jwt.JwtService;
import com.banking.authservice.repository.UserRepository;
import com.banking.authservice.service.UserService;

@Service
public class UserServiceImplement implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

	@Override
	public User createUser(User user) {
		user.setUserPassword(this.bCryptPasswordEncoder.encode(user.getUserPassword()));
		return this.userRepository.save(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		return this.userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Data Not Found"));
	}

	@Override
	public User updateUser(int userId, User user) {
		User currentUser=this.userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Data Not Found"));
		currentUser.setUserName(user.getUserName());
		currentUser.setUserPassword(user.getUserPassword());
		currentUser.setUserRole(user.getUserRole());
		return this.userRepository.save(currentUser);
	}

	@Override
	public String deleteUser(int userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Data Not Found"));
		this.userRepository.delete(user);
		return "User Data Deleted";
	}

	@Override
	public String loginUser(User user) {
		Authentication authentication=this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						user.getUserName(),
						user.getUserPassword()
						)
				);
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user);
		}else {
			return "failed";
		}
	}

}
