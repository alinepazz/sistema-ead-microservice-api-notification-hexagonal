package com.br.eadnotificationhexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EadNotificationHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EadNotificationHexagonalApplication.class, args);
	}

}
