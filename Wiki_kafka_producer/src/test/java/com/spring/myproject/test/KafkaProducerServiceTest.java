package com.spring.myproject.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.spring.myproject.kafkaproducer.service.KafkaProducerService;

@SpringBootTest(classes = KafkaProducerService.class)
//@EmbeddedKafka( brokerProperties = {"listeners=PLAINTEXT://localhost:9092"})
@Testcontainers
@ContextConfiguration(classes = KafkaTestConfig.class)
public class KafkaProducerServiceTest {
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@MockBean
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Test
	public void sendMessageTest() throws InterruptedException
	{
		
		String message = kafkaProducerService.sendMessage();
		assertThat(message).contains("send message successfully");
		
		
	}

}
