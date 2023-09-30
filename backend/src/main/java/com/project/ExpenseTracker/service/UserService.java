package com.project.ExpenseTracker.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.project.ExpenseTracker.dto.UserDto;
import com.project.ExpenseTracker.entity.User;

@Service
public interface UserService extends UserDetailsService{	

	List<User> listUsers();

	User getUserById(Long id) throws Exception;

	User login(UserDto userDto);

}
