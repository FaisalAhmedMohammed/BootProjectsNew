package com.ahmed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.User;
import com.ahmed.repository.UserRepo;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public boolean saveUser(User user) {

		User save = userRepo.save(user);
		return save.getId() != null; // if the user is saved then it is not null
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> byId = userRepo.findById(id);// findbyId return the entity with the given id
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) {

		if (userRepo.existsById(id)) {// existbyId method returns true if an entity with the given id
			// exists, other wise false
			userRepo.deleteById(id);// if recored exist then delete
			return true;
		} else {
			return false;
		}

	}

}
