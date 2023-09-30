package com.project.ExpenseTracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ExpenseTracker.dto.UserDto;
import com.project.ExpenseTracker.entity.User;
import com.project.ExpenseTracker.models.LoginResponseDTO;
import com.project.ExpenseTracker.service.AuthenticationService;
import com.project.ExpenseTracker.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
	UserService userService;
	
    @PostMapping("/login")
	private ResponseEntity<LoginResponseDTO> login(@RequestBody UserDto user){
		return new ResponseEntity<LoginResponseDTO>(authenticationService.login(user),HttpStatus.OK);
	}
	
	@PostMapping("/registerUser")
	private ResponseEntity<User> registerUser(@RequestBody User user){
		return new ResponseEntity<User>(authenticationService.registerUser(user),HttpStatus.OK);
	}

}   