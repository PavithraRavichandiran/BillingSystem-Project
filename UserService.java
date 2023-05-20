package com.edubridge.service;

import java.util.List;
import java.util.Optional;

import com.edubridge.entity.User;

public interface UserService {
public User registerUser(User user);
public User loginUser(User user);
public List<User> showAllUsers();
public void removeUser(int userId);
public User updateUser(int userId,User user);
public User getUserById(int userId);
}
