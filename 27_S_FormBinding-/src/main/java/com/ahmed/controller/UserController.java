package com.ahmed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmed.model.User;

@Controller
public class UserController {

	@GetMapping(value = "/form")
	public String LoadForm(Model model) {

		User user = new User();

		model.addAttribute("user", user);

		return "user";
	}

	@PostMapping("/register")
	public String SubmitForm(@ModelAttribute User user, Model model) {

		model.addAttribute("username", user.getUsername());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("mobile", user.getMobile());
		model.addAttribute("gender", user.getGender());

		return "userdetails";

	}

}
