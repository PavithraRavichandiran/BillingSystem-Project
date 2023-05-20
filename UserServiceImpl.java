package com.edubridge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edubridge.entity.User;
import com.edubridge.repository.UserRepository;
@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		
		return  userRepository.save(user);
	}

	@Override
	public List<User> showAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("55555555555555555555555555555");
		return userRepository.findAll();
	}

	@Override
	public void removeUser(int userId) {
		// TODO Auto-generated method stub
	userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(int userId, User user) {
		System.out.println(user +"userId" +userId);
		User user1=getUserById(userId);
		user1.setUserName(user.getUserName());
		user1.setRole(user.getRole());
		user1.setPassWord(user.getPassWord());
		//System.out.println("55555555555555555555 " +user1);
		return userRepository.save(user1);
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.findById(userId).get();
		
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
	System.out.println("Login user service");	
		return userRepository.findByUserNameAndPassWord(user.getUserName(), user.getPassWord());
	}
	

}
