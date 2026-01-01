package com.ahmed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "emaiController")
@ResponseBody
public class EmailController {

	@Autowired
	private JavaMailSender mail;// it is an interface we should add this it as dependency

	@GetMapping(value = "/email")
	public String sendMail() {

		SimpleMailMessage simple = new SimpleMailMessage(); // it is an implementation class of JavaMailSender
		simple.setTo("mohammedahmedfaisal69@gmail.com");
		simple.setSubject("Welcom to Spirng Boot Email ");
		simple.setText("Thank for Joining US!!");

		mail.send(simple);// this method is used to send the mail

		return "Mail is send to the following EMail Id !!";
	}

}
