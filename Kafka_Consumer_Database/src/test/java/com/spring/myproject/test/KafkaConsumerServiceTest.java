package com.spring.myproject.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import com.spring.myproject.kafkaconsumer.service.KafkaConsumer;

@SpringBootTest(classes =KafkaConsumer.class)
@EmbeddedKafka(brokerProperties = {"listeners=PLAINTEXT://localhost:9092"})
public class KafkaConsumerServiceTest {
	
	@Autowired
	private KafkaConsumer kafkaConsumer;
	
	@Test
	void consume()
	{
		String message = "message recieved";
		String response = kafkaConsumer.consume(message);
		assertThat(response).contains(message);
	}

}
