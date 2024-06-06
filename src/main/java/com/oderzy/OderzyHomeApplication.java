package com.oderzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan
@EnableFeignClients
public class OderzyHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OderzyHomeApplication.class, args);
	}

}
