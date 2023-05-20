package com.edubridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edubridge.entity.User;

public interface UserRepository  extends JpaRepository<User,Integer>{
 public User findByUserName(String userName);
 public User findByUserNameAndPassWord(String userName,String passWord);
}
