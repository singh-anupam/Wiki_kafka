package com.spring.myproject.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.myproject.kafkaproducer.service.KafkaProducerService;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerApplication.class);
	}

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@Override
	public void run(String... args) throws Exception {
		kafkaProducerService.sendMessage();
	}
}
