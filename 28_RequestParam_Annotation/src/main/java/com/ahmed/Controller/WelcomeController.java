package com.ahmed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/*Request parameter is also called as query parameter 
 * it helps retrive values from the url like http://localhost:8081/welcome?name=ahmed
 * 
 * @Request Param annotation is used to bind the query name with to the mehtod parameter
 * it is used to send the data from client to server
 * @Request parameters will represent the data in the form of key and value fromat
 * 
 *  Request parameter will start with ? and will seperated by &
 *  To read the values from the URL we will use @Request param annotation in method */
@Controller
@ResponseBody
public class WelcomeController {

	@GetMapping(value = "/welcome")
	public String Welcome(@RequestParam("name") String name) {
		return name + " Welcome to MVC Application Development ";
	}

}
