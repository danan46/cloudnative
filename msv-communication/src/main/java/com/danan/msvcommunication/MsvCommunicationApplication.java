package com.danan.msvcommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvCommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvCommunicationApplication.class, args);
	}

}
