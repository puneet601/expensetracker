package com.project.ExpenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ExpenseTracker.entity.User;
import com.project.ExpenseTracker.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getAllUsers")
	private ResponseEntity<List<User>> listUsers(){
		return new ResponseEntity<>(userService.listUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{id}")
	private ResponseEntity<User> listUsers(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

		}
	}
	
	@PostMapping("/addUser")
	private ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.OK);
	}

}
