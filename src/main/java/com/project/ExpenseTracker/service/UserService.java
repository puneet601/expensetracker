package com.project.ExpenseTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ExpenseTracker.entity.User;
import com.project.ExpenseTracker.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

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

	public User addUser(User user) {		
		 User save = userRepo.save(user);
		 return save;
	}

}
