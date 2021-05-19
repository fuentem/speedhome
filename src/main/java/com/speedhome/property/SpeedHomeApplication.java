package com.speedhome.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.speedhome.property"})
@EnableAutoConfiguration
public class SpeedHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeedHomeApplication.class, args);
	}

}
