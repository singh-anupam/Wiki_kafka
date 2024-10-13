package com.spring.myproject.test;

import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;



@Configuration
public class KafkaTestConfig {
	
	@Container
	static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"));
	
	static {
		kafka.start();
		System.out.println("kafka port"+kafka.getBootstrapServers());
		System.setProperty("spring.kafka.bootstrap-servers",kafka.getBootstrapServers());
	}

}
