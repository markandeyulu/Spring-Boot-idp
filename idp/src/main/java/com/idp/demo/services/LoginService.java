package com.idp.demo.services;

import org.springframework.stereotype.Component;

//Spring Bean
@Component
public class LoginService {

	public boolean validateUser(String userid, String password) {
		
		return userid.equalsIgnoreCase("mark") && 
				password.equals("mk");
	}
}
