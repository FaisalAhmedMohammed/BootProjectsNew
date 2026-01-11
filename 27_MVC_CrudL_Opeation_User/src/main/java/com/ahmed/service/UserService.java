package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.User;

public interface UserService {

	boolean saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Long id);// this is used for edit it is used to get the complete user record based on id

	boolean deleteById(Long id);

}
