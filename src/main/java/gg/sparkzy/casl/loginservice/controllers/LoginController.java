package gg.sparkzy.casl.loginservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RefreshScope // actuator/refresh
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	
	/************************************************************************************
	 * Read
	 ************************************************************************************/
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	
}
