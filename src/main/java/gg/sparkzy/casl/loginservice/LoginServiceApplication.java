package gg.sparkzy.casl.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * Login micro-service main for CASL
 * 
 * @author Bobby McGetrick
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

}
