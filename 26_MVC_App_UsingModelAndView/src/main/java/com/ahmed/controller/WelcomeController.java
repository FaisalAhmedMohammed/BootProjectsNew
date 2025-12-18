package com.ahmed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping(value = "/greet")
	public ModelAndView greet() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Hello How are You");
		mv.setViewName("greet");

		return mv;
	}

	@GetMapping(value = "/welcome")
	public ModelAndView Welcome() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Welcome To Spring Web MVC");
		mv.setViewName("index");

		return mv;
	}

}
