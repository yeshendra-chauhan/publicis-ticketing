package com.sapient.pst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sapient.pst.*" })
public class PstApplication {

	public static void main(String[] args) {
		SpringApplication.run(PstApplication.class, args);
	}

}
