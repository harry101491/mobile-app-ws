package com.harshit.mobileappws;

import com.harshit.mobileappws.config.ApplicationConfigYML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MobileAppWsApplication {

	@Autowired
	private ApplicationConfigYML currentConfig;

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}
}
