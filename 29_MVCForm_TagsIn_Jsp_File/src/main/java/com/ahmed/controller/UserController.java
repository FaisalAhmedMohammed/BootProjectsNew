package com.ahmed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmed.model.User;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping(value = "/login")
	public String getFormPage(Model model) {

		User user = new User();

		model.addAttribute("user", user);// here placing object inside the object for binding

		return "user1";
	}

	@PostMapping(value = "/register")
	public String hadleForm(@Valid @ModelAttribute User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user1";
		} else {
			model.addAttribute("username", user.getUsername());
			model.addAttribute("email", user.getEmail());
			model.addAttribute("mobile", user.getMobile());
			model.addAttribute("gender", user.getGender());
			model.addAttribute("dob", user.getDob());

			return "UserDetails";

		}

	}

}
