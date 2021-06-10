package com.idp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.idp.demo.services.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service; // = new LoginSerive();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String successLogin( @RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		
		if(!service.validateUser(name, password)) {
			model.put("message", "Invalid Creds");
			return "login";
		}
		return "welcome";
	}
	
	@RequestMapping("/welcome")
	@ResponseBody
	public String getMessage() {
		
		return "Welcome Ananymous User";
	}
	
	@RequestMapping("/welcome/user")
	public String getUserMessage( @RequestParam String name, ModelMap model) {
		System.out.println("NAME : "+name);
		model.put("name", name);
		
		return "welcome";
	}
}
