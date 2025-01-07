package com.banking.authservice.security;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.banking.authservice.entity.User;
import com.banking.authservice.repository.UserRepository;

@Component
public class CustommUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userRepository.findByUserName(username);
		if(Objects.isNull(user)) {
			System.out.println("Not Availiable");
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

}
