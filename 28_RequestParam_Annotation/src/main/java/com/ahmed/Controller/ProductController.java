package com.ahmed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class ProductController {

	@GetMapping(value = "/prod")
	public String getProducts(@RequestParam String name) {
		return "This is  " + name + " Product ";
	}

}
