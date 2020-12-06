package gg.sparkzy.casl.loginservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import gg.sparkzy.casl.loginservice.entities.User;
import gg.sparkzy.casl.loginservice.services.LoginService;

@RestController
@RequestMapping("/login")
@RefreshScope // actuator/refresh
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping
	@HystrixCommand(
			fallbackMethod = "fallbackFindByUsername",
			threadPoolKey = "userPool",
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "20"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			})
	public User findUserByUsername(@PathVariable("username") String username) {
		return loginService.findByUsername(username);
	}
	
	public User fallbackFindByUsername(String username) {
		return new User(0, "No user with username " + username, null, null, null, null);
	}
	
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
