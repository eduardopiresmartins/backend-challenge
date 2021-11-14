package com.eduardopires.passwordchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardopires.passwordchallenge.repositories.UserRepository;

@Service 
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
}
