package com.banking.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.authservice.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserNameAndUserPassword(String userName, String userPassword);
	User findByUserName(String userName);
}
