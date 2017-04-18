package com.ionic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.ionic"})
public class IonicCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(IonicCoreApplication.class, args);
	}
}
