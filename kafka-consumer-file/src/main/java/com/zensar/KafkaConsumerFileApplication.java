package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class KafkaConsumerFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerFileApplication.class, args);
	}

}
