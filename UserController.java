package com.edubridge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.User;
import com.edubridge.service.UserService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return new ResponseEntity<User> (userService.registerUser(user),HttpStatus.CREATED);
	}
	@PostMapping("Login")
	public ResponseEntity<User> loginUser(@RequestBody User user){
		System.out.println("Inside login method");
		return new ResponseEntity<User> (userService.loginUser(user),HttpStatus.OK);
	}
	@GetMapping("/userlist")
	public List<User> showAllUsers(){
		
		
		 return userService.showAllUsers();
	}
	
	@DeleteMapping("{userId}")
	
	public ResponseEntity<Map<String, String>> removeUser(@PathVariable("userId") int userId){
	    userService.removeUser(userId);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "User deleted successfully");
	    return ResponseEntity.ok().body(response);
	}

	
     @GetMapping("{userId}")
public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
	userService.getUserById(userId);
	return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
}
     @PutMapping("/user/update/{userId}")
     public ResponseEntity<User> updateUser(@PathVariable("userId") int userId,@RequestBody User user){
    	 //System.out.println(user + " userId" +userId);
    	 return new ResponseEntity<User>(userService.updateUser(userId, user),HttpStatus.OK);
     }
}
