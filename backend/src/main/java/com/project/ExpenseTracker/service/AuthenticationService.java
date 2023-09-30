package com.project.ExpenseTracker.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ExpenseTracker.dto.UserDto;
import com.project.ExpenseTracker.entity.User;
import com.project.ExpenseTracker.models.LoginResponseDTO;

@Service
@Transactional
public interface AuthenticationService {

	LoginResponseDTO login(UserDto userDto);

	User registerUser(User user);

}