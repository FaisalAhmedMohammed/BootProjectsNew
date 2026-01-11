package com.ahmed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmed.entity.User;
import com.ahmed.service.UserService;

@Controller(value = "usrController")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping(value = "/") // any initial request comes from the client this handler method send the form
	public String loadForm(Model model) {

		User user = new User();// form object
		model.addAttribute("user", user); // here sending empty object to map to form fields
		return "index";
	}

	@PostMapping(value = "/user") // when we submit the form request will come to this url
	public String OpenForm(User user, Model model) {
		boolean ispresent = service.saveUser(user);
		if (ispresent) {
			model.addAttribute("smsg", "User is Saved in Data Base");
		} else {
			model.addAttribute("emsg", "User is Not Saved In DB");

		}

		return "index";
	}

	@GetMapping(value = "/users")
	public String getUsers(Model model) {
		List<User> allUsers = service.getAllUsers();

		model.addAttribute("users", allUsers);

		return "users";
	}

	@GetMapping(value = "delete/{id}")
	public String removeUserById(@PathVariable Long id, Model model) {

		boolean deleteById = service.deleteById(id);

		if (deleteById) {
			model.addAttribute("deleted", "User Deleted Successfully");//after deleting the recored then sending latest records to view
			List<User> allUsers = service.getAllUsers();
			model.addAttribute("users", allUsers);
		} else {
			model.addAttribute("notdeleted", "User not found ");
		}
		return "users";
	}

}
