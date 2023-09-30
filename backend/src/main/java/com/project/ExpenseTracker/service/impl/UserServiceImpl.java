package com.project.ExpenseTracker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.ExpenseTracker.dto.UserDto;
import com.project.ExpenseTracker.entity.User;
import com.project.ExpenseTracker.repository.UserRepository;
import com.project.ExpenseTracker.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	
	public List<User> listUsers() {
		return userRepo.findAll();
	}

	
	public User getUserById(Long id) throws Exception {
		Optional<User> findById = userRepo.findById(id);
		if(findById.isPresent())
		return findById.get();
		else 
			throw new Exception("User not found");
	}

	
	
	public User login(UserDto userDto) {
		User userFromDb = userRepo.findUserByEmail(userDto.getEmail());
		if (userFromDb != null) {
			String password = userDto.getPassword();
			String encodedPassword = userFromDb.getPassword();
			Boolean isCorrectPassword = passwordEncoder.matches(password, encodedPassword);
			if (isCorrectPassword) {
				return userFromDb;
			} else {
				throw new IllegalArgumentException("Incorrect Password!");
			}

		} else
			throw new IllegalArgumentException("User does not exist");
	}

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
		   
	}

}
